package com.carwash.back.carwash.features.schedulig_status.service

import com.carwash.back.carwash.features.schedulig_status.data.SchedulingStatusRepository
import com.carwash.back.carwash.features.schedulig_status.model.SchedulingStatusEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import kotlin.jvm.optionals.getOrNull

@Service
class SchedulingStatusServices {

    @Autowired
    lateinit var repository: SchedulingStatusRepository

    @GetMapping
    fun fetchStatusById(id: Long) : SchedulingStatusEntity? {
        return repository.findById(id).getOrNull()
    }

}