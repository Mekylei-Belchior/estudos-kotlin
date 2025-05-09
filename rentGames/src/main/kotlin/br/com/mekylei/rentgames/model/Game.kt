package br.com.mekylei.rentgames.model

data class Game(val title: String, val thumb: String) {

    var id: Int? = null
    var description: String? = null
    var price: Double = 0.0

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