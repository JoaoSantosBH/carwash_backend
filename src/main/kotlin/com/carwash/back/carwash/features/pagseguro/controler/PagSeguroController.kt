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
import com.carwash.back.carwash.utils.Constants.COUNTRY_CODE
import com.carwash.back.carwash.utils.Constants.COUNTRY_PREFIX
import com.carwash.back.carwash.utils.Constants.CURRENCY
import com.carwash.back.carwash.utils.Constants.MY_NOTIFICATION_URI
import com.carwash.back.carwash.utils.Endpoints.PAYMENT_CARD_ENDPOINT
import com.carwash.back.carwash.utils.TypeCardEnum
import com.carwash.back.carwash.utils.TypePhoneEnum
import com.carwash.back.carwash.utils.TypeServiceEnum
import org.springframework.beans.factory.annotation.Autowired
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
    private lateinit var addressService: AddressService

    @Autowired
    private lateinit var userService: UserService

    @PostMapping(PAYMENT_CARD_ENDPOINT)
    fun createScheduling(@RequestBody scheduling: SchedulingEntity): PagSegCardResponse? {
        //TODO pegar user do id no endpoint
        val userId = 80L
        //TODO pegar cpf
        val user = userService.fetchUserById(userId) ?: UserEntity.DUMB_USER
        //TODO valor do serviço
        val valueTax = addDoubleZeroCurrency(135)

        //TODO pegar requestBody
        val taxId = "00000000191"
        val number = "4111111111111111"
        val expMonth = "12"
        val expYear = "2026"
        val securityCode = "123"
        val holder = Holder(user.name)
        val parcelas = 1

        //TODO pegar descrição do serviço
        val description = "Lavagem Carro Médio"


        //pega user, endereco, fone,

        val address = addressService.fetchUserAddress(user.idUser) ?: AddressEntity.EMPTY_ADDRESS
        //pega scheduling
        val sch = schedulingServices.fetchAllScheduleByClientId(user.idUser)
        val schedule = sch[0]
        val referenceId = makeReferenceId(schedule)

        //metodo que popula o request aqui

        //01 charges
        val charge = Charge(
            amount = Amount(currency = CURRENCY, value = valueTax),
            description = description,
            notificationUrls = MY_NOTIFICATION_URI,
            paymentMethod = PaymentMethod(
                type = TypeCardEnum.CREDIT_CARD.value,
                card = Card(
                    number = number,
                    expMonth = expMonth,
                    expYear = expYear,
                    securityCode = securityCode,
                    holder = holder,
                    store = false
                ),
                installments = parcelas, //TODO ler do payload
                capture = true,
            ),
            referenceId = referenceId
        )
        //02  customer
        val customer = Customer(
            email = user.email,
            name = user.name,
            phones = listOf(
                Phone(
                    country = COUNTRY_CODE,
                    area = makeAreaSeparation(user.cellphone),//TODO add USER
                    number = makePhoneSeparation(user.cellphone),
                    type = TypePhoneEnum.MOBILE.type
                )
            ),
            taxId = taxId
        )


        //03   items = listOf(Item.EMPTY_ITEM),
        val items = listOf(
            Item(
                name = TypeServiceEnum.COMPLETA.title,
                quantity = 1,
                referenceId = referenceId,
                unitAmount = valueTax
            )
        )

        //04            notificationUrls = emptyList(),
        val notificationUrls = MY_NOTIFICATION_URI

        //05     qrCodes = listOf(QrCode.EMPTY_QRCODE),
        val qrCodes = listOf(
            QrCode(
                amount = AmountQrCode(valueTax)
            )
        )
        //  06          shipping = Shipping.EMPTY_SHIPPING

        val shipping = Shipping(
            address = Address(
                street = address.street,
                number = address.number,
                complement = address.complement,
                locality = address.neighborhood,
                city = address.city,
                regionCode = address.state,
                country = COUNTRY_PREFIX,
                postalCode = address.zip
            )
        )

        //metodo que popula o request aqui

        val mumu = PagSegCardOrderRequest(
            charges = listOf(charge),
            customer = customer,
            items = items,
            notificationUrls = notificationUrls,
            qrCodes = qrCodes,
            referenceId = makeReferenceId(SchedulingEntity.DUMB_SCHEDULE),
            shipping = shipping
        )
        val request = PagSegCardOrderRequest.DUMB_CARD_ORDER

        return service.makeCardRequest(mumu)
    }



}