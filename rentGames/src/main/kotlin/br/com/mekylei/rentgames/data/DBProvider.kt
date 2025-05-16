package br.com.mekylei.rentgames.data

import java.sql.*

object DBProvider {

    fun getConnection(): Connection {
        val url = "jdbc:postgresql://localhost:5432/rentgames"
        val user = "mekylei"
        val password = "mekylei"

        return try {
            DriverManager.getConnection(url, user, password)
        } catch (e: SQLException) {
            throw DBProviderException("A conexão com o banco de dados não foi estabelecida", e)
        }
    }

    fun closeResource(rs: ResultSet?, stm: Statement?, con: Connection?) {
        rs?.close()
        stm?.close()
        con?.close()
    }

}

class DBProviderException(message: String, cause: Throwable? = null) : RuntimeException(message, cause)