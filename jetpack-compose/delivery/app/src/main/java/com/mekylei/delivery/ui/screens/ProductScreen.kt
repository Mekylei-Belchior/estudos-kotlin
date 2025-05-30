package com.mekylei.delivery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mekylei.delivery.model.Product
import com.mekylei.delivery.sampledata.sampleProducts
import com.mekylei.delivery.ui.components.ProductItem

@Composable
fun ProductScreen(products: List<Product>) {
    Column {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 128.dp),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item(span = { GridItemSpan(this.maxLineSpan) }) {
                Text(
                    text = "Todos os Produtos",
                    Modifier.padding(8.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight(400)
                )
            }
            items(products) { product ->
                ProductItem(product = product)
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ProductScreenPreview() {
    ProductScreen(sampleProducts)
}