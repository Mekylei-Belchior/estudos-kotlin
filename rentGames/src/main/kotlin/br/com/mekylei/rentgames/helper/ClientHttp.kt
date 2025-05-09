package br.com.mekylei.rentgames.helper

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

abstract class ClientHttp {

    inline fun <reified T> request(url: String): List<T> {
        val json = doRequest(url)
        val gson = Gson()
        try {
            val type = object : TypeToken<List<T>>() {}.type
            return gson.fromJson(json, type)
        } catch (e: JsonSyntaxException) {
            throw ClientHttpException("Erro ao desserializar o JSON: ${e.message}", e)
        } catch (e: Exception) {
            throw ClientHttpException("A consulta de dados apresentou inconsistência: ${e.message}", e)
        }
    }

    fun <T> request(url: String, clazz: Class<T>): T {
        val json = doRequest(url)

        val gson = Gson()
        try {
            return gson.fromJson(json, clazz)
        } catch (e: JsonSyntaxException) {
            throw ClientHttpException("Erro ao desserializar o JSON: ${e.message}", e)
        } catch (e: Exception) {
            throw ClientHttpException("A consulta de dados apresentou inconsistência: ${e.message}", e)
        }
    }

    fun doRequest(source: String): String {
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(source))
            .build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        return response.body()
    }
}

class ClientHttpException(
    message: String,
    cause: Throwable? = null
) : RuntimeException(message, cause)

class AppHttpClient : ClientHttp()