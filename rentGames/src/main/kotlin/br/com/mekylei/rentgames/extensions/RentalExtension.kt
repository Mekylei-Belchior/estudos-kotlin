package br.com.mekylei.rentgames.extensions

import br.com.mekylei.rentgames.entities.RentalEntity
import br.com.mekylei.rentgames.model.Rental

fun Rental.toEntity() = RentalEntity(
    id = this.id,
    gamer = this.gamer.toEntity(),
    game = this.game.toEntity(),
    rentalPeriod = this.rentalPeriod
).also { it.cost = this.cost }

fun RentalEntity.toModel() = Rental(
    id = this.id,
    gamer = this.gamer.toModel(),
    game = this.game.toModel(),
    rentalPeriod = this.rentalPeriod
).also { it.cost = this.cost }