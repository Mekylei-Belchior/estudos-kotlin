package br.com.mekylei.rentgames.model

import java.math.BigDecimal
import java.math.RoundingMode

sealed class Plan(var id: Int = 0, open val planType: String) {

    open fun getPrice(rental: Rental): BigDecimal {
        return rental.game.price.multiply(rental.rentalPeriod.rentDays.toBigDecimal())
            .setScale(2, RoundingMode.HALF_UP)
    }
}