package br.com.mekylei.rentgames.data

import br.com.mekylei.rentgames.entities.GamerEntity
import br.com.mekylei.rentgames.model.Gamer
import jakarta.persistence.EntityManager

class GamerDAO(val manager: EntityManager) {

    fun save(gamer: Gamer) {
        val entity = GamerEntity(
            gamer.name,
            gamer.email,
            gamer.userName,
            gamer.birthdate
        )
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }

    fun getAll(): List<Gamer> {
        val query = manager.createQuery("FROM GamerEntity", GamerEntity::class.java)
        return query.resultList.map { entity ->
            Gamer(
                entity.name,
                entity.email,
                entity.userName,
                entity.birthdate,
                entity.id
            )
        }
    }

}