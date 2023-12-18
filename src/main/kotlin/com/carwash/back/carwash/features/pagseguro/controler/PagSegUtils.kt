package com.carwash.back.carwash.features.pagseguro.controler

import com.carwash.back.carwash.features.pagseguro.model.order.*
import com.carwash.back.carwash.features.pagseguro.model.order.card.request.PagSegCardOrderRequest
import com.carwash.back.carwash.features.scheduling.model.SchedulingEntity
import com.carwash.back.carwash.utils.Constants.DOT
import com.carwash.back.carwash.utils.Constants.EMPTY_STRING
import com.carwash.back.carwash.utils.Constants.STRING_ONE
import com.carwash.back.carwash.utils.Constants.ZERO_INT

fun makeReferenceId(scheduleId: SchedulingEntity): String {
    return "CWASH_ORD_CL:${scheduleId.clientId}_VEND:${scheduleId.executorId}_SCHED:${scheduleId.idScheduling}_WASH:${scheduleId.washId}"
}

fun addDoubleZeroCurrency(value: Int): Int {
    return "${value}00".toInt()
}

fun Double.addDoubleZeroCurrency(): Int {
    val numberWithoutQuotas = this.toString()
    return numberWithoutQuotas.replace(DOT, EMPTY_STRING).toInt()
}

fun makeFakeRequest(scheduleId: SchedulingEntity, value: Int): PagSegCardOrderRequest {
    val pagSeguroCurrencyValue = addDoubleZeroCurrency(value)
    val request = PagSegCardOrderRequest.DUMB_CARD_ORDER
    val items = listOf(Item.DUMB_ITEM.copy(unitAmount = pagSeguroCurrencyValue))
    val amount = Amount.DUMB_AMOUNT.copy(value = pagSeguroCurrencyValue)
    val amountQrCode = AmountQrCode.DUMB_AMOUNT.copy(value = pagSeguroCurrencyValue)
    val chrges = listOf(Charge.DUMB_CHARGE.copy(amount = amount))
    val qrs = QrCode.DUMB_QRCODE.copy(amount = amountQrCode)
    return request.copy(items = items, charges = chrges, qrCodes = listOf(qrs))
}

fun makePhoneSeparation(cellphone: String): String {
    return cellphone.substring(2)

}

fun makeAreaSeparation(cellphone: String): String {
    return cellphone.substring(ZERO_INT, 2)
}

fun prepareFraction(inputValue: Double): Double {

    var splitedList = inputValue.toString().split(DOT)
    val sufix = splitedList[1].length

    var normalizedString = EMPTY_STRING

    if (sufix > 2) {
        normalizedString = splitedList[ZERO_INT] + DOT + splitedList[1].substring(ZERO_INT,2)
    }

    if (sufix == 1) {
        normalizedString = splitedList[ZERO_INT] + DOT + splitedList[1] + STRING_ONE
    }
    if (sufix == 2){
        normalizedString = splitedList[ZERO_INT] + DOT + splitedList[1]
    }

    return normalizedString.toDouble()
}






