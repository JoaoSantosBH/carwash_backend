package com.carwash.back.carwash.features.wash.controler

import com.carwash.back.carwash.features.wash.model.WashEntity
import com.carwash.back.carwash.features.wash.service.WashServices
import com.carwash.back.carwash.utils.Endpoints.SERVICE_ENDPOINT
import com.carwash.back.carwash.utils.Endpoints.SERVICE_ENDPOINT_PATH
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class WashController {

    @Autowired
    lateinit var service: WashServices

    @PostMapping(SERVICE_ENDPOINT)
    fun createWash(@RequestBody request: WashEntity): WashEntity? {
        return service.createWash(request)
    }

    @GetMapping(SERVICE_ENDPOINT)
    fun fetchAllWashs(): List<WashEntity?>? {
        return service.fetchAllWashs()
    }

    @GetMapping(SERVICE_ENDPOINT_PATH)
    fun fetchWashById(@PathVariable id: Long): WashEntity? {
        return service.fetchWashById(id)
    }

    @PutMapping(SERVICE_ENDPOINT_PATH)
    fun updateWashStatus(@RequestBody request: WashEntity, @PathVariable id: Long): WashEntity? {
        return service.updateWashStatus(request, id)
    }

    @DeleteMapping(SERVICE_ENDPOINT_PATH)
    fun deleteWashById(@PathVariable id: Long) : ResponseEntity<*>? {
        service.deleteWashById(id)
        return ResponseEntity.noContent().build<Any>()
    }

}