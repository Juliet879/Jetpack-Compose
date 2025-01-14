package com.julietgisemba.bizcardapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp1.ui.theme.ComposeApp1Theme
import com.julietgisemba.bizcardapp.ui.theme.BizCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BizCardAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {
    val buttonClickedState = remember {
        mutableStateOf(false)
    }

    Surface(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()) {
        Card(modifier = Modifier
            .height(400.dp)
            .width(200.dp)
            .padding(10.dp),
            colors = CardDefaults.cardColors(androidx.compose.ui.graphics.Color.White),
            elevation = CardDefaults.cardElevation(20.dp)) {

            Column(modifier = Modifier.height(850.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally) {
                CreateImageProfile()
                Divider(thickness = 0.5.dp)
                CreateCardInfo()
                Button(onClick = {
                    buttonClickedState.value = !buttonClickedState.value
                },
                    modifier = Modifier
                        .width(150.dp)
                        .padding(20.dp)) {
                    Text(text = "Portfolio",
                        style = MaterialTheme.typography.titleSmall)
                }
                if (buttonClickedState.value) {
                    Content()
                } else {
                    Box {
                    }
                }
            }
        }
    }
}

@Composable
private fun CreateImageProfile() {
    Box() {
        Surface(
            modifier = Modifier
                .size(150.dp)
                .padding(5.dp),
            shape = CircleShape
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_image),
                contentDescription = "profile image"
            )
        }
    }
}

@Composable
fun CreateCardInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(text = "Juliet K.G",
            color = Color.Magenta,
            fontFamily = FontFamily.SansSerif,
            fontSize = 21.sp,
            style = MaterialTheme.typography.headlineMedium
        )
        Text(text = "Android Compose Programmer",
            modifier = Modifier.padding(3.dp))
        Text(text = "@gisembajk",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.bodySmall)
    }
}

@Preview
@Composable
fun Content() {
    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(5.dp)) {
        Surface(modifier = Modifier
            .align(alignment = Alignment.Center)
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(2.dp),
            shape = RoundedCornerShape(5.dp),
            border = BorderStroke(1.dp, color = Color.LightGray),
            color = Color.White,
        ) {
            Portfolio(data = listOf("Project 1", "Project 2", "Project 3", "Project 4", "Project 5", "Project 6", "Project 7"))
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn {
        items(data) { item ->
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(13.dp)
                .background(color = Color.White),
                shape = RectangleShape,
                elevation = CardDefaults.cardElevation(3.dp)
            ) {
                Row(modifier = Modifier.padding(5.dp)) {
                    Surface(
                        modifier = Modifier
                            .size(130.dp),
                        shape = CircleShape
                    ) {
                        Image(painter = painterResource(id = R.drawable.avator),
                            contentDescription = "profile image")
                    }
                    Column(modifier = Modifier
                        .padding(4.dp)
                        .align(alignment = Alignment.CenterVertically)) {
                        Text(text = item, fontWeight = FontWeight.Bold)
                        Text(text = "Awesome Project Indeed")
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun BizCardPreview() {
    BizCardAppTheme {
        CreateBizCard()
    }
}