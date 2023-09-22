package com.carwash.back.carwash.utils.errors


class ItemAlreadyExistsException(message: String) : RuntimeException(message) {
    companion object {
        const val EXIST = "Ops!! This item already exists in our database"
    }
}

class ItemDoesntExistsException(message: String) : RuntimeException(message) {
    companion object {
        const val DOESNT_EXIST = "Ops!!  We didnt find any similar records in our database"
    }
}