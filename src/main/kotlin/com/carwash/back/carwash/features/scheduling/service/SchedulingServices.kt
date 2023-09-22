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
        return repository
            .findById(id)
            .orElseThrow { ItemDoesntExistsException(ItemDoesntExistsException.DOESNT_EXIST) }
    }

    fun updateSchedulingStatus(Schedulin: SchedulingModel): SchedulingModel? {
        val register = repository.findById(Schedulin.idScheduling).getOrNull()
        return if (register != null) repository.save(Schedulin)
        else throw ItemDoesntExistsException(ItemDoesntExistsException.DOESNT_EXIST)
    }

    fun deleteSchedulingById(id: Long): Unit? {
        return repository.deleteById(id)
    }
}