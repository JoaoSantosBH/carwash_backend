package com.carwash.back.carwash.utils.errors

import com.carwash.back.carwash.client.controler.DefaultErrorMessageModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionAdvice {
    @ExceptionHandler
    fun handleItemAlreadyExistsException(ex: ItemAlreadyExistsException): ResponseEntity<DefaultErrorMessageModel> {
        val errorMessage = DefaultErrorMessageModel(
            HttpStatus.FORBIDDEN.value(),
            ex.message
        )
        return ResponseEntity(errorMessage, HttpStatus.FORBIDDEN)
    }

    class ItemAlreadyExistsException(message: String) : RuntimeException(message) {
        companion object {
            const val EXIST = "Ops!!  Found similar item on the database"
        }
    }

}