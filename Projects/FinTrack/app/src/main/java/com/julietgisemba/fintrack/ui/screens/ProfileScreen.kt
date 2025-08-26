package com.julietgisemba.fintrack.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = "Profile", fontWeight = FontWeight.Bold
                )
            }, actions = {
                Button(
                    onClick = {}, colors = ButtonDefaults.buttonColors(Color(0xFF2C8A5B))
                ) {
                    Text("Settings")
                }
            })
        }, containerColor = Color(0x54EFFBF6)
    ) { innerPadding ->
        Column(modifier = Modifier.padding(15.dp, 0.dp).padding(innerPadding)) {
            HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
            Spacer(Modifier.height(10.dp))
        }
    }
}