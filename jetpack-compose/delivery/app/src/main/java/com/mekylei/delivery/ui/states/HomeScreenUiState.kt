package com.mekylei.delivery.ui.states

import com.mekylei.delivery.model.Product

data class HomeScreenUiState(
    val sections: Map<String, List<Product>> = emptyMap(),
    val searchText: String = "",
    val searchedProducts: List<Product> = emptyList(),
    val onSearchChange: (String) -> Unit = { }
) {
    fun isShowSections(): Boolean = searchText.isBlank()
}
