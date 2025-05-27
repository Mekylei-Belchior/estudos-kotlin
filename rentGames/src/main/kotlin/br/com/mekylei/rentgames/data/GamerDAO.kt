package br.com.mekylei.rentgames.data

import br.com.mekylei.rentgames.entities.GamerEntity
import br.com.mekylei.rentgames.extensions.toEntity
import br.com.mekylei.rentgames.extensions.toModel
import br.com.mekylei.rentgames.model.Gamer
import jakarta.persistence.EntityManager

class GamerDAO(manager: EntityManager) : DAO<Gamer, GamerEntity>(manager, GamerEntity::class.java) {

    override fun toModel(entity: GamerEntity): Gamer {
        return entity.toModel().apply { plan = entity.plan.toModel() }
    }

    override fun toEntity(model: Gamer): GamerEntity {
        return model.toEntity()
    }

}