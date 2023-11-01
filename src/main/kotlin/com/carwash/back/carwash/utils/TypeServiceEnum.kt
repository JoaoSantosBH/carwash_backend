package com.carwash.back.carwash.utils

enum class TypeServiceEnum(val title: String, val description: String) {
    COMPLETA("Lavagem Completa", "Lavagem completa por dentro e por fora"),
    PARCIAL("Lavagem Parcial", "Lavagem apenas por fora do veículo");
}

enum class TypeCarSizeEnum(val type: String) {
    GRANDE("GRANDE"),
    MEDIO("MEDIO"),
    PEQUENO("PEQUENO");
}

