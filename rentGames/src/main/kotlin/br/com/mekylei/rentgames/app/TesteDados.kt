package br.com.mekylei.rentgames.app

import br.com.mekylei.rentgames.data.DBProvider
import br.com.mekylei.rentgames.data.GameDAO
import br.com.mekylei.rentgames.data.GamerDAO
import br.com.mekylei.rentgames.data.PlanDAO
import br.com.mekylei.rentgames.model.BasicPlan
import br.com.mekylei.rentgames.model.Game
import br.com.mekylei.rentgames.model.Gamer
import br.com.mekylei.rentgames.model.PremiumPlan
import java.math.BigDecimal

fun main() {
    val theWitcher = Game(
        0,
        "The Witcher 3: Wild Hunt",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/292030/header.jpg?t=1675178392",
        "Um RPG de ação épico com um mundo aberto vasto e envolvente.",
        BigDecimal("4.99")
        )

    val theElderScrolls = Game(
        0,
        "The Elder Scrolls V: Skyrim",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/72850/header.jpg?t=1647357402",
        "Um épico RPG de fantasia, onde você explora um vasto mundo aberto, enfrenta dragões e molda seu próprio destino.",
        BigDecimal("4.99")
    )

    val cyberpunk2077 = Game(
        0,
        "Cyberpunk 2077",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/1091500/header.jpg?t=1687178759",
        "Um RPG de ação futurista, onde você explora uma cidade cyberpunk cheia de conspirações e tecnologia avançada.",
        BigDecimal("3.99")
    )

    val manager = DBProvider.getEntityManager()
//    val gameDAO = GameDAO(manager)
//    gameDAO.save(theWitcher)
//    gameDAO.save(theElderScrolls)
//    gameDAO.save(cyberpunk2077)

//    print(gameDAO.getAll())

    val mekyleiBelchior = Gamer("Mekylei Belchior", "belchior@email.com.br")
    val belchiorMekylei = Gamer("Belchior Mekylei", "mekylei@email.com", "b3lch1or", "25/01/1986")
    val maria = Gamer("Maria Belchior", "maria@email.com.br", "mar1a", "15/06/1950")
    val joao = Gamer("João Almeida", "joao@email.com.br", "j0@0", "30/11/1970")
    val pedro = Gamer("Pedro Faria", "pedro@email.com.br", "p3dr0", "12/02/1998")

//    val basic = BasicPlan(typePlan = "BRONZE")
//    val silver = PremiumPlan(
//        planType = "PRATA",
//        monthlyFee = BigDecimal.valueOf(9.90),
//        includedGames = 3,
//        discountRating = BigDecimal.valueOf(0.15)
//    )
//    val gold = PremiumPlan(
//        planType = "OURO",
//        monthlyFee = BigDecimal.valueOf(19.90),
//        includedGames = 5,
//        discountRating = BigDecimal.valueOf(0.20)
//    )
//    val platinum = PremiumPlan(
//        planType = "PLATINA",
//        monthlyFee = BigDecimal.valueOf(29.90),
//        includedGames = 10,
//        discountRating = BigDecimal.valueOf(0.50)
//    )
//    val diamond = PremiumPlan(
//        planType = "DIAMANTE",
//        monthlyFee = BigDecimal.valueOf(49.90),
//        includedGames = 29,
//        discountRating = BigDecimal.valueOf(0.50)
//    )

//    val gold = PlanDAO(manager).findById(3)
//
//    mekyleiBelchior.plan = gold
//    belchiorMekylei.plan = gold
//    maria.plan = gold
//    joao.plan = gold
//    pedro.plan = gold

    val gamerDAO = GamerDAO(manager)
//    gamerDAO.save(mekyleiBelchior)
//    gamerDAO.save(belchiorMekylei)
//    gamerDAO.save(maria)
//    gamerDAO.save(joao)
//    gamerDAO.save(pedro)
//    gamerDAO.delete(5)

//    gamerDAO.getAll().forEach { gamer -> println(gamer) }

    println(gamerDAO.findById(6))

    manager.close()
}