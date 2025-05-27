package br.com.mekylei.rentgames.data

import br.com.mekylei.rentgames.entities.RentalEntity
import br.com.mekylei.rentgames.extensions.toEntity
import br.com.mekylei.rentgames.extensions.toModel
import br.com.mekylei.rentgames.model.Rental
import jakarta.persistence.EntityManager

class RentalDAO(manager: EntityManager): DAO<Rental, RentalEntity>(manager, RentalEntity::class.java) {

    override fun toModel(entity: RentalEntity) = entity.toModel()

    override fun toEntity(model: Rental) = model.toEntity()

}