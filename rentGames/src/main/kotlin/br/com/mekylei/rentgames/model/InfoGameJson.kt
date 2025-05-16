package br.com.mekylei.rentgames.model

import java.math.BigDecimal

data class InfoGameJson(val id: Int, val titulo: String, val capa: String, val preco: BigDecimal, val descricao: String) {

    override fun toString(): String {
        return "InfoGameJson(id='$id', titulo='$titulo', capa='$capa', preco='$preco', descricao='$descricao')"
    }

}
