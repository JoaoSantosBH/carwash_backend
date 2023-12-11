package com.carwash.back.carwash.features.pagseguro.model.order


import com.fasterxml.jackson.annotation.JsonProperty

data class QrCode(
    @JsonProperty("amount")
    val amount: AmountQrCode
) {
    companion object {
        val DUMB_QRCODE = QrCode(
             AmountQrCode.DUMB_AMOUNT
        )
        val EMPTY_QRCODE = QrCode(
            AmountQrCode.EMPTY_AMOUNT
        )
    }
}