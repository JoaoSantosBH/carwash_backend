package com.carwash.back.carwash.features.address.controler

import com.carwash.back.carwash.features.address.model.AddressEntity
import com.carwash.back.carwash.features.address.service.AddressService
import com.carwash.back.carwash.utils.Endpoints.ADDRESS_ENDPOINT
import com.carwash.back.carwash.utils.Endpoints.ADDRESS_ENDPOINT_PATH
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class AddressController {

    @Autowired
    lateinit var service: AddressService


    @GetMapping(ADDRESS_ENDPOINT_PATH)
    fun fetchUserAddress(@PathVariable userId: Long): AddressEntity? {
        return service.fetchUserAddress(userId)
    }


    @PostMapping(ADDRESS_ENDPOINT)
    fun createUserAddress(@RequestBody  userAddress: AddressEntity): AddressEntity? {
        return service.createUserAddress(userAddress)
    }

    @PutMapping(ADDRESS_ENDPOINT_PATH)
    fun updateUserAddress(@RequestBody userAddress: AddressEntity, @PathVariable userId: Long): AddressEntity? {
        return service.updateUserAddress(userAddress, userId)
    }

    @DeleteMapping(ADDRESS_ENDPOINT_PATH)
    fun deleteUserAddress(@PathVariable id: Long): ResponseEntity<*> {
        service.deleteUserAddress(id)
        return ResponseEntity.noContent().build<Any>()
    }


}