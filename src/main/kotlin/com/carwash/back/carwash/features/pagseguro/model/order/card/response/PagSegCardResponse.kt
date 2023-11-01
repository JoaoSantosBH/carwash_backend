package com.carwash.back.carwash.features.pagseguro.model.order.card.response

import com.carwash.back.carwash.features.pagseguro.model.order.Item
import com.fasterxml.jackson.annotation.JsonProperty


data class PagSegCardResponse(
    @JsonProperty("charges")
    val charges: List<ChargeResponse>,
    @JsonProperty("created_at")
    val createdAt: String,
    @JsonProperty("customer")
    val customer: CustomerResponse,
    @JsonProperty("id")
    val id: String,
    @JsonProperty("items")
    val items: List<Item>,
    @JsonProperty("links")
    val links: List<LinkResponse>,
    @JsonProperty("notification_urls")
    val notificationUrls: List<String>,
    @JsonProperty("qr_codes")
    val qrCodes: List<QrCodeResponse>,
    @JsonProperty("reference_id")
    val referenceId: String,
    @JsonProperty("shipping")
    val shipping: ShippingResponse
) {
    companion object {

//        val DUMB_CARD_ORDER_RESPONSE = PagSegCardResponse(
//            charges = listOf(ChargeResponse.DUMB_CHARGE),
//            createdAt = "2023-10-31T16:19:02.029-03:00",
//            customer = CustomerResponse.DUMB_CUSTOMER,
//            items = listOf(Item.DUMB_ITEM),
//            notificationUrls = Charge.DUMB_CHARGE.notificationUrls,
//            qrCodes = listOf(QrCodeResponse.DUMB_QRCODE),
//            referenceId = makeReferenceId(SchedulingEntity.DUMB_SCHEDULE),
//            shipping = ShippingResponse.DUMB_SHIPPING,
//            id = "XXXXX-XXXXXX",
//            links = listOf(LinkResponse.DUMB_LINK_1, LinkResponse.DUMB_LINK_2)
//        )

    }
}