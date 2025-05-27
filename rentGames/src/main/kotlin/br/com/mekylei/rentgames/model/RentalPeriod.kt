package br.com.mekylei.rentgames.model

import jakarta.persistence.Embeddable
import java.time.LocalDate
import java.time.Period

@Embeddable
data class RentalPeriod(
    val startDate: LocalDate = LocalDate.now(),
    val endDate: LocalDate = LocalDate.now().plusDays(7)
) {
    val rentDays = Period.between(startDate, endDate).days
}
