package br.com.mekylei.rentgames.app

import br.com.mekylei.rentgames.model.Gamer

fun main() {
    val gamer1 = Gamer("Mekylei Belchior", "belchior@email.com.br")
    val gamer2 = Gamer("Belchior Mekylei", "mekylei@email.com", "b3lch1or", "25/01/1986")

    println(gamer1)
    println(gamer2)

    gamer2.let { it.name = "Mekylei" }.also { println(gamer2.name) }

    gamer1.name = "Mekylei Frank Soares Belchior"
    println(gamer1)
}