package com.carwash.back.carwash.features.wash.data

import com.carwash.back.carwash.features.wash.model.WashEntity
import org.springframework.data.jpa.repository.JpaRepository

interface WashServiceRepository : JpaRepository<WashEntity, Long> {}

