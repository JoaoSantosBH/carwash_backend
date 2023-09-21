package com.carwash.back.carwash.utils.errors

class ItemDoesntExistsException(message: String) : RuntimeException(message) {
    companion object {
        const val DOESNT_EXIST = "Ops!!  We didnt find any similar records in our database"
    }
}