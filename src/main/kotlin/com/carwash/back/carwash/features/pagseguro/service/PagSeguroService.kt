package com.carwash.back.carwash.features.pagseguro.service

import com.carwash.back.carwash.features.pagseguro.model.order.card.PagSegCardOrderRequest
import com.carwash.back.carwash.features.pagseguro.model.order.card.response.PagSegCardResponse
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate


@Service
class PagSeguroService {

    //    @Autowired
//    @Qualifier("restTemplateCustom")
//    private lateinit var restTemplate: RestTemplate
    private val restTemplate = RestTemplate() //TODO AutoWired


    fun makeCardRequest(payload: PagSegCardOrderRequest): PagSegCardResponse? {
        //fazer apenas o request e receber o response
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        headers.set("Authorization", "9ED52ADA317C43338FF710C6D6491BC4")//TODO variaveis no sql por ambiente
        val request = HttpEntity(payload, headers)
        val response = restTemplate.exchange("https://sandbox.api.pagseguro.com/orders2", HttpMethod.POST, request, PagSegCardResponse::class.java)//TODO variaveis no sql por ambiente
        return response.body


    }

}