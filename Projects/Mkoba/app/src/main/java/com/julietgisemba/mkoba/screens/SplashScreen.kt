package com.julietgisemba.mkoba.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.julietgisemba.mkoba.R
import com.julietgisemba.mkoba.navigation.AppScreen
import kotlinx.coroutines.delay

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashScreen(navController: NavHostController) {
    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate(AppScreen.Login.name)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(id = R.drawable.wallet), contentDescription = "wallet icon",
            modifier = Modifier.size(150.dp))
    }
}