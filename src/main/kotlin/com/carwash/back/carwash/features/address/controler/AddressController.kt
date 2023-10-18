package com.carwash.back.carwash.features.address.controler

import com.carwash.back.carwash.features.address.model.AddressEntity
import com.carwash.back.carwash.features.address.model.ViaCepResponse
import com.carwash.back.carwash.features.address.model.ViaCepResponse.Companion.toAddress
import com.carwash.back.carwash.features.address.service.AddressService
import com.carwash.back.carwash.utils.Endpoints.ADDRESS_ENDPOINT
import com.carwash.back.carwash.utils.Endpoints.ADDRESS_ENDPOINT_PATH
import com.carwash.back.carwash.utils.Endpoints.VIA_CEP_BASE_URL
import com.carwash.back.carwash.utils.Endpoints.VIA_CEP_ENDPOINT
import com.carwash.back.carwash.utils.Endpoints.VIA_CEP_SUFIX
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate

@RestController
class AddressController {

    @Autowired
    lateinit var service: AddressService


    @GetMapping(ADDRESS_ENDPOINT_PATH)
    fun fetchUserAddress(@PathVariable userId: Long): AddressEntity? {
        return service.fetchUserAddress(userId)
    }


    @PostMapping(ADDRESS_ENDPOINT)
    fun createUserAddress(@RequestBody userAddress: AddressEntity): AddressEntity? {
        return service.createUserAddress(userAddress)
    }

    @PutMapping(ADDRESS_ENDPOINT_PATH)
    fun updateUserAddress(@RequestBody userAddress: AddressEntity, @PathVariable userId: Long): AddressEntity? {
        return service.updateUserAddress(userAddress, userId)
    }

    @DeleteMapping(ADDRESS_ENDPOINT_PATH)
    fun deleteUserAddress(@PathVariable userId: Long): ResponseEntity<*> {
        service.deleteUserAddress(userId)
        return ResponseEntity.noContent().build<Any>()
    }

    @GetMapping(VIA_CEP_ENDPOINT)
    fun getAddress(@PathVariable zipNumber: Long): AddressEntity? {
        val template = RestTemplate()
        val uri = VIA_CEP_BASE_URL + zipNumber + VIA_CEP_SUFIX
        return template.getForObject(uri, ViaCepResponse::class.java)?.toAddress()
    }


//GET ADDRESS FROM CEP
//http://viacep.com.br/ws/{ZIP}/json
}