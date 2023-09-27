package com.carwash.back.carwash.features.user.data

import com.carwash.back.carwash.features.user.model.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<UserEntity, Long> {}