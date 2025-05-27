package br.com.mekylei.rentgames.entities

import jakarta.persistence.*

@Entity
@Table(name = "gamers")
data class GamerEntity(
    val name: String = "",
    val email: String = "",
    val userName: String? = null,
    val birthdate: String? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    @ManyToOne
    val plan: PlanEntity = BasicPlanEntity()
)