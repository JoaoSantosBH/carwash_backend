package com.carwash.back.carwash.features.pagseguro.model.order


import com.carwash.back.carwash.utils.Constants
import com.carwash.back.carwash.utils.Constants.EMPTY_STRING
import com.carwash.back.carwash.utils.TypePayEnum
import com.fasterxml.jackson.annotation.JsonProperty

data class Charge(
    @JsonProperty("amount")
    val amount: Amount,
    @JsonProperty("description")
    val description: String,
    @JsonProperty("notification_urls")
    val notificationUrls: List<String>,
    @JsonProperty("payment_method")
    val paymentMethod: PaymentMethod,
    @JsonProperty("reference_id")
    val referenceId: String
) {
    companion object {
        val DUMB_CHARGE = Charge(
            amount = Amount.DUMB_AMOUNT,
            description = "Pagamento da lavagem Luxo",
            notificationUrls = listOf("https://meusite.com/notificacoes"),
            paymentMethod = PaymentMethod.DUMB_PAYMENT_METHOD,
            referenceId = "carwash-clientId-98989812B"

        )

        val EMPTY_CHARGE = Charge(
            amount = Amount(currency = EMPTY_STRING, value = 0),
            description = EMPTY_STRING,
            notificationUrls = emptyList(),
            paymentMethod = PaymentMethod.EMPTY_PAYMENT_METHOD,
            referenceId = EMPTY_STRING
        )

        fun mapingCharge(
            valueTax: Int,
            payment: PaymentCardModel,
            referenceId: String
        ) = Charge(
            amount = Amount(currency = Constants.CURRENCY, value = valueTax),
            description = EMPTY_STRING,
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
    }
}