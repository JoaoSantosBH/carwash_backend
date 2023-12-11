package com.carwash.back.carwash.features.pagseguro.model.order.pix.response

import com.fasterxml.jackson.annotation.JsonProperty


data class PagSegPixResponse(
    @JsonProperty("created_at")
    val createdAt: String,
    @JsonProperty("customer")
    val customer: Customer,
    @JsonProperty("id")
    val id: String,
    @JsonProperty("items")
    val items: List<Item>,
    @JsonProperty("links")
    val links: List<Link>,
    @JsonProperty("notification_urls")
    val notificationUrls: List<String>,
    @JsonProperty("qr_codes")
    val qrCodes: List<QrCode>,
    @JsonProperty("reference_id")
    val referenceId: String,
    @JsonProperty("shipping")
    val shipping: Shipping
)