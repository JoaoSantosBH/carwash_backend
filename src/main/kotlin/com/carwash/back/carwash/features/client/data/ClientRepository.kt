package com.carwash.back.carwash.features.client.data

import com.carwash.back.carwash.features.client.model.ClientProfile
import org.springframework.data.jpa.repository.JpaRepository

interface ClientRepository: JpaRepository<ClientProfile, Long> {}