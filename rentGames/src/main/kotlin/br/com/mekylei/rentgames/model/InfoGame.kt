package br.com.mekylei.rentgames.model

data class InfoGame(val info: InfoApiShark) {

    override fun toString(): String {
        return info.toString()
    }
}
