package com.carwash.back.carwash.features.pagseguro.controler

import com.carwash.back.carwash.features.address.model.AddressEntity
import com.carwash.back.carwash.features.address.service.AddressService
import com.carwash.back.carwash.features.pagseguro.model.order.*
import com.carwash.back.carwash.features.pagseguro.model.order.card.PagSegCardOrderRequest
import com.carwash.back.carwash.features.pagseguro.model.order.card.response.PagSegCardResponse
import com.carwash.back.carwash.features.pagseguro.service.PagSeguroService
import com.carwash.back.carwash.features.scheduling.model.SchedulingEntity
import com.carwash.back.carwash.features.scheduling.service.SchedulingServices
import com.carwash.back.carwash.features.user.model.UserEntity
import com.carwash.back.carwash.features.user.service.UserService
import com.carwash.back.carwash.features.vehicles.service.VehicleServices
import com.carwash.back.carwash.features.wash.service.WashServices
import com.carwash.back.carwash.utils.*
import com.carwash.back.carwash.utils.Constants.EMPTY_STRING
import com.carwash.back.carwash.utils.Endpoints.PAYMENT_CARD_ENDPOINT
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
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

    @PostMapping(PAYMENT_CARD_ENDPOINT)
    fun createScheduling(@RequestBody payment: PaymentCardModel,
        @PathVariable userId: Long): PagSegCardResponse? {
        val request = pagSegCardOrderRequest(payment, userId)
        return service.makeCardRequest(request)
    }

    var  description = EMPTY_STRING
    var  title = EMPTY_STRING
    private fun pagSegCardOrderRequest(payment: PaymentCardModel, userId: Long): PagSegCardOrderRequest {

        val user = userService.fetchUserById(userId) ?: UserEntity.DUMB_USER
        //TODO Scheduling novo
        val valueTax = precificateService(userId)
//        val description = TypeServiceEnum.COMPLETA.description
//        val title = TypeServiceEnum.COMPLETA.title

        val address = addressService.fetchUserAddress(user.idUser) ?: AddressEntity.EMPTY_ADDRESS
        val schedule = schedulingServices.fetchAllScheduleByClientId(user.idUser)[0] //TODO fazer meio melhor de identificacao
        val referenceId = makeReferenceId(schedule)

        val charge = Charge(
            amount = Amount(currency = Constants.CURRENCY, value = valueTax),
            description = description,
            notificationUrls = Constants.MY_NOTIFICATION_URI,
            paymentMethod = PaymentMethod(
                type = TypePayEnum.CREDIT.value,
                card = Card(
                    number = payment.number,
                    expMonth = payment.expMonth,
                    expYear = payment.expYear,
                    securityCode = payment.securityCode,
                    holder = Holder(payment.holder),
                    store = false
                ),
                installments = payment.installments,
                capture = true,
            ),
            referenceId = referenceId
        )

        val customer = Customer(
            email = user.email,
            name = user.name,
            phones = listOf(
                Phone(
                    country = Constants.COUNTRY_CODE,
                    area = makeAreaSeparation(user.cellphone),
                    number = makePhoneSeparation(user.cellphone),
                    type = TypePhoneEnum.MOBILE.type
                )
            ),
            taxId = payment.taxId
        )


        val items = listOf(
            Item(
                name = title,
                quantity = 1,
                referenceId = referenceId,
                unitAmount = valueTax
            )
        )

        val notificationUrls = Constants.MY_NOTIFICATION_URI

        val qrCodes = listOf(QrCode(amount = AmountQrCode(valueTax)))
        val shipping = Shipping(
            address = Address(
                street = address.street,
                number = address.number,
                complement = address.complement,
                locality = address.neighborhood,
                city = address.city,
                regionCode = address.state,
                country = Constants.COUNTRY_PREFIX,
                postalCode = address.zip
            )
        )

        val request = PagSegCardOrderRequest(
            charges = listOf(charge),
            customer = customer,
            items = items,
            notificationUrls = notificationUrls,
            qrCodes = qrCodes,
            referenceId = makeReferenceId(SchedulingEntity.DUMB_SCHEDULE),
            shipping = shipping
        )
        return request
    }

    private fun precificateService(userId: Long): Int {

        val choosedValue = 30 //TODO pegar de Schedule
        var valueTax = 0
        makeTitleAndDescription(TypeCarSizeEnum.PEQUENO.type) //TODO pegar de Schedule

        val schedule = schedulingServices.fetchAllScheduleByClientId(userId)[0]//TODO  query pra trazer somente ativa
        val wash = washServices.fetchWashById(schedule.washId)
        val aspire = if (wash.aspire) 30 else 0             //TODO colocar no SQL
        val blackie = if (wash.pneuLittleBack) 10 else 0    //TODO colocar no SQL
        val silicon = if (wash.silicone) 20 else 0          //TODO colocar no SQL
        val wax = if (wash.wax) 35 else 0                   //TODO colocar no SQL

        val isAllServiceInclude = wash.aspire && wash.pneuLittleBack && wash.silicone && wash.wax

        val extras = (aspire + blackie + silicon + wax)
        valueTax += choosedValue
        valueTax += extras
        val finalValue = valueTax / .85
        val sp = finalValue.toString().split(".")
        val sufix = sp[1].length

        return if (sufix == 1) addDoubleZeroCurrency(finalValue.toInt()) else finalValue.addDoubleZeroCurrency()
    }

    private fun makeTitleAndDescription(
        choosedValue: String
    ) {
        when (choosedValue) {
            TypeCarSizeEnum.PEQUENO.type -> {
                description = TypeServiceEnum.PARCIAL.description
                title = TypeServiceEnum.PARCIAL.title
            }

            TypeCarSizeEnum.GRANDE.type -> {
                description = TypeServiceEnum.COMPLETA.description
                title = TypeServiceEnum.COMPLETA.title
            }

            TypeCarSizeEnum.MEDIO.type -> {
                description = TypeServiceEnum.PARCIAL.description
                title = TypeServiceEnum.PARCIAL.title
            }
        }
    }

}