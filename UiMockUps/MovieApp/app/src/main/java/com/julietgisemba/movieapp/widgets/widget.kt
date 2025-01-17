package com.julietgisemba.movieapp.widgets

import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.julietgisemba.movieapp.model.Movie
import com.julietgisemba.movieapp.model.getMovies

@Preview
@Composable
fun MovieCard(movie: Movie = getMovies()[0], onItemClick: (String) -> Unit = {}) {
    var expander by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .clickable {
                onItemClick(movie.id)
                Log.d(ContentValues.TAG, "MovieCard: clicked")
            },
        shape = CircleShape.copy(CornerSize(10.dp)),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp // Shadow elevation of the card
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = CircleShape.copy(CornerSize(20.dp)),
                shadowElevation = 3.dp
            ) {
                Image(
                    painter = rememberImagePainter(data = movie.poster),
                    contentDescription = "Image Poster",
                    contentScale = ContentScale.Crop
                )
            }
            Column(modifier = Modifier.padding(10.dp)) {
                Text(text = movie.title, style = MaterialTheme.typography.titleSmall)
                Text(
                    text = "Director: ${movie.director}",
                    style = MaterialTheme.typography.labelSmall
                )
                Text(text = "Released: ${movie.year}", style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(top = 8.dp, bottom = 8.dp))

                if (expander) {
                    Column {
                        Text(
                            text = "Plot: ${movie.plot}",
                            style = MaterialTheme.typography.bodySmall
                        )
                        Text(
                            text = "Rating: ${movie.rating}",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.padding(10.dp))


                Icon(
                    imageVector = if (expander) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Upward Arrow",
                    modifier = Modifier.clickable {
                        expander = !expander
                    }
                )

            }
        }
    }
}