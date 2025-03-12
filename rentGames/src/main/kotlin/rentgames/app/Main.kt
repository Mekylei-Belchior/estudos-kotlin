package rentgames.app

import rentgames.model.Game
import rentgames.model.Gamer
import rentgames.service.SearchApi
import java.util.*

fun main() {

    val scan = Scanner(System.`in`)
    var answer: String?

    val gamer = Gamer.createGamer(scan)
    //val gamer = Gamer("Mekylei Belchior", "mekylei@msn.com", "b3lch1or", "05/10/1985")
    var game: Game? = null

    do {
        val result = runCatching {
            println("Digite um código de jogo para buscar:")
            val idGame = scan.nextLine()
            val myInfoGame = SearchApi().findBy(idGame)
            game = Game(Integer.parseInt(idGame), myInfoGame.info.title, myInfoGame.info.thumb)
        }

        result.onFailure { e -> println(e.message + " Tente outro código!") }
        result.onSuccess {
            println("Deseja inserir uma descrição personalizada (S: Sim | N: Não)?")
            answer = scan.nextLine()
            if ("S".equals(answer, true)) {
                println("Insira a descrição personalizada:")
                game?.description = scan.nextLine()
            } else {
                game?.description = game?.title
            }

            gamer.games.add(game)
            println(game)
        }

        println("\nRealizar nova busca?")
        answer = scan.nextLine()

    } while ("S".equals(answer, true))

    if (gamer.games.size > 0) {
        gamer.printSorted("title")

        while (true) {
            println("\nDeseja remover um jogo?")
            answer = scan.nextLine()

            if ("S".equals(answer, true)) {
                if (gamer.games.isNotEmpty()) {
                    println("Informe o código do jogo você quer remover?")
                    val removeId = scan.nextInt()
                    scan.nextLine()

                    if (gamer.games.any { it?.id == removeId }) {
                        gamer.games.removeIf { it?.id == removeId }
                    } else {
                        println("\nATENÇÃO: O jogo de código ($removeId) não pertence a lista de jogos selecionados para a locação!")
                    }
                    gamer.printSorted()
                } else {
                    println("\nTodos os jogos selecionados para a logação foram removidos!")
                    break
                }
            } else {
                break
            }
        }
    }

    println("\nOperação finalizada com sucesso!")
}