package com.carwash.back.carwash.features.pagseguro.controler

import com.carwash.back.carwash.features.pagseguro.model.order.*
import com.carwash.back.carwash.features.pagseguro.model.order.card.PagSegCardOrderRequest
import com.carwash.back.carwash.features.scheduling.model.SchedulingEntity
import com.carwash.back.carwash.utils.Constants.EMPTY_STRING

fun makeReferenceId(scheduleId: SchedulingEntity): String {
    return "CWASH_ORD_CL:${scheduleId.clientId}_VEND:${scheduleId.executorId}_SCHED:${scheduleId.idScheduling}_WASH:${scheduleId.washId}"
}

fun addDoubleZeroCurrency(value: Int) : Int {
    return "${value}00".toInt()
}

fun Double.addDoubleZeroCurrency() : Int {
    val numberWithoutQuotas = this.toString()
    return numberWithoutQuotas.replace(".", EMPTY_STRING).toInt()
}

fun makeFakeRequest(scheduleId: SchedulingEntity, value: Int) : PagSegCardOrderRequest {
    val pagSeguroCurrencyValue = addDoubleZeroCurrency(value)
    val request = PagSegCardOrderRequest.DUMB_CARD_ORDER
    val items = listOf(Item.DUMB_ITEM.copy(unitAmount = pagSeguroCurrencyValue))
    val amount = Amount.DUMB_AMOUNT.copy(value = pagSeguroCurrencyValue)
    val amountQrCode = AmountQrCode.DUMB_AMOUNT.copy(value = pagSeguroCurrencyValue )
    val chrges = listOf(Charge.DUMB_CHARGE.copy(amount = amount ))
    val qrs = QrCode.DUMB_QRCODE.copy(amount = amountQrCode)
    return request.copy(items = items, charges = chrges, qrCodes = listOf(qrs) )
}

fun makePhoneSeparation(cellphone: String): String {
    return cellphone.substring(2)

}
fun makeAreaSeparation(cellphone: String): String {
    return cellphone.substring(0,2)

}






