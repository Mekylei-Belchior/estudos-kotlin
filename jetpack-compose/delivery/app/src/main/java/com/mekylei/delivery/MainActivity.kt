package com.mekylei.delivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.mekylei.delivery.sampledata.sampleSections
import com.mekylei.delivery.ui.screens.HomeScreen
import com.mekylei.delivery.ui.theme.DeliveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    DeliveryTheme {
        Surface {
            HomeScreen(
                sampleSections
            )
        }
    }
}