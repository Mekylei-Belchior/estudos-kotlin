package br.com.mekylei.rentgames.model

data class InfoGameJson(val titulo: String, val capa: String, val preco: Double, val descricao: String) {

    override fun toString(): String {
        return "InfoGameJson(titulo='$titulo', capa='$capa', preco='$preco', descricao='$descricao')"
    }

}
