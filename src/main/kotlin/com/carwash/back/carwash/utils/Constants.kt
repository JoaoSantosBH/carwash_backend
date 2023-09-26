package com.carwash.back.carwash.utils

object Constants {

    const val WELCOME_TEXT = "CarWash API v1.1.0 - 2023\n by joaomarcelo.ms@gmail.com"
    const val AUTH_ROLE = "user"
    const val TOKEN_PREFIX = "Bearer "
    const val EXPIRATION_TOKEN_TIME = 6000000
    const val BAD_CREDENTIALS = "Email or password incorrect"
}


object Endpoints {

    const val ROOT_ENDPOINT = "/"
    //Client
    const val ADD_CLIENT_ENDPOINT = "/client"
    const val UPDATE_CLIENT_ENDPOINT = "/client/{id}"

    //Collaborator
    const val ADD_COLLABORATOR_ENDPOINT = "/collaborator"
    const val UPDATE_COLLABORATOR_ENDPOINT = "/collaborator/{id}"

    //Wash
    const val ADD_SERVICE_ENDPOINT  = "/service"
    const val GET_SERVICE_BY_ID_ENDPOINT = "/service/{id}"

    //Schedule
    const val ADD_SCHEDULE_ENDPOINT  = "/schedule"
    const val GET_SCHEDULE_BY_ID_ENDPOINT = "/schedule/{id}"
    const val GET_ALL_SCHEDULE_BY_CLIENT_ID = "/schedule/client/{id}"
    const val GET_ALL_SCHEDULE_BY_COLLABORATOR_ID = "/schedule/colaborator/{id}"
    const val GET_ALL_SCHEDULE_BY_STATUS_ID = "/schedule/status/{id}"
    const val GET_SUM_COLLABORATOR_RANK = "/rankcolab/{id}"

    val WHITE_LIST = "/api/auth/**"

}