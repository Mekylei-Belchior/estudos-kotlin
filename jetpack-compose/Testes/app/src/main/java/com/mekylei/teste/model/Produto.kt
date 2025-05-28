package com.mekylei.teste.model

import androidx.annotation.DrawableRes
import com.mekylei.teste.R
import java.math.BigDecimal

data class Produto(
    val nome: String = "Produto",
    val preco: BigDecimal = BigDecimal.ZERO,
    @DrawableRes val imagem: Int = R.drawable.placeholder
)
