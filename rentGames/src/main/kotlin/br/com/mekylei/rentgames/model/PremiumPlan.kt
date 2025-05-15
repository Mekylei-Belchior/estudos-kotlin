package br.com.mekylei.rentgames.model

import java.math.BigDecimal
import java.math.RoundingMode

class PremiumPlan(
    planType: String,
    val monthlyFee: BigDecimal,
    val includedGames: Int,
    val discountRating: BigDecimal
) : Plan(planType) {
    val freeOfCharge: BigDecimal = BigDecimal.ZERO

    override fun getPrice(rental: Rental): BigDecimal {
        val rentedGames = rental.gamer.getMonthlyRentedGames(rental.rentalPeriod.startDate.monthValue).size + 1
        return if (rentedGames <= includedGames) {
            freeOfCharge
        } else {
            var price = super.getPrice(rental)
            if (rental.gamer.score > 8) {
                price -= price.multiply(discountRating)
            }
            return price.setScale(2, RoundingMode.HALF_UP)
        }
    }
}
