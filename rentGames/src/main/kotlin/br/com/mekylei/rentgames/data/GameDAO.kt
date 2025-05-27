package br.com.mekylei.rentgames.data

import br.com.mekylei.rentgames.entities.GameEntity
import br.com.mekylei.rentgames.extensions.toEntity
import br.com.mekylei.rentgames.extensions.toModel
import br.com.mekylei.rentgames.model.Game
import jakarta.persistence.EntityManager

class GameDAO(manager: EntityManager) : DAO<Game, GameEntity>(manager, GameEntity::class.java) {

    override fun toModel(entity: GameEntity): Game {
        return entity.toModel()
    }

    override fun toEntity(model: Game): GameEntity {
        return model.toEntity()
    }

}