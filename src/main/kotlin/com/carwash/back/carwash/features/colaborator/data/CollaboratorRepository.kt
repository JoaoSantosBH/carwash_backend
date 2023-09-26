package com.carwash.back.carwash.features.colaborator.data

import com.carwash.back.carwash.features.colaborator.model.CollaboratorProfile
import org.springframework.data.jpa.repository.JpaRepository

interface CollaboratorRepository: JpaRepository<CollaboratorProfile, Long> {}