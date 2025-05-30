package br.com.mekylei.rentgames.model

import br.com.mekylei.rentgames.extensions.round
import br.com.mekylei.rentgames.extensions.toAge
import br.com.mekylei.rentgames.interfaces.Recommendable
import br.com.mekylei.rentgames.util.RegexUtils
import java.util.*
import kotlin.random.Random

data class Gamer(var name: String, var email: String) : Recommendable {
    var id: Int = 0
    private var userId: String? = null

    var userName: String? = null
        set(value) {
            field = value
            if (userId.isNullOrBlank()) {
                userId = createIdentifier()
            }
        }

    var birthdate: String? = null

    val games = mutableListOf<Game?>()

    val rentalGames = mutableListOf<Rental>()

    var plan: Plan = BasicPlan()

    val recommendedGames = mutableListOf<Game>()

    private val reviews = mutableListOf<Int>()

    override val score: Double
        get() = reviews.average().round()

    override fun recommend(rating: Int) {
        if (rating < 1 || rating > 10) {
            throw IllegalArgumentException("Avaliação inválida. Insira uma nota de avaliação entre 1 e 10")
        } else {
            reviews.add(rating)
        }
    }

    constructor(name: String, email: String, userName: String?, birthdate: String?, id: Int = 0) : this(name, email) {
        this.userName = userName
        this.birthdate = birthdate
        //this.printAge()
        this.id = id
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
        return "\n- ID             : $id" +
                "\n- Nome           : $name" +
                "\n- E-mail         : $email" +
                "\n- Código usuário : $userId" +
                "\n- Usuário        : $userName" +
                "\n- Data Nascimento: $birthdate" +
                "\n- Reputação      : $score"
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
                println("Idade do jogador [${this.userName}]: " + this.birthdate!!.toAge().toString())
                println()
            }
        }
    }

    fun rent(game: Game, period: RentalPeriod): Rental {
        val rentalGame = Rental(0,this, game, period)
        rentalGames.add(rentalGame)
        return rentalGame
    }

    fun getMonthlyRentedGames(month: Int): List<Game> {
        return rentalGames
            .filter { rental -> rental.rentalPeriod.startDate.monthValue == month }
            .map { rental -> rental.game }
    }

    fun recommendGame(game: Game, rating: Int) {
        game.recommend(rating)
        recommendedGames.add(game)
    }

}