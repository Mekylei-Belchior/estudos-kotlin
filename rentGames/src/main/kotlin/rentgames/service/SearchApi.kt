package rentgames.service

import com.google.gson.Gson
import rentgames.model.InfoGame
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class SearchApi {

    fun findBy(id: String): InfoGame {
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=$id"))
            .build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        val json = response.body()

        val gson = Gson()
        try {
            return gson.fromJson(json, InfoGame::class.java)
        } catch (e: Exception) {
            throw ApiException("Jogo não encontrado.")
        }
    }

}

class ApiException(msg: String) : RuntimeException(msg)