package com.julietgisemba.artspace

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.julietgisemba.artspace.data.DataSource

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ArtScreen() {
    val artPieces = DataSource.loadArts()
    var currentIndex by remember {
        mutableStateOf(0)
    }

    val currentArt = artPieces[currentIndex]


    Column(
        modifier = Modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
//            modifier = Modifier.size(250.dp, 350.dp),
            shape = RectangleShape,
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(20.dp),
        ) {
            Image(modifier = Modifier
                .size(300.dp, 450.dp)
                .padding(20.dp),painter = rememberImagePainter(data = currentArt.image), contentDescription = "Art Image")

        }

        Card(
            shape = RectangleShape
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.Bottom
                ) {
                Text(text = currentArt.title, style = TextStyle(fontSize = 20.sp))
                Text(text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Medium))
                    {
                        append(currentArt.photographer)
                    }
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Light))
                    {
                        append(" (${currentArt.year})")
                    }
                })
            }
        }

        Row {
            Button(onClick = {
                if (currentIndex > 0) {
                    currentIndex--
                }
            }, enabled = currentIndex > 0) {
                Text(text = "Previous")
            }
            Button(onClick = {
                if (currentIndex < artPieces.size - 1) {
                    currentIndex ++
                }
            },
                enabled = currentIndex < artPieces.size - 1)
            {
                Text(text = "Next")
            }
        }
    }
}