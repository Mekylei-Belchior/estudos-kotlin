package br.com.mekylei.rentgames.model

import java.time.LocalDate
import java.time.Period

data class RentalPeriod(
    val start: LocalDate,
    val end: LocalDate) {
    val rentDays = Period.between(start, end).days
}
