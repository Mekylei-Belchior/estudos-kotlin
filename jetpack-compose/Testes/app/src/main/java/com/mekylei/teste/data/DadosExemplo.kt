package com.mekylei.teste.data

import com.mekylei.teste.R
import com.mekylei.teste.model.Produto
import java.math.BigDecimal

val amostraProdutos = listOf(
    Produto(
        nome = "Hamburger",
        preco = BigDecimal("14.99"),
        imagem = R.drawable.burger
    ),
    Produto(
        nome = "Pizza",
        preco = BigDecimal("19.99"),
        imagem = R.drawable.pizza
    ),
    Produto(
        nome = "Batata frita",
        preco = BigDecimal("6.99"),
        imagem = R.drawable.batata
    )
)

val hamburgerPicanha = Produto(
    nome = "Hamburger Picanha",
    preco = BigDecimal("18.99"),
    imagem = R.drawable.burger
)