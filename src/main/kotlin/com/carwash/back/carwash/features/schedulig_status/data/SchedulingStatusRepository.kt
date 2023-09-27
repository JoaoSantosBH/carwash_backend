package com.carwash.back.carwash.features.schedulig_status.data

import com.carwash.back.carwash.features.schedulig_status.model.SchedulingStatusEntity
import org.springframework.data.jpa.repository.JpaRepository

interface SchedulingStatusRepository : JpaRepository<SchedulingStatusEntity, Long> {}