package com.mekylei.delivery.model

import java.math.BigDecimal

data class Product(
    val name: String = "",
    val price: BigDecimal = BigDecimal.ZERO,
    val image: String? = null,
    val description: String? = null
)
