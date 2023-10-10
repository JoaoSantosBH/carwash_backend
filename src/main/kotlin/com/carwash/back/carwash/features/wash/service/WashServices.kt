package com.carwash.back.carwash.features.wash.service

import com.carwash.back.carwash.features.wash.data.WashServiceRepository
import com.carwash.back.carwash.features.wash.model.WashEntity
import com.carwash.back.carwash.utils.errors.ItemDoesntExistsException
import com.carwash.back.carwash.utils.errors.ItemDoesntExistsException.Companion.DOESNT_EXIST
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class WashServices {

    @Autowired
    private lateinit var repository: WashServiceRepository
    @Transactional
    fun createWash(service: WashEntity): WashEntity {
        return repository.save(service)
    }

    fun fetchAllWashs(): List<WashEntity>? {
        return repository.findAll().sortedBy { it.idWash }
    }

    fun fetchWashById(id: Long): WashEntity {
        return repository
            .findById(id)
            .orElseThrow { ItemDoesntExistsException(DOESNT_EXIST) }
    }
    @Transactional
    fun updateWashStatus(service: WashEntity, id: Long): WashEntity? {
        val register = repository.findById(id).getOrNull()
        return if (register != null) repository.save(service)
        else throw ItemDoesntExistsException(DOESNT_EXIST)
    }
    @Transactional
    fun deleteWashById(id: Long): Unit? {
        return repository.deleteById(id)
    }

}