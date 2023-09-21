package com.carwash.back.carwash.features.login_register.data

import com.carwash.back.carwash.features.login_register.model.ClientProfile
import org.springframework.data.jpa.repository.JpaRepository

interface ClientRepository: JpaRepository<ClientProfile, Long> {}