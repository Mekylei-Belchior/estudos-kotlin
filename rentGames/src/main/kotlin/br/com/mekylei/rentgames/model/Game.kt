package br.com.mekylei.rentgames.model

import br.com.mekylei.rentgames.interfaces.Recommendable
import com.google.gson.annotations.Expose

data class Game(@Expose val title: String, @Expose val thumb: String): Recommendable {

    var id: Int? = null
    var description: String? = null
    var price: Double = 0.0
    private val reviews = mutableListOf<Int>()
    override val score: Double
        get() = reviews.average()

    override fun recommend(rating: Int) {
        reviews.add(rating)
    }

    constructor(title: String, thumb: String, description: String, price: Double): this(title, thumb) {
        this.description = description
        this.price = price
    }

    override fun toString(): String {
        return "\n- Código   : ${this.id ?: '-'}" +
                "\n- Título   : $title" +
                "\n- Capa     : $thumb" +
                "\n- Descrição: $description" +
                "\n- Preço    : $price"
    }

}