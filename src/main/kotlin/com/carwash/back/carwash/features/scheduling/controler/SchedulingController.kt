package com.carwash.back.carwash.features.scheduling.controler

import com.carwash.back.carwash.features.scheduling.model.SchedulingEntity
import com.carwash.back.carwash.features.scheduling.service.SchedulingServices
import com.carwash.back.carwash.utils.Endpoints.ADD_SCHEDULE_ENDPOINT
import com.carwash.back.carwash.utils.Endpoints.GET_ALL_SCHEDULE_BY_CLIENT_ID
import com.carwash.back.carwash.utils.Endpoints.GET_ALL_SCHEDULE_BY_COLLABORATOR_ID
import com.carwash.back.carwash.utils.Endpoints.GET_ALL_SCHEDULE_BY_STATUS_ID
import com.carwash.back.carwash.utils.Endpoints.GET_SCHEDULE_BY_ID_ENDPOINT
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class SchedulingController {

    @Autowired
    lateinit var service: SchedulingServices

    @PostMapping(ADD_SCHEDULE_ENDPOINT)
    fun createScheduling(@RequestBody scheduling: SchedulingEntity): SchedulingEntity? {
        return service.createScheduling(scheduling)
    }

    @GetMapping(ADD_SCHEDULE_ENDPOINT)
    fun fetchAllSchedulings(): List<SchedulingEntity?>? {
        return service.fetchAllSchedulings()
    }

    @GetMapping(GET_SCHEDULE_BY_ID_ENDPOINT)
    fun fetchSchedulingById(@PathVariable id: Long): SchedulingEntity? {
        return service.fetchSchedulingById(id)
    }

    @GetMapping(GET_ALL_SCHEDULE_BY_CLIENT_ID)
    fun fetchAllScheduleByClientId(@PathVariable id:Long): List<SchedulingEntity>{
        return service.fetchAllScheduleByClientId(id)
    }
    @GetMapping(GET_ALL_SCHEDULE_BY_COLLABORATOR_ID)
    fun fetchAllScheduleByCollaboratorId(@PathVariable id:Long): List<SchedulingEntity>{
        return service.fetchAllScheduleByCollaboratorId(id)
    }

    @GetMapping(GET_ALL_SCHEDULE_BY_STATUS_ID)
    fun fetchAllScheduleByStatusId(@PathVariable id:Long): List<SchedulingEntity>{
        return service.fetchAllScheduleByStatusId(id)
    }

    @PutMapping(GET_SCHEDULE_BY_ID_ENDPOINT)
    fun updateScheduling(
        @RequestBody request: SchedulingEntity,
        @PathVariable id: Long
    ): SchedulingEntity? {
        return service.updateScheduling(request, id)
    }

    @DeleteMapping(GET_SCHEDULE_BY_ID_ENDPOINT)
    fun deleteSchedulingById(@PathVariable id: Long): Unit? {
        return service.deleteSchedulingById(id)
    }


}