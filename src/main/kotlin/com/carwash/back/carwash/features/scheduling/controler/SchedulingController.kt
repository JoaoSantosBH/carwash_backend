package com.carwash.back.carwash.features.scheduling.controler

import com.carwash.back.carwash.features.scheduling.model.SchedulingEntity
import com.carwash.back.carwash.features.scheduling.service.SchedulingServices
import com.carwash.back.carwash.utils.Endpoints.SCHEDULE_ENDPOINT
import com.carwash.back.carwash.utils.Endpoints.SCHEDULE_ENDPOINT_PATH
import com.carwash.back.carwash.utils.Endpoints.SCHEDULE_ENDPOINT_PATH_CLIENT_ID
import com.carwash.back.carwash.utils.Endpoints.SCHEDULE_ENDPOINT_PATH_COLLABORATOR_ID
import com.carwash.back.carwash.utils.Endpoints.SCHEDULE_ENDPOINT_PATH_STATUS
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class SchedulingController {

    @Autowired
    lateinit var service: SchedulingServices

    @PostMapping(SCHEDULE_ENDPOINT)
    fun createScheduling(@RequestBody scheduling: SchedulingEntity): SchedulingEntity? {
        return service.createScheduling(scheduling)
    }

    @GetMapping(SCHEDULE_ENDPOINT)
    fun fetchAllSchedulings(): List<SchedulingEntity?>? {
        return service.fetchAllSchedulings()
    }

    @GetMapping(SCHEDULE_ENDPOINT_PATH)
    fun fetchSchedulingById(@PathVariable id: Long): SchedulingEntity? {
        return service.fetchSchedulingById(id)
    }

    @GetMapping(SCHEDULE_ENDPOINT_PATH_CLIENT_ID)
    fun fetchAllScheduleByClientId(@PathVariable id: Long): List<SchedulingEntity> {
        return service.fetchAllScheduleByClientId(id)
    }

    @GetMapping(SCHEDULE_ENDPOINT_PATH_COLLABORATOR_ID)
    fun fetchAllScheduleByCollaboratorId(@PathVariable id: Long): List<SchedulingEntity> {
        return service.fetchAllScheduleByCollaboratorId(id)
    }

    @GetMapping(SCHEDULE_ENDPOINT_PATH_STATUS)
    fun fetchAllScheduleByStatusId(@PathVariable id: Long): List<SchedulingEntity> {
        return service.fetchAllScheduleByStatusId(id)
    }

    @PutMapping(SCHEDULE_ENDPOINT_PATH)
    fun updateScheduling(
        @RequestBody request: SchedulingEntity,
        @PathVariable id: Long
    ): SchedulingEntity? {
        return service.updateScheduling(request, id)
    }

    @DeleteMapping(SCHEDULE_ENDPOINT_PATH)
    fun deleteSchedulingById(@PathVariable id: Long): ResponseEntity<*>? {
        service.deleteSchedulingById(id)
        return ResponseEntity.noContent().build<Any>()
    }


}