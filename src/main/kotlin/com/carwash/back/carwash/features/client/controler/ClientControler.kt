package com.carwash.back.carwash.features.client.controler

import com.carwash.back.carwash.features.client.model.ClientProfile
import com.carwash.back.carwash.features.client.service.ClientService
import com.carwash.back.carwash.utils.Endpoints.ADD_CLIENT_ENDPOINT
import com.carwash.back.carwash.utils.Endpoints.UPDATE_CLIENT_ENDPOINT
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
class ClientControler() {

    @Autowired
    lateinit var service: ClientService

    @PostMapping(ADD_CLIENT_ENDPOINT)
    fun createClient(@RequestBody clientRequest: ClientProfile): ClientProfile? {
        return service.createClient(clientRequest)
    }

    @PutMapping(UPDATE_CLIENT_ENDPOINT)
    fun updateClient(@RequestBody clientRequest: ClientProfile, @PathVariable id: Long): ClientProfile? {
        return service.updateClient(clientRequest, id)
    }

    @DeleteMapping(UPDATE_CLIENT_ENDPOINT)
    fun deleteClientById(@PathVariable id: Long): Unit {
        return service.deleteClientById(id)
    }

}