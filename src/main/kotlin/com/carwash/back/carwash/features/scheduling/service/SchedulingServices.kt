package com.carwash.back.carwash.features.scheduling.service

import com.carwash.back.carwash.features.scheduling.data.SchedulingRepository
import com.carwash.back.carwash.features.scheduling.model.SchedulingModel
import com.carwash.back.carwash.utils.errors.ItemDoesntExistsException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class SchedulingServices {

    @Autowired
    private lateinit var repository: SchedulingRepository

    fun createScheduling(scheduling: SchedulingModel): SchedulingModel? {
        return repository.save(scheduling)
    }

    fun fetchAllSchedulings(): List<SchedulingModel>? {
        return repository.findAll().sortedBy { it.idScheduling }
    }

    fun fetchSchedulingById(id: Long): SchedulingModel {
        return repository.findById(id).orElseThrow { ItemDoesntExistsException(ItemDoesntExistsException.DOESNT_EXIST) }
    }

    fun fetchAllScheduleByClientId(id: Long): List<SchedulingModel> {
        return repository.findAll().filter { it.clientId == id }
    }

    fun fetchAllScheduleByCollaboratorId(id: Long): List<SchedulingModel> {
        return repository.findAll().filter { it.colaboratorId == id }
    }

    fun fetchAllScheduleByStatusId(id: Long): List<SchedulingModel> {
        return repository.findAll().filter { it.idSchedulingStatus == id }
    }

    fun updateSchedulingStatus(schedule: SchedulingModel, id: Long): SchedulingModel? {
        val register = repository.findById(id).getOrNull()
        return if (register != null) {
            repository.save(schedule.copy(idScheduling = id))
        } else throw ItemDoesntExistsException(ItemDoesntExistsException.DOESNT_EXIST)
    }

    fun deleteSchedulingById(id: Long): Unit? {
        val register = repository.findById(id).orElseThrow {
            ItemDoesntExistsException(ItemDoesntExistsException.DOESNT_EXIST)
        }
        return repository.delete(register)
    }

    fun fetchCollaboratorRankingSum(id: Long): Int {
        return repository
            .findAll().filter { it.colaboratorId == id }
            .sumOf { it.rankColaborator }
    }
}