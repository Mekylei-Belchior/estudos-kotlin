package br.com.mekylei.rentgames.extensions

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.toAge(): Int {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val birthDate = LocalDate.parse(this, formatter)
    return Period.between(birthDate, LocalDate.now()).years
}