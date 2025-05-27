package br.com.mekylei.rentgames.extensions

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

fun Double.round(): Double {
    val decimalFormat = DecimalFormat("#.00", DecimalFormatSymbols(Locale.US))
    return decimalFormat.format(this).toDouble()
}