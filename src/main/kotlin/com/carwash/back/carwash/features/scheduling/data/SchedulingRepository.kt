package com.carwash.back.carwash.features.scheduling.data

import com.carwash.back.carwash.features.scheduling.model.SchedulingModel
import org.springframework.data.jpa.repository.JpaRepository

interface SchedulingRepository : JpaRepository<SchedulingModel, Long> {}