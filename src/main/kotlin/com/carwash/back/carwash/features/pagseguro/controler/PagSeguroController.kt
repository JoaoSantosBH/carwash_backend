package com.carwash.back.carwash.features.pagseguro.controler

import com.carwash.back.carwash.features.pagseguro.model.order.PaymentCardModel
import com.carwash.back.carwash.features.pagseguro.model.order.card.response.PagSegCardResponse
import com.carwash.back.carwash.features.pagseguro.service.PagSeguroService
import com.carwash.back.carwash.utils.Endpoints.PAYMENT_CARD_ENDPOINT
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PagSeguroController {

    @Autowired
    private lateinit var service: PagSeguroService



    @PostMapping(PAYMENT_CARD_ENDPOINT)
    fun createScheduling(@RequestBody payment: PaymentCardModel,
        @PathVariable userId: Long): PagSegCardResponse? {

        val request = pagSegCardOrderRequest(payment, userId)
        return service.makeCardRequest(request)
    }


}