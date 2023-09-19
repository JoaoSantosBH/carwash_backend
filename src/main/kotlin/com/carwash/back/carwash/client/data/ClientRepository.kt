package com.carwash.back.carwash.client.data

import com.carwash.back.carwash.client.model.ClientProfile
import org.springframework.data.jpa.repository.JpaRepository

interface ClientRepository: JpaRepository<ClientProfile, Long> {}