package br.com.mekylei.rentgames.entities

import br.com.mekylei.rentgames.model.RentalPeriod
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "aluguel")
class RentalEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    @ManyToOne
    val gamer: GamerEntity = GamerEntity(),
    @ManyToOne
    val game: GameEntity = GameEntity(),
    @Embedded
    val rentalPeriod: RentalPeriod
) {
    var cost: BigDecimal = BigDecimal.ZERO
    constructor() : this(gamer = GamerEntity(), game = GameEntity(), rentalPeriod = RentalPeriod())
}