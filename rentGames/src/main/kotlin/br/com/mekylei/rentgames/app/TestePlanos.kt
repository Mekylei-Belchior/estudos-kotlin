package br.com.mekylei.rentgames.app

import br.com.mekylei.rentgames.data.DBProvider
import br.com.mekylei.rentgames.data.PlanDAO
import br.com.mekylei.rentgames.model.BasicPlan
import br.com.mekylei.rentgames.model.PremiumPlan
import java.math.BigDecimal

fun main() {
    /*
    val basic = BasicPlan(typePlan = "BRONZE")
    val silver = PremiumPlan(
        planType = "PRATA",
        monthlyFee = BigDecimal.valueOf(9.90),
        includedGames = 3,
        discountRating = BigDecimal.valueOf(0.15)
    )
    val gold = PremiumPlan(
        planType = "OURO",
        monthlyFee = BigDecimal.valueOf(19.90),
        includedGames = 5,
        discountRating = BigDecimal.valueOf(0.20)
    )
    val platinum = PremiumPlan(
        planType = "PLATINA",
        monthlyFee = BigDecimal.valueOf(29.90),
        includedGames = 10,
        discountRating = BigDecimal.valueOf(0.50)
    )
    val diamond = PremiumPlan(
        planType = "DIAMANTE",
        monthlyFee = BigDecimal.valueOf(49.90),
        includedGames = 29,
        discountRating = BigDecimal.valueOf(0.50)
    )

    val manager = DBProvider.getEntityManager()
    val planDAO = PlanDAO(manager)

    planDAO.save(basic)
    planDAO.save(silver)
    planDAO.save(gold)
    planDAO.save(platinum)
    planDAO.save(diamond)
     */

    val manager = DBProvider.getEntityManager()
    val planDAO = PlanDAO(manager)
    val plans = planDAO.getAll()
    println(plans)

    manager.close()
}