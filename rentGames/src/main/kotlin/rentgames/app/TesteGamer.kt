package rentgames.app

import rentgames.model.Gamer

fun main() {
    val gamer1 = Gamer("Mekylei Belchior", "mekyleibelchior@gmail.com.br")
    val gamer2 = Gamer("Belchior Mekylei", "mekylei@msn.com", "B3lch1or", "05/10/1985")

    println(gamer1)
    println(gamer2)

    gamer2.let { it.name = "Mekylei" }.also { println(gamer2.name) }

    gamer1.name = "Mekylei Frank Soares Belchior"
    println(gamer1)
}