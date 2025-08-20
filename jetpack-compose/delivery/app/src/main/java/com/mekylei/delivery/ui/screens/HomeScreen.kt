package com.mekylei.delivery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mekylei.delivery.sampledata.sampleSections
import com.mekylei.delivery.sampledata.sampleShopSections
import com.mekylei.delivery.ui.components.CardProductItem
import com.mekylei.delivery.ui.components.PartnersSection
import com.mekylei.delivery.ui.components.ProductsSection
import com.mekylei.delivery.ui.components.SearchTextField
import com.mekylei.delivery.ui.states.HomeScreenUiState
import com.mekylei.delivery.ui.theme.DeliveryTheme
import com.mekylei.delivery.ui.viewmodelss.HomeScreenViewModel

@Composable
fun HomeScreen(viewModel: HomeScreenViewModel) {
    val state by viewModel.uiState.collectAsState()
    HomeScreen(state = state)
}


@Composable
fun HomeScreen(state: HomeScreenUiState = HomeScreenUiState()) {
    Column {
        SearchTextField(
            state.searchText,
            onSearchChange = state.onSearchChange,
            Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        )

        LazyColumn(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            if (state.isShowSections()) {
                for (section in state.sections) {
                    val title = section.key
                    val products = section.value
                    item {
                        ProductsSection(
                            title = title,
                            products = products
                        )
                    }
                }
                for (shopSections in sampleShopSections) {
                    val title = shopSections.key
                    val shop = shopSections.value
                    item {
                        PartnersSection(
                            title = title,
                            shops = shop
                        )
                    }
                }
            } else {
                items(state.searchedProducts) { product ->
                    CardProductItem(
                        product,
                        Modifier.padding(horizontal = 16.dp),
                    )
                }
            }
        }
    }
}

val homeScreen: @Composable (text: String?) -> Unit
    get() = { text ->
        DeliveryTheme {
            Surface {
                val state = remember {
                    HomeScreenUiState(
                        searchText = text ?: "",
                        sections = sampleSections
                    )
                }
                HomeScreen(state = state)
            }
        }
    }

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    homeScreen("")
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenWithSearchedTextPreview() {
    homeScreen("ham")
}