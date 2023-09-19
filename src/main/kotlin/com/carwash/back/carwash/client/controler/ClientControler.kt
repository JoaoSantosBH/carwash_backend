package com.carwash.back.carwash.client.controler

import com.carwash.back.carwash.client.model.ClientProfile
import com.carwash.back.carwash.client.service.ClientService
import com.carwash.back.carwash.utils.Endpoints.ADD_USER_ENDPOINT
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class ClientControler() {

    @Autowired
    lateinit var service: ClientService

    @PostMapping(ADD_USER_ENDPOINT)
    fun createClient(@RequestBody clientRequest: ClientProfile): ClientProfile? {
        return service.createClient(clientRequest)
    }
}