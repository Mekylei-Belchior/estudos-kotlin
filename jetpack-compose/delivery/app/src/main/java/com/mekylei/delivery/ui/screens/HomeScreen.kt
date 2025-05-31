package com.mekylei.delivery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mekylei.delivery.model.Product
import com.mekylei.delivery.sampledata.sampleSections
import com.mekylei.delivery.ui.components.ProductsSection
import com.mekylei.delivery.ui.theme.DeliveryTheme

@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>
) {
    var text by remember { mutableStateOf("") }

    Column(Modifier.padding(top = 40.dp)) {
        OutlinedTextField(
            value = text,
            onValueChange = { newValue -> text = newValue },
            Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 24.dp
                )
                .fillMaxWidth(),
            shape = RoundedCornerShape(100),
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = null)
            },
            label = {Text(text = "O que você procura?")}
        )

        LazyColumn(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(8.dp)
        ) {
            for (section in sections) {
                val title = section.key
                val products = section.value
                item {
                    ProductsSection(
                        title = title,
                        products = products
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    DeliveryTheme {
        Surface {
            HomeScreen(sampleSections)
        }
    }
}