package com.mekylei.delivery.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.union
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.mekylei.delivery.ui.screens.ProductFormScreen
import com.mekylei.delivery.ui.theme.DeliveryTheme
import com.mekylei.delivery.ui.viewmodelss.ProductFormScreenViewModel

class ProductFromActivity : ComponentActivity() {

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
                        val viewModel: ProductFormScreenViewModel by viewModels()
                        ProductFormScreen(
                            viewModel,
                            onSaveClick = {
                                finish()
                            })
                    }
                }
            }
        }
    }
}