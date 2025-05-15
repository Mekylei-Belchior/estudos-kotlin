package br.com.mekylei.rentgames.model

import java.math.BigDecimal

data class InfoGameJson(val titulo: String, val capa: String, val preco: BigDecimal, val descricao: String) {

    override fun toString(): String {
        return "InfoGameJson(titulo='$titulo', capa='$capa', preco='$preco', descricao='$descricao')"
    }

}
