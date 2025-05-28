package com.mekylei.teste.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mekylei.teste.data.hamburgerPicanha
import com.mekylei.teste.extensions.toReal
import com.mekylei.teste.model.Produto
import com.mekylei.teste.ui.theme.Purple500
import com.mekylei.teste.ui.theme.Teal200


@Composable
fun ProdutoItem(produto: Produto) {
    Surface(
        shape = RoundedCornerShape(percent = 10),
        shadowElevation = 5.dp
    ) {
        Column(
            Modifier
                .height(250.dp)
                .width(200.dp)
        ) {
            Box(
                Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .background(Brush.horizontalGradient(listOf(Purple500, Teal200)))
            ) {
                Image(
                    painter = painterResource(id = produto.imagem),
                    contentDescription = null,
                    Modifier
                        .size(100.dp)
                        .offset(y = 50.dp)
                        .align(Alignment.BottomCenter)
                        .clip(shape = CircleShape),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(Modifier.padding(top = 50.dp))

            Column(Modifier.padding(vertical = 8.dp, horizontal = 14.dp)) {
                Text(
                    produto.nome,
                    fontWeight = FontWeight.W700,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 18.sp,
                    maxLines = 2
                )
                Text(
                    text = produto.preco.toReal(),
                    Modifier.padding(top = 8.dp),
                    fontWeight = FontWeight.W200,
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProdutoItemPreview() {
    ProdutoItem(hamburgerPicanha)
}