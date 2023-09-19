package com.carwash.back.carwash

import com.carwash.back.carwash.utils.Constants.WELCOME_TEXT
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class CarwashApplication {
	@GetMapping("/")
	fun hello() = WELCOME_TEXT

}

fun main(args: Array<String>) {
	runApplication<CarwashApplication>(*args)
}
