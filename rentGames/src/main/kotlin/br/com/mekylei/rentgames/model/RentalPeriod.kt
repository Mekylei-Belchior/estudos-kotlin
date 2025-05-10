package br.com.mekylei.rentgames.model

import java.time.LocalDate
import java.time.Period

data class RentalPeriod(
    val startDate: LocalDate,
    val endDate: LocalDate) {
    val rentDays = Period.between(startDate, endDate).days
}
