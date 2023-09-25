package com.carwash.back.carwash.features.client.service

import com.carwash.back.carwash.features.client.data.ClientRepository
import com.carwash.back.carwash.features.client.model.ClientProfile
import com.carwash.back.carwash.security.UserSecurity
import com.carwash.back.carwash.utils.Constants.AUTH_ROLE
import com.carwash.back.carwash.utils.errors.ItemAlreadyExistsException
import com.carwash.back.carwash.utils.errors.ItemDoesntExistsException
import com.carwash.back.carwash.utils.errors.ItemDoesntExistsException.Companion.DOESNT_EXIST
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.security.SecureRandom
import java.util.*
import kotlin.jvm.optionals.getOrNull

@Service
class ClientService : UserDetailsService {

    @Autowired
    private lateinit var repository: ClientRepository


    fun createClient(client: ClientProfile): ClientProfile? {
        val searchResult = repository.findAll().find { it.email == client.email }
        if (searchResult != null)
            throw ItemAlreadyExistsException(ItemAlreadyExistsException.EXIST)
        else
            return repository.save(encryptPassword(client))
    }


    fun updateClient(clientRequest: ClientProfile, id: Long): ClientProfile? {
        val register = repository.findById(id).getOrNull()
        return if (register != null) {
            if (clientRequest.password != register.password)
                repository.save(encryptPassword(clientRequest.copy(idClient = id)))
            else
                repository.save(clientRequest.copy(idClient = id))
        } else throw ItemDoesntExistsException(DOESNT_EXIST)
    }

    override fun loadUserByUsername(email: String?): UserDetails {
        val user = repository.findAll().first { it.email == email }
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

    fun deleteClientById(id: Long) {
        repository.deleteById(id)
    }


}