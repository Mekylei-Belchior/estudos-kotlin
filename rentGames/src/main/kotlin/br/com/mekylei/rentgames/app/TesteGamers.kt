package br.com.mekylei.rentgames.app

import br.com.mekylei.rentgames.constants.DataUrl
import br.com.mekylei.rentgames.model.Game
import br.com.mekylei.rentgames.model.Gamer
import br.com.mekylei.rentgames.model.RentalPeriod
import br.com.mekylei.rentgames.service.SearchApi
import java.time.LocalDate

fun main() {
    val gamers: List<Gamer> = SearchApi().findGamers(DataUrl.GAMERS)
    val games: List<Game> = SearchApi().findGames(DataUrl.GAMES)

    //gamers.forEach { it -> println(it) }
    //games.forEach { it -> println(it) }

    val monica = gamers[0]
    val period = RentalPeriod(LocalDate.now(), LocalDate.now().plusDays(7))
    val rental = monica.rental(games[1], period)

    println(rental)

}