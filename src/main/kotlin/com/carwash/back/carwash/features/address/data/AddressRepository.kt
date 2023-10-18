package com.carwash.back.carwash.features.address.data

import com.carwash.back.carwash.features.address.model.AddressEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface AddressRepository : JpaRepository<AddressEntity, Long> {
    fun findByUserId(id:Long) : Optional<AddressEntity>

}