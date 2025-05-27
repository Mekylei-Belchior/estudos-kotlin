package br.com.mekylei.rentgames.model

import br.com.mekylei.rentgames.extensions.round
import br.com.mekylei.rentgames.interfaces.Recommendable
import com.google.gson.annotations.Expose
import java.math.BigDecimal

data class Game(@Expose val title: String, @Expose val thumb: String) : Recommendable {

    var id: Int = 0
    var description: String? = null
    var price: BigDecimal = BigDecimal.ZERO
    private val reviews = mutableListOf<Int>()
    override val score: Double
        get() = reviews.average().round()

    override fun recommend(rating: Int) {
        reviews.add(rating)
    }

    constructor(id: Int = 0, title: String, thumb: String, description: String?, price: BigDecimal) : this(title, thumb) {
        this.description = description
        this.price = price
        this.id = id
    }

    override fun toString(): String {
        return "\n- Código   : $id" +
                "\n- Título   : $title" +
                "\n- Capa     : $thumb" +
                "\n- Descrição: ${this.description ?: '-'}" +
                "\n- Preço    : $price" +
                "\n- Avaliação: $score"
    }

}