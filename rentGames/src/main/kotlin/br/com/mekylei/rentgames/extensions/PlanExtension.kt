package br.com.mekylei.rentgames.extensions

import br.com.mekylei.rentgames.entities.BasicPlanEntity
import br.com.mekylei.rentgames.entities.PlanEntity
import br.com.mekylei.rentgames.entities.PremiumPlanEntity
import br.com.mekylei.rentgames.model.BasicPlan
import br.com.mekylei.rentgames.model.Plan
import br.com.mekylei.rentgames.model.PremiumPlan

fun Plan.toEntity(): PlanEntity {
    return if (this is PremiumPlan) {
        PremiumPlanEntity(
            this.id,
            this.planType,
            this.monthlyFee,
            this.includedGames,
            this.discountRating
        )
    } else {
        BasicPlanEntity(
            this.id,
            this.planType
        )
    }
}

fun PlanEntity.toModel(): Plan {
    return if (this is PremiumPlanEntity) {
        PremiumPlan(
            this.id,
            this.planType,
            this.monthlyFee,
            this.includedGames,
            this.discountRating
        )
    } else {
        BasicPlan(
            this.id,
            this.planType
        )
    }
}