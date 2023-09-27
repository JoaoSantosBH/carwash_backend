package com.carwash.back.carwash.features.schedulig_status.controler

import com.carwash.back.carwash.features.schedulig_status.model.SchedulingStatusEntity
import com.carwash.back.carwash.features.schedulig_status.service.SchedulingStatusServices
import com.carwash.back.carwash.utils.Endpoints.GET_SCHEDULE_STATUS_ENDPOINT
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ScheduleStatusControler {

    @Autowired
    lateinit var service: SchedulingStatusServices
    @GetMapping(GET_SCHEDULE_STATUS_ENDPOINT)
    fun getSchedulingStatus(@PathVariable id: Long): SchedulingStatusEntity? {
        return service.fetchStatusById(id)
    }

}