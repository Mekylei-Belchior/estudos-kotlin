package com.mekylei.delivery.ui.viewmodelss

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mekylei.delivery.dao.ProductDAO
import com.mekylei.delivery.sampledata.sampleCandies
import com.mekylei.delivery.sampledata.sampleDrinks
import com.mekylei.delivery.sampledata.sampleProducts
import com.mekylei.delivery.ui.states.HomeScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class HomeScreenViewModel : ViewModel() {
    private val dao = ProductDAO()
    private val currentSearchText = MutableStateFlow("")

    val uiState: StateFlow<HomeScreenUiState> = combine(
        dao.products(),
        currentSearchText
    ) { products, searchText ->
        HomeScreenUiState(
            sections = mapOf(
                "Todos produtos" to products,
                "Promoções" to sampleDrinks + sampleCandies,
                "Doces" to sampleCandies,
                "Bebidas" to sampleDrinks
            ),
            searchText = searchText,
            searchedProducts = if (searchText.isNotBlank()) {
                (sampleProducts + products).filter { product ->
                    product.name.contains(searchText, ignoreCase = true) ||
                            (product.description?.contains(searchText, ignoreCase = true) ?: false)
                }
            } else {
                emptyList()
            },
            onSearchChange = { newText -> currentSearchText.value = newText }
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = HomeScreenUiState()
    )
}