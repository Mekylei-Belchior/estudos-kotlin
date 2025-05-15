package br.com.mekylei.rentgames.app

import br.com.mekylei.rentgames.constants.DataUrl
import br.com.mekylei.rentgames.model.Game
import br.com.mekylei.rentgames.model.Gamer
import br.com.mekylei.rentgames.model.RentalPeriod
import br.com.mekylei.rentgames.service.SearchApi
import com.google.gson.GsonBuilder
import java.io.File
import java.time.LocalDate

fun main() {
    val gamers: List<Gamer> = SearchApi().findGamers(DataUrl.GAMERS)
    val games: List<Game> = SearchApi().findGames(DataUrl.GAMES)

    //gamers.forEach { it -> println(it) }
    //games.forEach { it -> println(it) }

    val monica = gamers[0]

    val theWitcher = games[0]
    val theLastOfUs = games[2]
    val redDeadRedemption = games[3]
    val godOfWar = games[7]

    val period1 = RentalPeriod(LocalDate.now(), LocalDate.now().plusDays(7))
    val period2 = RentalPeriod(LocalDate.now(), LocalDate.now().plusDays(3))
    val period3 = RentalPeriod(LocalDate.now(), LocalDate.now().plusDays(10))
    val period4 = RentalPeriod(LocalDate.of(2025, 5, 9), LocalDate.of(2025, 5, 22))

    monica.rent(theWitcher, period1)
    monica.rent(theLastOfUs, period2)
    monica.rent(redDeadRedemption, period3)
    monica.rent(godOfWar, period4)

    monica.rentalGames.forEach { it -> println(it) }

    monica.recommendGame(theWitcher, 8)
    monica.recommendGame(redDeadRedemption, 10)
    monica.recommendGame(godOfWar, 8)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val json = gson.toJson(monica.recommendedGames)

    val file = File("recommended-${monica.name}.json")
    file.writeText(json)

    println(file.absolutePath)

}