package br.com.mekylei.rentgames.extensions

import br.com.mekylei.rentgames.entities.GamerEntity
import br.com.mekylei.rentgames.model.Gamer
import br.com.mekylei.rentgames.model.InfoGamerJson

fun InfoGamerJson.createGamer(): Gamer {
    return Gamer(
        this.nome,
        this.email,
        this.usuario,
        this.dataNascimento
    )
}

fun Gamer.toEntity(): GamerEntity {
    return GamerEntity(
        this.name,
        this.email,
        this.userName,
        this.birthdate,
        this.id,
        this.plan.toEntity()
    )
}

fun GamerEntity.toModel(): Gamer {
    return Gamer(
        this.name,
        this.email,
        this.userName,
        this.birthdate,
        this.id,
    )
}