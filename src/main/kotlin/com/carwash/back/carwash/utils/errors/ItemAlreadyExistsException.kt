package com.carwash.back.carwash.utils.errors

class ItemAlreadyExistsException(message: String) : RuntimeException(message) {
    companion object {
        const val EXIST = "Ops!! This item already exists in our database"
    }
}