package br.com.mekylei.rentgames.data

import jakarta.persistence.EntityManager
import jakarta.persistence.Persistence

object DBProvider {

    private val entityManagerFactory = Persistence.createEntityManagerFactory("rentgames")

    fun getEntityManager(): EntityManager = entityManagerFactory.createEntityManager()

}