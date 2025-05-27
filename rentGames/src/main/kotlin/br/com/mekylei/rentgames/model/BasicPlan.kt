package br.com.mekylei.rentgames.model

import java.math.BigDecimal
import java.math.RoundingMode

class BasicPlan(id: Int = 0, typePlan: String = "BRONZE") : Plan(id, typePlan) {
    val defaultDiscount: BigDecimal = BigDecimal("0.1")

    override fun getPrice(rental: Rental): BigDecimal {
        var price = super.getPrice(rental)
        if (rental.gamer.score > 8) {
            price -= price.multiply(defaultDiscount)
        }
        return price.setScale(2, RoundingMode.HALF_UP)
    }
}