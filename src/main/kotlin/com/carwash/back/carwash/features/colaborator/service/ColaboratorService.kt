package com.carwash.back.carwash.features.colaborator.service

import com.carwash.back.carwash.features.colaborator.data.CollaboratorRepository
import com.carwash.back.carwash.features.user.model.UserEntity
import com.carwash.back.carwash.utils.encryptPassword
import com.carwash.back.carwash.utils.errors.ItemAlreadyExistsException
import com.carwash.back.carwash.utils.errors.ItemDoesntExistsException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class ColaboratorService  {

    @Autowired
    private lateinit var repository: CollaboratorRepository

    fun createCollaborator(collaboratorRequest: UserEntity): UserEntity? {
        val searchResult = repository.findAll().find { it.email == collaboratorRequest.email }
        if (searchResult != null)
            throw ItemAlreadyExistsException(ItemAlreadyExistsException.EXIST)
        else
            return repository.save(collaboratorRequest.copy(password = collaboratorRequest.password.encryptPassword()))
    }

    fun updateCollaborator(collaboratorRequest: UserEntity, id: Long): UserEntity? {
        val register = repository.findById(id).getOrNull()
        return if (register != null) {
            if (collaboratorRequest.password != register.password)
                repository.save(collaboratorRequest.copy(idUser = id, password = collaboratorRequest.password.encryptPassword()))
            else
                repository.save(collaboratorRequest.copy(idUser = id))
        } else throw ItemDoesntExistsException(ItemDoesntExistsException.DOESNT_EXIST)

    }

    fun deleteCollaboratorById(id: Long) {
        return repository.deleteById(id)
    }

}
