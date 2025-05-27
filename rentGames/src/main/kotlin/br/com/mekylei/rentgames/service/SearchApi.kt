package br.com.mekylei.rentgames.service

import br.com.mekylei.rentgames.helper.AppHttpClient
import br.com.mekylei.rentgames.helper.ClientHttpException
import br.com.mekylei.rentgames.model.*
import br.com.mekylei.rentgames.extensions.createGame
import br.com.mekylei.rentgames.extensions.createGamer

class SearchApi {

    fun findBy(id: String): InfoGame {
        try {
            val appHttpClient = AppHttpClient()
            return appHttpClient.request("https://www.cheapshark.com/api/1.0/games?id=$id", InfoGame::class.java)
        } catch (e: ClientHttpException) {
            throw ApiException("Jogo não encontrado. ${e.message}", e)
        }
    }

    fun findGamers(url: String): List<Gamer> {
        try {
            val appHttpClient = AppHttpClient()
            val gamers: List<InfoGamerJson> = appHttpClient.request(url)
            return gamers.map { gamerJson -> gamerJson.createGamer() }
        } catch (e: ClientHttpException) {
            throw ApiException("Jogadores não encontrados. ${e.message}", e)
        }
    }

    fun findGames(url: String): List<Game> {
        try {
            val appHttpClient = AppHttpClient()
            val games: List<InfoGameJson> = appHttpClient.request(url)
            return games.map { gameJson -> gameJson.createGame() }
        } catch (e: ClientHttpException) {
            throw ApiException("Jogos não encontrados. ${e.message}", e)
        }
    }

}

class ApiException(
    message: String,
    cause: Throwable? = null
) : RuntimeException(message, cause)