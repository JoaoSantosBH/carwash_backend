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
    const val WHITE_LIST = "/api/auth/**"

    //Login
    const val LOGIN_ENDPOINT = "/login"

    //Client
    const val CLIENT_ENDPOINT = "/client"
    const val CLIENT_ENDPOINT_PATH = "/client/{id}"

    //Address
    const val ADDRESS_ENDPOINT = "/address"
    const val ADDRESS_ENDPOINT_PATH = "/address/{userId}"

    //Collaborator
    const val COLLABORATOR_ENDPOINT = "/collaborator"
    const val COLLABORATOR_ENDPOINT_PATH = "/collaborator/{id}"

    //Wash
    const val SERVICE_ENDPOINT  = "/wash"
    const val SERVICE_ENDPOINT_PATH = "/wash/{id}"

    //Schedule
    const val SCHEDULE_ENDPOINT  = "/schedule"
    const val SCHEDULE_ENDPOINT_PATH = "/schedule/{id}"
    const val SCHEDULE_ENDPOINT_PATH_CLIENT_ID = "/schedule/client/{id}"
    const val SCHEDULE_ENDPOINT_PATH_COLLABORATOR_ID = "/schedule/colaborator/{id}"
    const val SCHEDULE_ENDPOINT_PATH_STATUS = "/schedule/status/{id}"
    const val SCHEDULE_ENDPOINT_PATH_COLLABORATOR_RANK = "/rankcolab/{id}"

    //Schedule Status
    const val GET_SCHEDULE_STATUS_NAME_ENDPOINT = "/schedule-status/{id}"


    //Vehicle
    const val VEHICLE_ENDPOINT =  "/vehicle"
    const val VEHICLE_ENDPOINT_PATH =  "/vehicle/{userId}"
    const val MODEL_ENDPOINT_PATH = "/model/{brandId}"
    const val BRANDS_ENDPOINT = "/brands"

}