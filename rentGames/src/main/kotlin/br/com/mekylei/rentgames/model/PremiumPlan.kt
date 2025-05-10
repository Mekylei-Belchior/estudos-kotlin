package br.com.mekylei.rentgames.model

class PremiumPlan(
    planType: String,
    val monthlyFee: Double,
    val includedGames: Int
) : Plan(planType) {
    val freeOfCharge = 0.0

    override fun getPrice(rental: Rental): Double {
        val rentedGames = rental.gamer.getMonthlyRentedGames(rental.rentalPeriod.startDate.monthValue).size + 1
        return if (rentedGames <= includedGames) {
            freeOfCharge
        } else {
            super.getPrice(rental)
        }
    }
}
