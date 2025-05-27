package br.com.mekylei.rentgames.app

import br.com.mekylei.rentgames.data.DBProvider
import br.com.mekylei.rentgames.data.GameDAO
import br.com.mekylei.rentgames.data.GamerDAO
import br.com.mekylei.rentgames.data.RentalDAO
import br.com.mekylei.rentgames.model.RentalPeriod

fun main() {

    val manager = DBProvider.getEntityManager()
    val gameDAO = GameDAO(manager)
    val gamerDAO = GamerDAO(manager)
    val rentalDAO = RentalDAO(manager)


    val gamer = gamerDAO.findById(1)
    val game = gameDAO.findById(1)
    val rentalGame = gamer.rent(game, RentalPeriod())

    rentalDAO.save(rentalGame)

    val rental = rentalDAO.getAll()
    println(rental)

    manager.close()
}