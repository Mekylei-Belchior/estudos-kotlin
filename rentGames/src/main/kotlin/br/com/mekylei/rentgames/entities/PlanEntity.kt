package br.com.mekylei.rentgames.entities

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "planos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TipoPlano", discriminatorType = DiscriminatorType.STRING)
abstract class PlanEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Int = 0,
    open val planType: String
)

@Entity
@DiscriminatorValue("BASIC")
class BasicPlanEntity(
    id: Int = 0,
    planType: String = "BRONZE"
) : PlanEntity(id, planType)

@Entity
@DiscriminatorValue("PREMIUM")
open class PremiumPlanEntity(
    id: Int = 0,
    planType: String = "PRATA",
    open val monthlyFee: BigDecimal = BigDecimal.ZERO,
    open val includedGames: Int = 0,
    open val discountRating: BigDecimal = BigDecimal.ZERO
) : PlanEntity(id, planType)