package br.com.mekylei.rentgames.app

import br.com.mekylei.rentgames.data.GameDAO
import br.com.mekylei.rentgames.model.Game
import java.math.BigDecimal

fun main() {
    val theWitcher = Game(
        null,
        "The Witcher 3: Wild Hunt",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/292030/header.jpg?t=1675178392",
        "Um RPG de ação épico com um mundo aberto vasto e envolvente.",
        BigDecimal("4.99")
        )

    val gameDAO = GameDAO()
    //gameDAO.save(theWitcher)

    print(gameDAO.getAll())
}