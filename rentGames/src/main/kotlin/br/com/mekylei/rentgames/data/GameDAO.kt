package br.com.mekylei.rentgames.data

import br.com.mekylei.rentgames.model.Game
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Statement

class GameDAO {

    fun save(game: Game) {
        var conn: Connection? = null
        var stm: PreparedStatement? = null

        try {
            val sql = "insert into jogos(capa, descricao, preco, titulo) values (?, ?, ?, ?)"
            conn = DBProvider.getConnection()
            stm = conn.prepareStatement(sql)
            stm.setString(1, game.thumb)
            stm.setString(2, game.description)
            stm.setBigDecimal(3, game.price)
            stm.setString(4, game.title)

            stm.executeUpdate()

        } finally {
            DBProvider.closeResource(null, stm, conn)
        }
    }

    fun getAll(): List<Game> {
        val games = mutableListOf<Game>()
        var conn: Connection? = null
        var stm: Statement? = null
        var rs: ResultSet? = null

        try {
            conn = DBProvider.getConnection()
            stm = conn.createStatement()
            rs = stm.executeQuery("select * from jogos")

            while (rs.next()) {
                val game = Game(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("capa"),
                    rs.getString("descricao"),
                    rs.getBigDecimal("preco")
                )
                games.add(game)
            }

        } finally {
            DBProvider.closeResource(rs, stm, conn)
        }

        return games
    }
}