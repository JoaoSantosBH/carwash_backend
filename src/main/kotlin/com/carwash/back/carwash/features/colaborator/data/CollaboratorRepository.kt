package com.carwash.back.carwash.features.colaborator.data

import com.carwash.back.carwash.features.user.model.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CollaboratorRepository: JpaRepository<UserEntity, Long> {}