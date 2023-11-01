package com.carwash.back.carwash.features.pagseguro.model.order


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
            amount = Amount(currency = "", value = 0),
            description = "",
            notificationUrls = emptyList(),
            paymentMethod = PaymentMethod.EMPTY_PAYMENT_METHOD,
            referenceId = ""
        )
    }
}