package br.com.mekylei.rentgames.extensions

import br.com.mekylei.rentgames.entities.GameEntity
import br.com.mekylei.rentgames.model.Game
import br.com.mekylei.rentgames.model.InfoGameJson

fun InfoGameJson.createGame(): Game {
    return Game(
        this.id,
        this.titulo,
        this.capa,
        this.descricao,
        this.preco
    )
}

fun Game.toEntity(): GameEntity {
    return GameEntity(
        this.title,
        this.thumb,
        this.description,
        this.price,
        this.id
    )
}

fun GameEntity.toModel(): Game {
    return Game(
        this.id,
        this.title,
        this.thumb,
        this.description,
        this.price,
    )
}