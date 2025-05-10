package br.com.mekylei.rentgames.model

data class Rental(
    val gamer: Gamer,
    val game: Game,
    val rentalPeriod: RentalPeriod
) {
    val cost = gamer.plan.getPrice(this)

    override fun toString(): String {
        return "\n${gamer.name} alugou o jogo:" +
                "\n$game" +
                "\n- Total aluguel (${rentalPeriod.rentDays} dias): R$ $cost"
    }

}
