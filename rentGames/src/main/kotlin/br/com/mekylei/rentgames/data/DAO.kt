package br.com.mekylei.rentgames.data

import jakarta.persistence.EntityManager

abstract class DAO<M, E>(protected val manager: EntityManager, protected val entityType: Class<E>) {

    abstract fun toModel(entity: E): M

    abstract fun toEntity(model: M): E

    private fun find(id: Int): E {
        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE id =: id", entityType)
        query.setParameter("id", id)
        return query.singleResult
    }

    open fun findById(id: Int): M {
        val entity = find(id)
        return toModel(entity)
    }

    open fun getAll(): List<M> {
        val query = manager.createQuery("FROM ${entityType.simpleName}", entityType)
        return query.resultList.map { entity -> toModel(entity) }
    }

    open fun save(model: M) {
        val entity = toEntity(model)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }

    open fun delete(id: Int) {
        val entity = find(id)
        manager.transaction.begin()
        manager.remove(entity)
        manager.transaction.commit()
    }

}