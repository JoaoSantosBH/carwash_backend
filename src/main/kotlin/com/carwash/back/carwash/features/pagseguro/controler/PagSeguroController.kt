package com.carwash.back.carwash.features.pagseguro.controler

import com.carwash.back.carwash.features.address.model.AddressEntity
import com.carwash.back.carwash.features.address.service.AddressService
import com.carwash.back.carwash.features.pagseguro.model.order.AmountQrCode
import com.carwash.back.carwash.features.pagseguro.model.order.Charge.Companion.mapingCharge
import com.carwash.back.carwash.features.pagseguro.model.order.Customer.Companion.mapCustomer
import com.carwash.back.carwash.features.pagseguro.model.order.Item.Companion.mapItems
import com.carwash.back.carwash.features.pagseguro.model.order.PaymentCardModel
import com.carwash.back.carwash.features.pagseguro.model.order.QrCode
import com.carwash.back.carwash.features.pagseguro.model.order.Shipping.Companion.mapShipping
import com.carwash.back.carwash.features.pagseguro.model.order.card.request.PagSegCardOrderRequest
import com.carwash.back.carwash.features.pagseguro.model.order.card.request.PagSegCardOrderRequest.Companion.mappingCardOrderRequest
import com.carwash.back.carwash.features.pagseguro.model.order.card.response.PagSegCardResponse
import com.carwash.back.carwash.features.pagseguro.model.order.pix.request.PagSegPixOrderRequest
import com.carwash.back.carwash.features.pagseguro.model.order.pix.request.PagSegPixOrderRequest.Companion.mappingPixOrderRequest
import com.carwash.back.carwash.features.pagseguro.model.order.pix.response.PagSegPixResponse
import com.carwash.back.carwash.features.pagseguro.service.PagSeguroService
import com.carwash.back.carwash.features.scheduling.service.SchedulingServices
import com.carwash.back.carwash.features.user.model.UserEntity
import com.carwash.back.carwash.features.user.service.UserService
import com.carwash.back.carwash.features.vehicles.service.VehicleServices
import com.carwash.back.carwash.features.wash.service.WashServices
import com.carwash.back.carwash.utils.Constants
import com.carwash.back.carwash.utils.Constants.EMPTY_STRING
import com.carwash.back.carwash.utils.Constants.SYSTEM_VENDOR_PARCEL
import com.carwash.back.carwash.utils.Constants.WASH_DESC_ASPIRE
import com.carwash.back.carwash.utils.Constants.WASH_DESC_LITTTLE
import com.carwash.back.carwash.utils.Constants.WASH_DESC_SILICON
import com.carwash.back.carwash.utils.Constants.WASH_DESC_WAX
import com.carwash.back.carwash.utils.Constants.ZERO_INT
import com.carwash.back.carwash.utils.Endpoints.PAYMENT_CARD_ENDPOINT
import com.carwash.back.carwash.utils.Endpoints.PAYMENT_ENDPOINT
import com.carwash.back.carwash.utils.Endpoints.PAYMENT_PIX_ENDPOINT
import com.carwash.back.carwash.utils.TypeCarSizeEnum
import com.carwash.back.carwash.utils.TypeServiceEnum
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(PAYMENT_ENDPOINT)
class PagSeguroController {

    @Autowired
    private lateinit var service: PagSeguroService

    @Autowired
    private lateinit var schedulingServices: SchedulingServices

    @Autowired
    private lateinit var vehicleServices: VehicleServices

    @Autowired
    private lateinit var washServices: WashServices

    @Autowired
    private lateinit var addressService: AddressService

    @Autowired
    private lateinit var userService: UserService

    var description = EMPTY_STRING
    var title = EMPTY_STRING

    @PostMapping(PAYMENT_PIX_ENDPOINT)
    fun createPixOrder(
        @RequestBody payment: PaymentCardModel,
        @PathVariable userId: Long
    ): PagSegPixResponse? {
        return service.callPixOrderApi(generatePixOrderRequest(payment, userId))
    }

    @PostMapping(PAYMENT_CARD_ENDPOINT)
    fun createCardOrder(
        @RequestBody payment: PaymentCardModel,
        @PathVariable userId: Long
    ): PagSegCardResponse? {
        return service.callCardOrderApi(generateCardOrderRequest(payment, userId))
    }


