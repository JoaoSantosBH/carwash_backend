package com.carwash.back.carwash.features.address.service

import com.carwash.back.carwash.features.address.data.AddressRepository
import com.carwash.back.carwash.features.address.model.AddressEntity
import com.carwash.back.carwash.utils.errors.ItemDoesntExistsException
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class AddressService {

    @Autowired
    private lateinit var repository: AddressRepository

    fun fetchUserAddress(userId: Long): AddressEntity? {
        return repository.findByUserId(userId)
            .orElseThrow { ItemDoesntExistsException(ItemDoesntExistsException.DOESNT_EXIST) }
    }

    @Transactional
    fun createUserAddress(userAddress: AddressEntity): AddressEntity? {
        return repository.save(userAddress)
    }

    @Transactional
    fun updateUserAddress(userAddress: AddressEntity, userId: Long): AddressEntity? {
        val register = repository.findById(userId).getOrNull()
        return if (register != null) {
            repository.save(userAddress)
        } else throw ItemDoesntExistsException(ItemDoesntExistsException.DOESNT_EXIST)
    }

    @Transactional
    fun deleteUserAddress(id: Long): Unit? {
        val register = repository.findById(id).orElseThrow {
            ItemDoesntExistsException(ItemDoesntExistsException.DOESNT_EXIST)
        }
        return repository.delete(register)
    }

}