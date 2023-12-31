package com.carwash.back.carwash.security

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserSecurity(
    val idUser: Long,
    val name: String,
    val email: String,
    val cellphone: String,
    private val uPassword: String,
    private val uAuthorities: MutableCollection<GrantedAuthority>,
    val vehicleId: Long,
    val addressId: Long,
    val userType: Int
) : UserDetails {
    override fun getAuthorities() = uAuthorities
    override fun getPassword() = uPassword
    override fun getUsername() = email
    override fun isAccountNonExpired() = true
    override fun isAccountNonLocked() = true
    override fun isCredentialsNonExpired() = true
    override fun isEnabled() = true

}