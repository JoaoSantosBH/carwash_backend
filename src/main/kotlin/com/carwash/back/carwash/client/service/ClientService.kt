package com.carwash.back.carwash.client.service

import com.carwash.back.carwash.client.data.ClientRepository
import com.carwash.back.carwash.client.model.ClientProfile
import com.carwash.back.carwash.security.UserSecurity
import com.carwash.back.carwash.utils.Constants.AUTH_ROLE
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.security.SecureRandom
import java.util.*

@Service
class ClientService : UserDetailsService {

    @Autowired
    private lateinit var clientRepository: ClientRepository


    fun createClient(client: ClientProfile): ClientProfile? {
        return clientRepository.save(encryptPassword(client))
    }

    override fun loadUserByUsername(email: String?): UserDetails {
        val user = clientRepository.findAll().first { it.email == email }
            ?: throw UsernameNotFoundException("$email not found")
        return UserSecurity(
            idClient = user.idClient,
            name = user.name,
            email = user.email,
            cellphone = user.cellphone,
            uPassword = user.password,
            Collections.singleton(SimpleGrantedAuthority(AUTH_ROLE))
        )
    }

    private fun encryptPassword(client: ClientProfile): ClientProfile {
        val bCryptPasswordEncoder = BCryptPasswordEncoder(10, SecureRandom())
        val encodedPassword: String = bCryptPasswordEncoder.encode(client.password)
        return client.copy(password = encodedPassword)
    }

}


class ErrorMessageModel(
    status: Int? = null,
    message: String? = null
) : Throwable()