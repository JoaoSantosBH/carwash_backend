package com.carwash.back.carwash.features.pagseguro.model.order.card.request

import com.carwash.back.carwash.features.pagseguro.controler.makeReferenceId
import com.carwash.back.carwash.features.pagseguro.model.order.*
import com.carwash.back.carwash.features.scheduling.model.SchedulingEntity
import com.carwash.back.carwash.utils.Constants.EMPTY_STRING
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
            referenceId = EMPTY_STRING,
            shipping = Shipping.EMPTY_SHIPPING
        )

        fun mappingCardOrderRequest(
            charge: Charge,
            customer: Customer,
            items: List<Item>,
            notificationUrls: List<String>,
            qrCodes: List<QrCode>,
            shipping: Shipping
        ) = PagSegCardOrderRequest(
            charges = listOf(charge),
            customer = customer,
            items = items,
            notificationUrls = notificationUrls,
            qrCodes = qrCodes,
            referenceId = makeReferenceId(SchedulingEntity.DUMB_SCHEDULE), //TODO remover DUMB
            shipping = shipping
        )

    }
}