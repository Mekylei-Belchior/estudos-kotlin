package br.com.mekylei.rentgames.model

import java.math.BigDecimal
import java.math.RoundingMode

sealed class Plan(planType: String) {

    open fun getPrice(rental: Rental): Double {
        return BigDecimal(rental.game.price * rental.rentalPeriod.rentDays)
            .setScale(2, RoundingMode.HALF_UP).toDouble()
    }
}