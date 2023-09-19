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
import org.springframework.stereotype.Service
import java.util.*

@Service
class ClientService : UserDetailsService {
//(private val passwordEncoder: BCryptPasswordEncoder) //TODO encryot pasasword
//    val encoder = passwordEncoder

    @Autowired
    private lateinit var clientRepository: ClientRepository

    fun createClient(client: ClientProfile): ClientProfile {
        return clientRepository.save(client)
    }


    override fun loadUserByUsername(email: String?): UserDetails {
        val user = clientRepository.findAll().first { it.email == email } ?: throw UsernameNotFoundException("$email not found")
        return UserSecurity(
            idClient = user.idClient,
            name = user.name,
            email = user.email,
            cellphone = user.cellphone,
            uPassword =  user.password,
            Collections.singleton(SimpleGrantedAuthority(AUTH_ROLE))
        )
    }

}