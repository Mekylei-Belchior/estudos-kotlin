package br.com.mekylei.rentgames.data

import br.com.mekylei.rentgames.entities.PlanEntity
import br.com.mekylei.rentgames.extensions.toEntity
import br.com.mekylei.rentgames.extensions.toModel
import br.com.mekylei.rentgames.model.Plan
import jakarta.persistence.EntityManager

class PlanDAO(manager: EntityManager) : DAO<Plan, PlanEntity>(manager, PlanEntity::class.java) {

    override fun toModel(entity: PlanEntity): Plan {
        return entity.toModel()
    }

    override fun toEntity(model: Plan): PlanEntity {
        return model.toEntity()
    }

}