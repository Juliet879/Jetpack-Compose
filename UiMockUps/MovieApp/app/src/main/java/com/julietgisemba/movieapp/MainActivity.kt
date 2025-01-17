package com.julietgisemba.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.julietgisemba.movieapp.navigation.MovieNavigation
import com.julietgisemba.movieapp.navigation.home.MainContent
import com.julietgisemba.movieapp.ui.theme.MovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {}
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    MovieAppTheme {
        MovieNavigation()
    }
}


@Preview(showBackground = true)
@Composable
fun MoviePreview() {
    MovieAppTheme {
        MyApp {

        }
    }
}
