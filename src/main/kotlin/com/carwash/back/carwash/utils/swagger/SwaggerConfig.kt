package com.carwash.back.carwash.utils.swagger

import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
    @Bean
    fun publicApi(): GroupedOpenApi? {
        return GroupedOpenApi.builder()
            .group("carwashopenapi-public")
            .pathsToMatch(
                "/login",
                "/client/**",
                "/address/**",
                "/collaborator/**",
                "/wash/**",
                "/schedule/**",
                "/schedule-status/*,*",
                "/vehicle/**",
                "/model/**",
                "/brands",
                "/payment/card/**",
                "/payment/pix/**"
            ).build()
    }
}