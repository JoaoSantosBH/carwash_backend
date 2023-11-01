package com.carwash.back.carwash.features.pagseguro.model.order.card

import com.carwash.back.carwash.features.pagseguro.controler.makeReferenceId
import com.carwash.back.carwash.features.pagseguro.model.order.*
import com.carwash.back.carwash.features.scheduling.model.SchedulingEntity
import com.fasterxml.jackson.annotation.JsonProperty


data class PagSegCardOrderRequest(
    @JsonProperty("charges")
    val charges: List<Charge>,
    @JsonProperty("customer")
    val customer: Customer,
    @JsonProperty("items")
    val items: List<Item>,
    @JsonProperty("notification_urls")
    val notificationUrls: List<String>,
    @JsonProperty("qr_codes")
    val qrCodes: List<QrCode>,
    @JsonProperty("reference_id")
    val referenceId: String,
    @JsonProperty("shipping")
    val shipping: Shipping
) {
    companion object {

        val DUMB_CARD_ORDER = PagSegCardOrderRequest(
            charges = listOf(Charge.DUMB_CHARGE),
            customer = Customer.DUMB_CUSTOMER,
            items = listOf(Item.DUMB_ITEM),
            notificationUrls = Charge.DUMB_CHARGE.notificationUrls,
            qrCodes = listOf(QrCode.DUMB_QRCODE),
            referenceId = makeReferenceId(SchedulingEntity.DUMB_SCHEDULE),
            shipping = Shipping.DUMB_SHIPPING
        )

        fun getEmptyRequest() = PagSegCardOrderRequest(
            charges = listOf(Charge.EMPTY_CHARGE),
            customer = Customer.EMPTY_CUSTOMER,
            items = listOf(Item.EMPTY_ITEM),
            notificationUrls = emptyList(),
            qrCodes = listOf(QrCode.EMPTY_QRCODE),
            referenceId = "",
            shipping = Shipping.EMPTY_SHIPPING
        )

    }
}