    private fun generatePixOrderRequest(payment: PaymentCardModel, userId: Long): PagSegPixOrderRequest { //TODO RequestBody

        val user = userService.fetchUserById(userId) ?: UserEntity.DUMB_USER
        //TODO Scheduling novo
        val valueTax = priceThisWashService(userId)

        val address = addressService.fetchUserAddress(user.idUser) ?: AddressEntity.EMPTY_ADDRESS
        val schedule =
            schedulingServices.fetchAllScheduleByClientId(user.idUser)[ZERO_INT] //TODO fazer meio melhor de identificacao
        val referenceId = makeReferenceId(schedule)
        val customer = mapCustomer(payment.taxId, user)
        val items = mapItems(referenceId, valueTax, title)
        val notificationUrls = Constants.MY_NOTIFICATION_URI
        val qrCodes = listOf(QrCode(amount = AmountQrCode(valueTax)))
        val shipping = mapShipping(address)

        return mappingPixOrderRequest(customer, items, notificationUrls, qrCodes, shipping)
    }

    private fun generateCardOrderRequest(payment: PaymentCardModel, userId: Long): PagSegCardOrderRequest {

        val user = userService.fetchUserById(userId) ?: UserEntity.DUMB_USER
        //TODO Scheduling novo
        val valueTax = priceThisWashService(userId)

        val address = addressService.fetchUserAddress(user.idUser) ?: AddressEntity.EMPTY_ADDRESS
        val schedule =
            schedulingServices.fetchAllScheduleByClientId(user.idUser)[ZERO_INT] //TODO fazer meio melhor de identificacao
        val referenceId = makeReferenceId(schedule)
        val charge = mapingCharge(valueTax, payment, referenceId)
        val customer = mapCustomer(payment.taxId, user)
        val items = mapItems(referenceId,valueTax, title)
        val notificationUrls = Constants.MY_NOTIFICATION_URI
        val qrCodes = listOf(QrCode(amount = AmountQrCode(valueTax)))
        val shipping = mapShipping(address)

        return mappingCardOrderRequest(charge, customer, items, notificationUrls, qrCodes, shipping)
    }

    fun priceThisWashService(userId: Long): Int {
        //TODO pegar de Schedule
        val choosedWash = TypeCarSizeEnum.GRANDE.type

        val choosedValue = when (choosedWash) {
            TypeCarSizeEnum.PEQUENO.type -> 20
            TypeCarSizeEnum.MEDIO.type -> 40
            TypeCarSizeEnum.GRANDE.type -> 60
            else -> ZERO_INT
        }
        var valueTax = ZERO_INT
        //TODO pegar de Schedule: aspire, blackie, silicon, wax (ou remote config)
        val schedule = schedulingServices.fetchAllScheduleByClientId(userId)[ZERO_INT]//TODO  query pra trazer somente ativa
        val wash = washServices.fetchWashById(schedule.washId)
        val aspire = if (wash.aspire) 20 else ZERO_INT             //TODO colocar no SQL ou remote CONFIG
        val blackie = if (wash.pneuLittleBack) 10 else ZERO_INT    //TODO colocar no SQL ou remote CONFIG
        val silicon = if (wash.silicone) 20 else ZERO_INT          //TODO colocar no SQL ou remote CONFIG
        val wax = if (wash.wax) 35 else ZERO_INT                   //TODO colocar no SQL ou remote CONFIG
        val isAllServiceInclude = wash.aspire && wash.pneuLittleBack && wash.silicone && wash.wax

        if (isAllServiceInclude) makeTitleAndDescription(true) else makeTitleAndDescription(false)
        addingDetailedDescriptions(wash.aspire, wash.pneuLittleBack, wash.silicone, wash.wax)

        val extras = (aspire + blackie + silicon + wax)
        valueTax += choosedValue
        valueTax += extras

        var finalValue = valueTax / SYSTEM_VENDOR_PARCEL

        finalValue = prepareFraction(finalValue)

        return finalValue.addDoubleZeroCurrency()

    }

    private fun addingDetailedDescriptions(aspire: Boolean, pneuLittleBack: Boolean, silicone: Boolean, wax: Boolean) {
        if (aspire) description += WASH_DESC_ASPIRE
        if (pneuLittleBack) description +=  WASH_DESC_LITTTLE
        if (silicone) description +=  WASH_DESC_SILICON
        if (wax) description +=  WASH_DESC_WAX
        //todo add description on Schedulle
    }


    private fun makeTitleAndDescription(
        isAllIncludedService: Boolean
    ) {
        when (isAllIncludedService) {
            true -> {
                description = TypeServiceEnum.COMPLETA.description
                title = TypeServiceEnum.COMPLETA.title
            }

            else -> {
                description = TypeServiceEnum.PARCIAL.description
                title = TypeServiceEnum.PARCIAL.title
            }
        }
    }

}