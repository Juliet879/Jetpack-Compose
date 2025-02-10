package com.julietgisemba.smartsaving.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.julietgisemba.smartsaving.model.SavingTransaction

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SaveApp(
    savingsList: List<SavingTransaction>,
    updateStartAmount: (Double) -> Unit,
    onAddSavings: (SavingTransaction) -> Unit
) {

    var startingAmount by remember {
        mutableStateOf("50")
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "52 Weeks Saving Challenge",
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp),
            modifier = Modifier.padding(50.dp)
        )
        OutlinedTextField(
            value = startingAmount,
            onValueChange = {
                startingAmount = it
//                updateStartAmount(it.toDouble())
            },
            label = { Text(text = "Enter amount..") },
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            singleLine = true
        )

        Button(onClick = {
            updateStartAmount(startingAmount.toDouble())
            val savingsListToSave = savingsList.map { savings ->
                savings.copy(week = savings.week, amount = savings.amount)
            }
            savingsListToSave.forEach {
                onAddSavings(it)
            }
            startingAmount = ""
        }) {
            Text("Save")
        }


        Divider(Modifier.padding(20.dp))

        LazyColumn {
            items(savingsList) { saving ->
                Surface(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp)),
                    shape = RectangleShape,
                    shadowElevation = 10.dp
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.DarkGray,
                                    fontWeight = FontWeight.Light
                                )
                            ) {
                                append("Week ${saving.week} -> ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Magenta,
                                    fontWeight = FontWeight.Medium
                                )
                            ) {
                                append("${saving.amount}")
                            }
                        },
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
        }
    }
}