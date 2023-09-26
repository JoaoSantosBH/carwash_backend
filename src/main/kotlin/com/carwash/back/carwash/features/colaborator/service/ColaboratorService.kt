package com.carwash.back.carwash.features.colaborator.service

import com.carwash.back.carwash.features.colaborator.data.CollaboratorRepository
import com.carwash.back.carwash.features.colaborator.model.CollaboratorProfile
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

    fun createCollaborator(collaboratorRequest: CollaboratorProfile): CollaboratorProfile? {
        val searchResult = repository.findAll().find { it.email == collaboratorRequest.email }
        if (searchResult != null)
            throw ItemAlreadyExistsException(ItemAlreadyExistsException.EXIST)
        else
            return repository.save(collaboratorRequest.copy(password = collaboratorRequest.password.encryptPassword()))
    }

    fun updateCollaborator(collaboratorRequest: CollaboratorProfile, id: Long): CollaboratorProfile? {
        val register = repository.findById(id).getOrNull()
        return if (register != null) {
            if (collaboratorRequest.password != register.password)
                repository.save(collaboratorRequest.copy(idColaborator = id, password = collaboratorRequest.password.encryptPassword()))
            else
                repository.save(collaboratorRequest.copy(idColaborator = id))
        } else throw ItemDoesntExistsException(ItemDoesntExistsException.DOESNT_EXIST)

    }

    fun deleteCollaboratorById(id: Long) {
        return repository.deleteById(id)
    }


//    override fun loadUserByUsername(email: String?): UserDetails {
//        val collaborator = repository.findAll().first { it.email == email }
//            ?: throw UsernameNotFoundException("$email not found")
//        return CollaboratorSecurity(
//            idColaborator = collaborator.idColaborator,
//            name = collaborator.name,
//            email = collaborator.email,
//            cellphone = collaborator.cellphone,
//            rank = collaborator.colabRank,
//            washesNumber = collaborator.washesNumber,
//            badgeStatus = collaborator.badgeStatus,
//            uPassword = collaborator.password,
//            Collections.singleton(SimpleGrantedAuthority(Constants.AUTH_ROLE))
//        )
//    }

}
