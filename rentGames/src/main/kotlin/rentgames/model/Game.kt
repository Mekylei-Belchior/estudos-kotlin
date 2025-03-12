package rentgames.model

data class Game(val id: Int, val title: String, val thumb: String) {

    var description: String? = null

    override fun toString(): String {
        return "- Código   : $id\n- Título   : $title\n- Capa     : $thumb\n- Descrição: $description \n"
    }

}