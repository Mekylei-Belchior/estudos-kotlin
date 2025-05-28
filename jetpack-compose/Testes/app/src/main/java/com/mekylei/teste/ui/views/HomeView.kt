package com.mekylei.teste.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mekylei.teste.data.amostraProdutos
import com.mekylei.teste.model.Produto
import com.mekylei.teste.ui.components.SessaoProdutos
import com.mekylei.teste.ui.theme.TestesTheme

@Composable
fun HomeView() {
    TestesTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState())
                        .padding(bottom = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    SessaoProdutos("Promoções", amostraProdutos)
                    SessaoProdutos("Doces", listOf(Produto()))
                    SessaoProdutos("Bebidas", listOf(Produto(), Produto(), Produto()))
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomePreview() {
    HomeView()
}