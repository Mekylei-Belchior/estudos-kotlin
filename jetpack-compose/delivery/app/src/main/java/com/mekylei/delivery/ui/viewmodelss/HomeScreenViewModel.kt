package com.mekylei.delivery.ui.viewmodelss

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.mekylei.delivery.dao.ProductDAO
import com.mekylei.delivery.model.Product
import com.mekylei.delivery.sampledata.sampleCandies
import com.mekylei.delivery.sampledata.sampleDrinks
import com.mekylei.delivery.sampledata.sampleProducts
import com.mekylei.delivery.ui.states.HomeScreenUiState

class HomeScreenViewModel : ViewModel() {

    private val dao = ProductDAO()

    var uiState: HomeScreenUiState by mutableStateOf(
        HomeScreenUiState(
            sections = mapOf(
                "Todos produtos" to dao.products(),
                "Promoções" to sampleDrinks + sampleCandies,
                "Doces" to sampleCandies,
                "Bebidas" to sampleDrinks
            ),
            onSearchChange = {
                uiState = uiState.copy(
                    searchText = it,
                    searchedProducts = searchedProducts(it)
                )
            }
        ))
        private set


    private fun searchedProducts(text: String): List<Product> =
        if (text.isNotBlank()) {
            sampleProducts.filter(containsInNameOrDescriptions(text)) +
                    dao.products().filter(containsInNameOrDescriptions(text))
        } else emptyList()

    private fun containsInNameOrDescriptions(text: String) = { product: Product ->
        product.name.contains(
            text,
            ignoreCase = true,
        ) || product.description?.contains(
            text,
            ignoreCase = true,
        ) ?: false
    }
}