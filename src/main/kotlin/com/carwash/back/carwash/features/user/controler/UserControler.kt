package com.carwash.back.carwash.features.user.controler

import com.carwash.back.carwash.features.user.model.UserEntity
import com.carwash.back.carwash.features.user.service.UserService
import com.carwash.back.carwash.utils.Endpoints.ADD_CLIENT_ENDPOINT
import com.carwash.back.carwash.utils.Endpoints.UPDATE_CLIENT_ENDPOINT
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
class UserControler() {

    @Autowired
    lateinit var service: UserService

    @PostMapping(ADD_CLIENT_ENDPOINT)
    fun createUser(@RequestBody clientRequest: UserEntity): UserEntity? {
        return service.createClient(clientRequest)
    }

    @PutMapping(UPDATE_CLIENT_ENDPOINT)
    fun updateClient(@RequestBody clientRequest: UserEntity, @PathVariable id: Long): UserEntity? {
        return service.updateClient(clientRequest, id)
    }

    @DeleteMapping(UPDATE_CLIENT_ENDPOINT)
    fun deleteClientById(@PathVariable id: Long): Unit {
        return service.deleteClientById(id)
    }

}