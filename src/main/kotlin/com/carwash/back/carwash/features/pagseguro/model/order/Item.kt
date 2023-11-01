package com.carwash.back.carwash.features.pagseguro.model.order


import com.carwash.back.carwash.features.pagseguro.controler.addDoubleZeroCurrency
import com.carwash.back.carwash.features.pagseguro.controler.makeReferenceId
import com.carwash.back.carwash.features.scheduling.model.SchedulingEntity
import com.carwash.back.carwash.utils.Constants.EMPTY_STRING
import com.fasterxml.jackson.annotation.JsonProperty

data class Item(
    @JsonProperty("name")
    val name: String,
    @JsonProperty("quantity")
    val quantity: Int,
    @JsonProperty("reference_id")
    val referenceId: String,
    @JsonProperty("unit_amount")
    val unitAmount: Int
) {
    companion object {
        val DUMB_ITEM = Item(
            name = "Lavagem especial carros",
            quantity = 1,
            referenceId = makeReferenceId(SchedulingEntity.DUMB_SCHEDULE),
            unitAmount = addDoubleZeroCurrency(90)
        )
        val EMPTY_ITEM = Item(
            name = EMPTY_STRING,
            quantity = 0,
            referenceId = makeReferenceId(SchedulingEntity.EMPTY_SCHEDULE),
            unitAmount = 0
        )
    }
}