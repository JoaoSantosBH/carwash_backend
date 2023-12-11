package com.carwash.back.carwash.utils

enum class TypeServiceEnum(val title: String, val description: String) {
    COMPLETA("Lavagem Completa", "Dentro e fora: "),
    PARCIAL("Lavagem Parcial", "Fora: ");
}

enum class TypeCarSizeEnum(val type: String) {
    GRANDE("GRANDE"),
    MEDIO("MEDIO"),
    PEQUENO("PEQUENO");
}

