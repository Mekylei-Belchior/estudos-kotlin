package com.mekylei.teste.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mekylei.teste.data.amostraProdutos
import com.mekylei.teste.model.Produto

@Composable
fun SessaoProdutos(titulo: String, produtos: List<Produto>) {
    Column {
        Text(
            titulo,
            fontSize = 18.sp,
            fontWeight = FontWeight.W700
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(
                    top = 8.dp,
                )
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {
            for (produto in produtos) {
                ProdutoItem(produto)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SessaoProdutosPreview() {
    SessaoProdutos("Promoções", amostraProdutos)
}