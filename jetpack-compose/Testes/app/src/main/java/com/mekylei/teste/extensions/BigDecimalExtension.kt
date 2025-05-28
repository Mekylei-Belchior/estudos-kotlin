package com.mekylei.teste.extensions

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

fun BigDecimal.toReal(): String {
    return NumberFormat
        .getCurrencyInstance(Locale("pt", "br"))
        .format(this)
}