package com.carwash.back.carwash.features.colaborator.controler

import com.carwash.back.carwash.features.colaborator.service.ColaboratorService
import com.carwash.back.carwash.features.scheduling.service.SchedulingServices
import com.carwash.back.carwash.features.user.model.UserEntity
import com.carwash.back.carwash.utils.Endpoints.COLLABORATOR_ENDPOINT
import com.carwash.back.carwash.utils.Endpoints.COLLABORATOR_ENDPOINT_PATH
import com.carwash.back.carwash.utils.Endpoints.SCHEDULE_ENDPOINT_PATH_COLLABORATOR_RANK
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class CollaboratorController {

    @Autowired
    lateinit var service: ColaboratorService
    @Autowired
    lateinit var serviceSch: SchedulingServices


    @PostMapping(COLLABORATOR_ENDPOINT)
    fun createCollaborator(@RequestBody collaboratorRequest: UserEntity): UserEntity? {
        return service.createCollaborator(collaboratorRequest)
    }

    @PutMapping(COLLABORATOR_ENDPOINT_PATH)
    fun updateCollaborator(@RequestBody collaboratorRequest: UserEntity, @PathVariable id: Long): UserEntity? {
        return service.updateCollaborator(collaboratorRequest, id)
    }

    @DeleteMapping(COLLABORATOR_ENDPOINT_PATH)
    fun deleteCollaboratorById(@PathVariable id: Long): ResponseEntity<*>? {
        service.deleteCollaboratorById(id)
        return ResponseEntity.noContent().build<Any>()
    }

    @GetMapping(SCHEDULE_ENDPOINT_PATH_COLLABORATOR_RANK)
    fun getCollaboratorActualRanking(@PathVariable id: Long): Double {
        return serviceSch.fetchCollaboratorRankingSum(id)
    }


}