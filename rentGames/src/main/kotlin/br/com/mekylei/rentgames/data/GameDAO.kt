package br.com.mekylei.rentgames.data

import br.com.mekylei.rentgames.entities.GameEntity
import br.com.mekylei.rentgames.model.Game
import jakarta.persistence.EntityManager

class GameDAO(val manager: EntityManager) {

    fun save(game: Game) {
        val entity = GameEntity(game.title, game.thumb, game.description, game.price)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }

    fun getAll(): List<Game> {
        val query = manager.createQuery("FROM GameEntity", GameEntity::class.java)
        return query.resultList.map { entity ->
            Game(
                entity.id,
                entity.title,
                entity.thumb,
                entity.description,
                entity.price
            )
        }
    }

}