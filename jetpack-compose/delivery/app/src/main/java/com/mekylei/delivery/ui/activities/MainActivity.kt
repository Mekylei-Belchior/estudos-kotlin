package com.mekylei.delivery.ui.activities

import android.content.Intent
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.mekylei.delivery.ui.screens.HomeScreen
import com.mekylei.delivery.ui.theme.DeliveryTheme
import com.mekylei.delivery.ui.viewmodels.HomeScreenViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            DeliveryTheme {
                App(onProductAddAction = {
                    startActivity(
                        Intent(
                            this,
                            ProductFromActivity::class.java
                        )
                    )
                }) {
                    val viewModel by viewModels<HomeScreenViewModel>()
                    HomeScreen(viewModel)
                }
            }
        }
    }
}

@Composable
fun App(
    onProductAddAction: () -> Unit = {},
    content: @Composable () -> Unit = {},
) {
    val insets = WindowInsets.systemBars.union(WindowInsets.ime)
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentWindowInsets = insets,
        floatingActionButton = {
            FloatingActionButton(onClick = onProductAddAction) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            content()
        }
    }
}
