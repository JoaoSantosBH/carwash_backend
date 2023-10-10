package com.carwash.back.carwash.features.scheduling.service

import com.carwash.back.carwash.features.scheduling.data.SchedulingRepository
import com.carwash.back.carwash.features.scheduling.model.SchedulingEntity
import com.carwash.back.carwash.utils.errors.ItemDoesntExistsException
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class SchedulingServices {

    @Autowired
    private lateinit var repository: SchedulingRepository
    @Transactional
    fun createScheduling(scheduling: SchedulingEntity): SchedulingEntity? {
        return repository.save(scheduling)
    }

    fun fetchAllSchedulings(): List<SchedulingEntity>? {
        return repository.findAll().sortedBy { it.idScheduling }
    }

    fun fetchSchedulingById(id: Long): SchedulingEntity {
        return repository.findById(id).orElseThrow { ItemDoesntExistsException(ItemDoesntExistsException.DOESNT_EXIST) }
    }

    fun fetchAllScheduleByClientId(id: Long): List<SchedulingEntity> {
        return repository.findAll().filter { it.clientId == id }
    }

    fun fetchAllScheduleByCollaboratorId(id: Long): List<SchedulingEntity> {
        return repository.findAll().filter { it.executorId == id }
    }

    fun fetchAllScheduleByStatusId(id: Long): List<SchedulingEntity> {
        return repository.findAll().filter { it.statusId == id }
    }
    @Transactional
    fun updateScheduling(schedule: SchedulingEntity, id: Long): SchedulingEntity? {
        val register = repository.findById(id).getOrNull()
        return if (register != null) {
            repository.save(schedule.copy(idScheduling = id))
        } else throw ItemDoesntExistsException(ItemDoesntExistsException.DOESNT_EXIST)
    }
    @Transactional
    fun deleteSchedulingById(id: Long): Unit? {
        val register = repository.findById(id).orElseThrow {
            ItemDoesntExistsException(ItemDoesntExistsException.DOESNT_EXIST)
        }
        return repository.delete(register)
    }

    fun fetchCollaboratorRankingSum(id: Long): Double {

        val fiveStars = getStarsCountByUserId(id, 5)
        val fourStars = getStarsCountByUserId(id, 4)
        val threeStars = getStarsCountByUserId(id, 3)
        val twoStars = getStarsCountByUserId(id, 2)
        val oneStars = getStarsCountByUserId(id, 1)

        val totalRanks = fiveStars + fourStars + threeStars + twoStars + oneStars
        val totalPunctuation =
            (fiveStars * 5) + (fourStars * 4) + (threeStars * 3) + (twoStars * 2) + oneStars
        return totalPunctuation.toDouble() / totalRanks
    }

    private fun getStarsCountByUserId(id: Long, rank: Int): Int {
        return repository.findAll().filter { it.executorId == id }
            .count { it.rankExecutor == rank }
    }


    fun fetchCollaboratorWashesSum(id: Long): Int {
        return repository
            .findAll().filter { it.executorId == id }
            .sumOf { it.rankExecutor }
    }
}