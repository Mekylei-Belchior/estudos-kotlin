package br.com.mekylei.rentgames.util

import br.com.mekylei.rentgames.model.Game
import br.com.mekylei.rentgames.model.InfoGameJson

fun InfoGameJson.createGame(): Game {
    return Game(
        this.titulo,
        this.capa,
        this.descricao,
        this.preco
    )
}