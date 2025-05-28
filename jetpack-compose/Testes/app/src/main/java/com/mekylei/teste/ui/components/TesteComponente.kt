package com.mekylei.teste.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.mekylei.teste.R
import com.mekylei.teste.ui.theme.Purple500
import com.mekylei.teste.ui.theme.Purple80

@Composable
fun TesteComponente() {
    Surface(
        Modifier.padding(8.dp),
        shape = RoundedCornerShape(percent = 5),
        shadowElevation = 5.dp
    ) {
        Row(
            Modifier
                .height(200.dp)
                .width(400.dp)
        ) {
            Box(
                Modifier
                    .height(200.dp)
                    .fillMaxHeight()
                    .background(Brush.verticalGradient(listOf(Purple500, Purple80)))
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = null,
                    Modifier
                        .offset(x = 50.dp)
                        .align(Alignment.Center)
                        .clip(shape = CircleShape)
                        .border(2.dp, Purple500, shape = CircleShape)
                )
            }

            Spacer(Modifier.padding(30.dp))

            Text(
                LoremIpsum(50).values.first(),
                Modifier
                    .align(Alignment.CenterVertically),
                maxLines = 6,
            )
        }
    }
}

@Preview
@Composable
private fun TesteComponentePreview() {
    TesteComponente()
}