package br.com.mekylei.rentgames.interfaces

interface Recommendable {
    val score: Double

    fun recommend(rating: Int)
}