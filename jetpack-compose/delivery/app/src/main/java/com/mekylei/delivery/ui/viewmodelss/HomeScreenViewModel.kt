package com.mekylei.delivery.ui.viewmodelss

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mekylei.delivery.dao.ProductDAO
import com.mekylei.delivery.model.Product
import com.mekylei.delivery.sampledata.sampleCandies
import com.mekylei.delivery.sampledata.sampleDrinks
import com.mekylei.delivery.sampledata.sampleProducts
import com.mekylei.delivery.ui.states.HomeScreenUiState
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel() {

    private val dao = ProductDAO()

    private val _onSearchChange: (String) -> Unit = { newText ->
        uiState = uiState.copy(
            searchText = newText,
            searchedProducts = searchedProducts(newText)
        )
    }

    var uiState: HomeScreenUiState by mutableStateOf(
        HomeScreenUiState(
            onSearchChange = _onSearchChange
        )
    )
        private set

    init {
        viewModelScope.launch {
            dao.products().collect { products ->
                uiState = uiState.copy(
                    sections = mapOf(
                        "Todos produtos" to products,
                        "Promoções" to sampleDrinks + sampleCandies,
                        "Doces" to sampleCandies,
                        "Bebidas" to sampleDrinks
                    )
                )
            }
        }
    }

    private fun searchedProducts(text: String): List<Product> =
        if (text.isNotBlank()) {
            sampleProducts.filter(containsInNameOrDescriptions(text)) +
                    dao.products().value.filter(containsInNameOrDescriptions(text))
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