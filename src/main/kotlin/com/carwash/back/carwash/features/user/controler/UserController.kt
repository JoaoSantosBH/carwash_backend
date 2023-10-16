package com.carwash.back.carwash.features.user.controler

import com.carwash.back.carwash.features.user.model.UserEntity
import com.carwash.back.carwash.features.user.service.UserService
import com.carwash.back.carwash.utils.Endpoints.ADD_CLIENT_ENDPOINT
import com.carwash.back.carwash.utils.Endpoints.LOGIN_ENDPOINT
import com.carwash.back.carwash.utils.Endpoints.UPDATE_CLIENT_ENDPOINT
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.security.Principal


@RestController
class UserController() {

    @Autowired
    lateinit var service: UserService

    @PostMapping(ADD_CLIENT_ENDPOINT)
    fun createClient(@RequestBody clientRequest: UserEntity): UserEntity? {
        return service.createClient(clientRequest)
    }

    @PutMapping(UPDATE_CLIENT_ENDPOINT)
    fun updateClient(@RequestBody clientRequest: UserEntity, @PathVariable id: Long): UserEntity? {
        return service.updateClient(clientRequest, id)
    }

    @DeleteMapping(UPDATE_CLIENT_ENDPOINT)
    fun deleteClientById(@PathVariable id: Long): ResponseEntity<*>? {
        service.deleteClientById(id)
        return ResponseEntity.noContent().build<Any>()
    }

    @GetMapping(LOGIN_ENDPOINT)
    fun getUser(@RequestBody clientRequest: UserEntity): UserEntity? {
        return clientRequest
    }

}


interface IAuthenticationFacade {
    val authentication: Authentication?
}


@Component
class AuthenticationFacade : IAuthenticationFacade {
    override val authentication: Authentication?
        get() = SecurityContextHolder.getContext().authentication
}
@RestController
class GetUserWithAuthenticationPrincipalAnnotationController {
    @GetMapping("/user")
    fun getUser(@AuthenticationPrincipal userDetails: UserDetails): String {
        return "User Details: " + userDetails.username
    }
}

@Controller
class GetUserWithCustomInterfaceController {
    @Autowired
    private val authenticationFacade: IAuthenticationFacade? = null
    @RequestMapping(value = ["/id_user"], method = [RequestMethod.GET])
    @ResponseBody
    fun currentUserNameSimple(): String {
        val authentication = authenticationFacade!!.authentication
        return authentication!!.name
    }
}

@Controller
class GetUserWithPrincipalController {
    @RequestMapping(value = ["/username"], method = [RequestMethod.GET])
    @ResponseBody
    fun currentUserName(principal: Principal): String {
        return principal.name
    }
}
