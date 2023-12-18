package com.carwash.back.carwash.utils

object Constants {

    const val WELCOME_TEXT = "CarWash API v1.1.0 - 2023\n by joaomarcelo.ms@gmail.com"
    const val AUTH_ROLE = "user"
    const val TOKEN_PREFIX = "Bearer "
    const val EXPIRATION_TOKEN_TIME = 6000000
    const val BAD_CREDENTIALS = "Email or password incorrect"
    const val NOTIFICATION_URL = "https://meusite.com/notificacoes"
    val MY_NOTIFICATION_URI = listOf(NOTIFICATION_URL)
    const val CURRENCY = "BRL"
    const val COUNTRY_CODE = "55"
    const val COUNTRY_PREFIX = "BRA"
    const val EMPTY_STRING = ""
    const val SYSTEM_VENDOR_PARCEL = .85
    const val DOT = "."
    const val STRING_ONE = "1"
    const val ZERO = 0
    const val EMPTY_LINE = "\n"
    const val STRING_PLUS = "+"
    const val STRNG_COMA = ","
    const val WASH_DESC_ASPIRE = "aspirar "
    const val WASH_DESC_LITTTLE = "pretinho "
    const val WASH_DESC_SILICON = "silicone "
    const val WASH_DESC_WAX = "encerar "

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
    const val VIA_CEP_ENDPOINT = "/zip/{zipNumber}"
    const val VIA_CEP_BASE_URL = "http://viacep.com.br/ws/"
    const val VIA_CEP_SUFIX = "/json"

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

    //PagSeguro
    const val PAYMENT_ENDPOINT = "/payment"
    const val PAYMENT_CARD_ENDPOINT = "/card/{userId}"
    const val PAYMENT_PIX_ENDPOINT = "/pix/{userId}"

    //PagSeguro
    const val PAG_SEG_BASE_PROD = "https://pagseguro.uol.com.br"
    const val PAG_SEG_BASE_HOMOLOG  = "https://sandbox.pagseguro.uol.com.br"
    const val PAG_SEG_WS_PROD  = "https://ws.pagseguro.uol.com.br"
    const val PAG_SEG_WS_HOMOLOG  = "https://ws.sandbox.pagseguro.uol.com.br"
    const val PAG_SEG_STC_PROD  = "https://stc.pagseguro.uol.com.br"
    const val PAG_SEG_STC_HOMOLOG  =  "https://stc.sandbox.pagseguro.uol.com.br"

    const val PAG_SEG_CHECKOUT = "/v2/checkout"

    const val PAG_SEG_STC_HOMOLOG_APP_ID = "app6375771195"
    const val PAG_SEG_STC_HOMOLOG_APP_KEY = "1CA8534EEBEB27277458AFBBC5E7EB34"

    const val VENDEDOR_TESTE =  "v64323580785146011048@sandbox.pagseguro.com.br"
    const val SENHA_TESTE = "k13RHlrhwy3a3gNv"
    const val CHAVE_PUBLICA = "PUB5BC03464993749D1BF3AD09993EBF154"
    
}