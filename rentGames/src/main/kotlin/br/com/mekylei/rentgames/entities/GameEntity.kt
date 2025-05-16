package br.com.mekylei.rentgames.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table(name = "jogos")
class GameEntity(
    val title: String = "",
    val thumb: String = "",
    val description: String? = null,
    val price: BigDecimal = BigDecimal.ZERO,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0
)