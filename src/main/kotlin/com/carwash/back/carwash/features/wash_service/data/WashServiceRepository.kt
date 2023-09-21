package com.carwash.back.carwash.features.wash_service.data

import com.carwash.back.carwash.features.wash_service.model.WashServiceModel
import org.springframework.data.jpa.repository.JpaRepository

interface WashServiceRepository : JpaRepository<WashServiceModel, Long> {}

