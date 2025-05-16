package br.com.mekylei.rentgames.app

import br.com.mekylei.rentgames.data.DBProvider
import br.com.mekylei.rentgames.data.GameDAO
import br.com.mekylei.rentgames.data.GamerDAO
import br.com.mekylei.rentgames.model.Game
import br.com.mekylei.rentgames.model.Gamer
import java.math.BigDecimal

fun main() {
    val theWitcher = Game(
        null,
        "The Witcher 3: Wild Hunt",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/292030/header.jpg?t=1675178392",
        "Um RPG de ação épico com um mundo aberto vasto e envolvente.",
        BigDecimal("4.99")
        )

    val theElderScrolls = Game(
        null,
        "The Elder Scrolls V: Skyrim",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/72850/header.jpg?t=1647357402",
        "Um épico RPG de fantasia, onde você explora um vasto mundo aberto, enfrenta dragões e molda seu próprio destino.",
        BigDecimal("4.99")
    )

    val cyberpunk2077 = Game(
        null,
        "Cyberpunk 2077",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/1091500/header.jpg?t=1687178759",
        "Um RPG de ação futurista, onde você explora uma cidade cyberpunk cheia de conspirações e tecnologia avançada.",
        BigDecimal("3.99")
    )

    val manager = DBProvider.getEntityManager()
//    val gameDAO = GameDAO(manager)
//    gameDAO.save(theWitcher)
//    gameDAO.save(theElderScrolls)
//    gameDAO.save(cyberpunk2077)

//    print(gameDAO.getAll())

    val gamer1 = Gamer("Mekylei Belchior", "belchior@email.com.br")
    val gamer2 = Gamer("Belchior Mekylei", "mekylei@email.com", "b3lch1or", "25/01/1986")

    val gamerDAO = GamerDAO(manager)
    gamerDAO.save(gamer1)
    gamerDAO.save(gamer2)

    print(gamerDAO.getAll())

    manager.close()
}