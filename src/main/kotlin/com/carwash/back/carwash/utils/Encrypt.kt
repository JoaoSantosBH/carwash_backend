package com.carwash.back.carwash.utils

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.security.SecureRandom

fun String.encryptPassword(): String {
    val bCryptPasswordEncoder = BCryptPasswordEncoder(10, SecureRandom())
    return bCryptPasswordEncoder.encode(this)
}