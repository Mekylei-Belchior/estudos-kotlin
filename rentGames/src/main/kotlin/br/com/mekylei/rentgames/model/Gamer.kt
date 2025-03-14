package br.com.mekylei.rentgames.model

import br.com.mekylei.rentgames.util.RegexUtils
import br.com.mekylei.rentgames.util.toAge
import java.util.*
import kotlin.random.Random

data class Gamer(var name: String, var email: String) {
    private var userId: String? = null

    private var userName: String? = null
        set(value) {
            field = value
            if (userId.isNullOrBlank()) {
                userId = createIdentifier()
            }
        }

    private var birthdate: String? = null

    var games = mutableListOf<Game?>()


    constructor(name: String, email: String, userName: String, birthdate: String) : this(name, email) {
        this.userName = userName
        this.birthdate = birthdate
        this.printAge()
        this.createIdentifier()
    }

    init {
        if (name.isBlank()) throw IllegalArgumentException("O nome é inválido!")
        this.email = validateEmail()
    }

    private fun createIdentifier(): String {
        val number = Random(10000).nextInt()
        val sequence = String.format("%04d", number)
        return "$userName#$sequence"
    }

    private fun validateEmail(): String {
        val regex = Regex(RegexUtils.EMAIL_PATTERN)
        if (regex.matches(email)) {
            return email
        }
        throw IllegalArgumentException("E-mail inválido")
    }

    companion object {
        fun createGamer(scan: Scanner): Gamer {
            println("Boas vindas ao RentGames! Vamos fazer seu cadastro.")

            println("Digite o seu nome:")
            val name = scan.nextLine()

            println("Digite o seu e-mail:")
            val email = scan.nextLine()

            println("Deseja completar o seu cadastro com usuário e data de nascimento (S: Sim | N: Não)?")
            val answer = scan.nextLine()

            if ("S".equals(answer, true)) {
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val birthdate = scan.nextLine()

                println("Digite seu nome de usuário:")
                val user = scan.nextLine()

                return Gamer(name, email, user, birthdate)
            } else {
                return Gamer(name, email)
            }
        }
    }

    override fun toString(): String {
        return "Gamer(name='$name', email='$email', userId=$userId, userName=$userName, brithDate=$birthdate)"
    }

    fun printSorted(byField: String = "id") {
        when (byField.lowercase()) {
            "title" -> games.sortedBy { it?.title }
            "description" -> games.sortedBy { it?.description }
            else -> games.sortedBy { it?.id }
        }
        if (games.isNotEmpty()) {
            println("\nJogos alugados pelo jogador:")
            games.forEach { g -> println(g?.id.toString() + " - " + g?.title) }
        }
    }

    private fun printAge() {
        if (!this.birthdate.isNullOrBlank()) {
            val regex = Regex(RegexUtils.DATA)
            if (regex.matches(this.birthdate!!)) {
                println()
                println("Idade do jogador: " + this.birthdate!!.toAge().toString())
                println()
            }
        }
    }

}