package com.carwash.back.carwash

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CarwashApplication

fun main(args: Array<String>) {
	runApplication<CarwashApplication>(*args)
}
