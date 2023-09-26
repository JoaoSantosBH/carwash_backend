package com.carwash.back.carwash.features.colaborator.controler

import com.carwash.back.carwash.features.colaborator.model.CollaboratorProfile
import com.carwash.back.carwash.features.colaborator.service.ColaboratorService
import com.carwash.back.carwash.features.scheduling.service.SchedulingServices
import com.carwash.back.carwash.utils.Endpoints.ADD_COLLABORATOR_ENDPOINT
import com.carwash.back.carwash.utils.Endpoints.GET_SUM_COLLABORATOR_RANK
import com.carwash.back.carwash.utils.Endpoints.UPDATE_COLLABORATOR_ENDPOINT
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class CollaboratorController {

    @Autowired
    lateinit var service: ColaboratorService
    @Autowired
    lateinit var serviceSch: SchedulingServices


    @PostMapping(ADD_COLLABORATOR_ENDPOINT)
    fun createCollaborator(@RequestBody collaboratorRequest: CollaboratorProfile): CollaboratorProfile? {
        return service.createCollaborator(collaboratorRequest)
    }

    @PutMapping(UPDATE_COLLABORATOR_ENDPOINT)
    fun updateCollaborator(@RequestBody collaboratorRequest: CollaboratorProfile, @PathVariable id: Long): CollaboratorProfile? {
        return service.updateCollaborator(collaboratorRequest, id)
    }

    @DeleteMapping(UPDATE_COLLABORATOR_ENDPOINT)
    fun deleteCollaboratorById(@PathVariable id: Long): Unit {
        return service.deleteCollaboratorById(id)
    }

    @GetMapping(GET_SUM_COLLABORATOR_RANK)
    fun getCollaboratorActualRanking(@PathVariable id: Long): Int {
        return serviceSch.fetchCollaboratorRankingSum(id)
    }


}