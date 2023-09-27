package com.carwash.back.carwash.utils.errors

import org.springframework.dao.InvalidDataAccessResourceUsageException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.sql.SQLIntegrityConstraintViolationException

@ControllerAdvice
class HttpErrorsHandler {

    @ExceptionHandler
    fun handleItemAlreadyExistsException(ex: ItemAlreadyExistsException): ResponseEntity<DefaultErrorMessage> {
        val errorMessage = DefaultErrorMessage(
            HttpStatus.FORBIDDEN.value(),
            ex.message
        )
        return ResponseEntity(errorMessage, HttpStatus.FORBIDDEN)
    }

    @ExceptionHandler
    fun handleItemDoesntExistsException(ex: ItemDoesntExistsException): ResponseEntity<DefaultErrorMessage> {
        val errorMessage = DefaultErrorMessage(
            HttpStatus.FORBIDDEN.value(),
            ex.message
        )
        return ResponseEntity(errorMessage, HttpStatus.FORBIDDEN)
    }

    @ExceptionHandler
    fun handleMethodArgumentNotValidExceptionn(ex: MethodArgumentNotValidException): ResponseEntity<DefaultErrorMessage> {
        val errorMessage = DefaultErrorMessage(
            HttpStatus.FORBIDDEN.value(),
            ex.message
        )
        return ResponseEntity(errorMessage, HttpStatus.FORBIDDEN)
    }

    @ExceptionHandler
    fun handleBadRequestExceptionn(ex: HttpMessageNotReadableException): ResponseEntity<DefaultErrorMessage> {
        val errorMessage = DefaultErrorMessage(
            HttpStatus.BAD_REQUEST.value(),
            ex.message
        )
        return ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler
    fun handleHttpRequestMethodNotSupportedException(ex: HttpRequestMethodNotSupportedException) : ResponseEntity<DefaultErrorMessage> {
        val errorMessage = DefaultErrorMessage(
            HttpStatus.BAD_REQUEST.value(),
            ex.message
        )
        return ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler
    fun handleHttpInvalidDataAccessResourceUsageException(ex: InvalidDataAccessResourceUsageException) : ResponseEntity<DefaultErrorMessage> {
        val errorMessage = DefaultErrorMessage(
            HttpStatus.BAD_REQUEST.value(),
            ex.message
        )
        return ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler
    fun handleSQLIntegrityConstraintViolationException(ex: SQLIntegrityConstraintViolationException): ResponseEntity<DefaultErrorMessage> {
        val errorMessage = DefaultErrorMessage(
            HttpStatus.FORBIDDEN.value(),
            ex.message
        )
        return ResponseEntity(errorMessage, HttpStatus.FORBIDDEN)
    }

}



