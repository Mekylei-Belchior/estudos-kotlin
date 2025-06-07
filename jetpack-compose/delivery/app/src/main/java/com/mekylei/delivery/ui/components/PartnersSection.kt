package com.mekylei.delivery.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mekylei.delivery.model.Shop
import com.mekylei.delivery.sampledata.sampleShops
import com.mekylei.delivery.ui.theme.DeliveryTheme

@Composable
fun PartnersSection(
    title: String,
    shops: List<Shop>,
    modifier: Modifier = Modifier
) {
    Section(
        modifier = modifier,
        title = {
            Text(
                text = title,
                Modifier.padding(
                    start = 16.dp,
                    end = 16.dp
                ),
                fontSize = 20.sp,
                fontWeight = FontWeight(400),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        },
        content = {
            LazyRow(
                Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(shops) { shop ->
                    CardPartner(shop = shop, modifier = modifier)
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun PartnersSectionPreview() {
    DeliveryTheme {
        Surface {
            PartnersSection(
                title = "Parceiros",
                sampleShops
            )
        }
    }
}