package com.carwash.back.carwash.features.login_register.service

import com.carwash.back.carwash.features.login_register.data.ClientRepository
import com.carwash.back.carwash.features.login_register.model.ClientProfile
import com.carwash.back.carwash.security.UserSecurity
import com.carwash.back.carwash.utils.Constants.AUTH_ROLE
import com.carwash.back.carwash.utils.errors.ItemAlreadyExistsException
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
        val searchResult = clientRepository.findAll().find { it.email == client.email }
        if (searchResult != null)
            throw ItemAlreadyExistsException(ItemAlreadyExistsException.EXIST)
        else
            return clientRepository.save(encryptPassword(client))
    }

    //TODO finalizar CRUD

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