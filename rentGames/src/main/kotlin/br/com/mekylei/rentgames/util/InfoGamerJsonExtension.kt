package br.com.mekylei.rentgames.util

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