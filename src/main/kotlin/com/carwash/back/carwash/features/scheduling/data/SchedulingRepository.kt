package com.carwash.back.carwash.features.scheduling.data

import com.carwash.back.carwash.features.scheduling.model.SchedulingEntity
import org.springframework.data.jpa.repository.JpaRepository

interface SchedulingRepository : JpaRepository<SchedulingEntity, Long> {}