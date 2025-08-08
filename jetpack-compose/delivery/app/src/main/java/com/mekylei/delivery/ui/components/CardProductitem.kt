package com.mekylei.delivery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mekylei.delivery.R
import com.mekylei.delivery.extensions.toBrazilianCurrency
import com.mekylei.delivery.model.Product
import com.mekylei.delivery.sampledata.sampleProducts
import com.mekylei.delivery.ui.theme.DeliveryTheme
import java.math.BigDecimal


@Composable
fun CardProductItem(
    product: Product,
    modifier: Modifier = Modifier,
    elevation: CardElevation = CardDefaults.cardElevation(),
    expanded: Boolean = false
) {
    var expandedState by rememberSaveable { mutableStateOf(expanded) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(150.dp)
            .clickable { expandedState = !expandedState },
        elevation = elevation
    ) {
        Column {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                placeholder = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.inversePrimary)
                    .padding(16.dp)
            ) {
                Text(
                    text = product.name
                )
                Text(
                    text = product.price.toBrazilianCurrency()
                )
            }
            if (expandedState) {
                product.description?.let {
                    Text(
                        text = product.description,
                        Modifier
                            .padding(16.dp),
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun CardProductItemPreview() {
    DeliveryTheme {
        Surface {
            CardProductItem(
                product = sampleProducts.random(),
                expanded = false,
            )
        }
    }
}


@Preview
@Composable
private fun CardProductItemWithDescriptionPreview() {
    DeliveryTheme {
        Surface {
            CardProductItem(
                product = Product(
                    "Hamburger",
                    BigDecimal("45.25"),
                    description = LoremIpsum(50).values.first(),
                ),
                expanded = true
            )
        }
    }
}