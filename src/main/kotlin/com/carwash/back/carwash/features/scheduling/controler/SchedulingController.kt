package com.carwash.back.carwash.features.scheduling.controler

import com.carwash.back.carwash.features.scheduling.model.SchedulingModel
import com.carwash.back.carwash.features.scheduling.service.SchedulingServices
import com.carwash.back.carwash.utils.Endpoints.ADD_SCHEDULE_ENDPOINT
import com.carwash.back.carwash.utils.Endpoints.GET_SCHEDULE_BY_ID_ENDPOINT
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class SchedulingController {

    @Autowired
    lateinit var service: SchedulingServices

    @PostMapping(ADD_SCHEDULE_ENDPOINT)
    fun createScheduling(@RequestBody scheduling: SchedulingModel): SchedulingModel? {
        return service.createScheduling(scheduling)
    }

    @GetMapping(ADD_SCHEDULE_ENDPOINT)
    fun fetchAllSchedulings(): List<SchedulingModel?>? {
        return service.fetchAllSchedulings()
    }

    @GetMapping(GET_SCHEDULE_BY_ID_ENDPOINT)
    fun fetchSchedulingById(@PathVariable id: Long): SchedulingModel? {
        return service.fetchSchedulingById(id)
    }

    @PutMapping(GET_SCHEDULE_BY_ID_ENDPOINT)
    fun updateSchedulingStatus(
        @RequestBody request: SchedulingModel,
        @PathVariable id: Long
    ): SchedulingModel? {
        return service.updateSchedulingStatus(request)
    }

    @DeleteMapping(GET_SCHEDULE_BY_ID_ENDPOINT)
    fun deleteSchedulingById(@PathVariable id: Long) {
        service.deleteSchedulingById(id)
    }


}