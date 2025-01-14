package com.julietgisemba.moneycounter

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.julietgisemba.moneycounter.ui.theme.MoneyCounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoneyCounterTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    val moneyCounter = remember {
        mutableStateOf(0)
    }
    
    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        color = Color(0xFF546E7A)
    ) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "$ ${moneyCounter.value}", style = TextStyle(color = Color.LightGray, fontWeight = FontWeight.Bold, fontSize = 28.sp))
            Spacer(modifier = Modifier.height(100.dp))
            TapCircle(moneyCounter.value) { newValue ->
                moneyCounter.value = newValue
            }
        }
    }
}


@Composable
fun TapCircle(counter: Int, updateCounter: (Int) -> Unit) {
    Card( modifier = Modifier
        .padding(3.dp)
        .size(105.dp)
        .clickable {
            updateCounter(counter + 1)
            Log.d("Tap", "TapCircle: Tapped")
        },
        shape = CircleShape
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "Tap", modifier = Modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    MoneyCounterTheme {
        MyApp()
    }
}