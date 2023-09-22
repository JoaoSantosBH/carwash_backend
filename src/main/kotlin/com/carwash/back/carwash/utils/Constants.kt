package com.carwash.back.carwash.utils

object Constants {

    const val WELCOME_TEXT = "CarWash API v1.1.0 - 2023\n by joaomarcelo.ms@gmail.com"
    const val AUTH_ROLE = "user"
    const val TOKEN_PREFIX = "Bearer "
    const val EXPIRATION_TOKEN_TIME = 6000000
}


object Endpoints {
    const val ROOT_ENDPOINT = "/"
    const val ADD_USER_ENDPOINT = "/client"
    //Wash
    const val ADD_SERVICE_ENDPOINT  = "/service"
    const val GET_SERVICE_BY_ID_ENDPOINT = "/service/{id}"
    //Schedule
    const val ADD_SCHEDULE_ENDPOINT  = "/schedule"
    const val GET_SCHEDULE_BY_ID_ENDPOINT = "/schedule/{id}"
    const val GET_ALL_SCHEDULE_BY_CLIENT_ID = "/schedule/client/{id}"
    const val GET_ALL_SCHEDULE_BY_COLABORATOR_ID = "/schedule/colaborator/{id}"
    const val GET_ALL_SCHEDULE_BY_STATUS_ID = "/schedule/status/{id}"


}