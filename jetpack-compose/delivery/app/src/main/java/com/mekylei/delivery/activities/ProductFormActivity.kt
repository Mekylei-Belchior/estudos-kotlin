package com.mekylei.delivery.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.union
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import coil.compose.AsyncImage
import com.mekylei.delivery.R
import com.mekylei.delivery.dao.ProductDAO
import com.mekylei.delivery.model.Product
import com.mekylei.delivery.ui.theme.DeliveryTheme
import java.math.BigDecimal

class ProductFromActivity : ComponentActivity() {
    private val dao = ProductDAO()

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            DeliveryTheme {
                val insets = WindowInsets.systemBars.union(WindowInsets.ime)
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    contentWindowInsets = insets
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        ProductFormScreen(onSaveClick = { product ->
                            dao.save(product)
                            finish()
                        })
                    }
                }
            }
        }
    }
}

@Composable
fun ProductFormScreen(
    modifier: Modifier = Modifier,
    onSaveClick: (Product) -> Unit = {},
) {
    var url by rememberSaveable { mutableStateOf("") }
    var name by rememberSaveable { mutableStateOf("") }
    var price by rememberSaveable { mutableStateOf("") }
    var description by rememberSaveable { mutableStateOf("") }

    Column(
        Modifier
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Spacer(modifier = Modifier)

        Text(
            text = "Criando o produto",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 21.sp
        )

        if (url.isNotBlank()) {
            AsyncImage(
                model = url,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.placeholder),
                error = painterResource(id = R.drawable.placeholder)
            )
        }

        TextField(
            value = url,
            label = { Text(text = "Url da imagem") },
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { url = it },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Uri,
                imeAction = ImeAction.Next
            )
        )

        TextField(
            value = name,
            label = { Text(text = "Nome") },
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { name = it },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
        )

        TextField(
            value = price,
            label = { Text(text = "Preço") },
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { price = it },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next
            )
        )

        TextField(
            value = description,
            label = { Text(text = "Descrição") },
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp),
            onValueChange = { description = it },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            )
        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                val product = Product(
                    name = name,
                    image = url,
                    price = price.let {
                        try {
                            BigDecimal(it.replace(",", "."))
                        } catch (e: NumberFormatException) {
                            BigDecimal.ZERO
                        }
                    },
                    description = description
                )
                Log.i("ProductFormScreen", "ProdutctFromScreen: $product")
                onSaveClick(product)
            }
        ) {
            Text(text = "Salvar")
        }

        Spacer(modifier = Modifier)
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductFormScreenPreview() {
    ProductFormScreen()
}