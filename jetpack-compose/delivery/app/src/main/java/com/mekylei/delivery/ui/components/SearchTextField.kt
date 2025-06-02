package com.mekylei.delivery.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mekylei.delivery.ui.screens.homeScreen

@Composable
fun SearchTextField(
    searchText: String,
    onSearchChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = searchText,
        onValueChange = { onSearchChange(it) },
        modifier,
        shape = RoundedCornerShape(100),
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
        label = { Text(text = "O que você procura?") }
    )
}

@Preview(showSystemUi = true)
@Composable
fun SearchTextFieldPreview() {
    homeScreen("")
}

@Preview(showSystemUi = true)
@Composable
fun SearchTextFieldWithSearchTextPreview() {
    homeScreen("ham")
}