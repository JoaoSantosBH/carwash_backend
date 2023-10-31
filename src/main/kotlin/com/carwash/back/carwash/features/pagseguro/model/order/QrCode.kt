package com.carwash.back.carwash.features.pagseguro.model.order


import com.fasterxml.jackson.annotation.JsonProperty

data class QrCode(
    @JsonProperty("amount")
    val amount: List<AmountQrCode>
) {
    companion object {
        val DUMB_QRCODE = QrCode(
             listOf(AmountQrCode.DUMB_AMOUNT)
        )
    }
}