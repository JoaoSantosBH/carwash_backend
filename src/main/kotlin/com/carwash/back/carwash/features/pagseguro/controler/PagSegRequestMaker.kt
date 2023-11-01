package com.carwash.back.carwash.features.pagseguro.controler

import com.carwash.back.carwash.features.address.model.AddressEntity
import com.carwash.back.carwash.features.address.service.AddressService
import com.carwash.back.carwash.features.pagseguro.model.order.*
import com.carwash.back.carwash.features.pagseguro.model.order.card.PagSegCardOrderRequest
import com.carwash.back.carwash.features.scheduling.model.SchedulingEntity
import com.carwash.back.carwash.features.scheduling.service.SchedulingServices
import com.carwash.back.carwash.features.user.model.UserEntity
import com.carwash.back.carwash.features.user.service.UserService
import com.carwash.back.carwash.features.vehicles.service.VehicleServices
import com.carwash.back.carwash.utils.Constants
import com.carwash.back.carwash.utils.TypeCardEnum
import com.carwash.back.carwash.utils.TypePhoneEnum
import com.carwash.back.carwash.utils.TypeServiceEnum
import org.springframework.beans.factory.annotation.Autowired

@Autowired
private lateinit var schedulingServices: SchedulingServices

@Autowired
private lateinit var vehicleServices: VehicleServices

@Autowired
private lateinit var addressService: AddressService

@Autowired
private lateinit var userService: UserService


fun pagSegCardOrderRequest(payment: PaymentCardModel, userId: Long): PagSegCardOrderRequest {

    val user = userService.fetchUserById(userId) ?: UserEntity.DUMB_USER

    //TODO precificar aqui
    val valueTax = addDoubleZeroCurrency(135)
    val description = TypeServiceEnum.COMPLETA.description
    val title = TypeServiceEnum.COMPLETA.title

    //pegar veiculo, precificar

    val address = addressService.fetchUserAddress(user.idUser) ?: AddressEntity.EMPTY_ADDRESS
    val schedule = schedulingServices.fetchAllScheduleByClientId(user.idUser)[0]
    val referenceId = makeReferenceId(schedule)

    val charge = Charge(
        amount = Amount(currency = Constants.CURRENCY, value = valueTax),
        description = description,
        notificationUrls = Constants.MY_NOTIFICATION_URI,
        paymentMethod = PaymentMethod(
            type = TypeCardEnum.CREDIT_CARD.value,
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