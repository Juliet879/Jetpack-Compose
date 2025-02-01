package com.julietgisemba.smartsaving

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.julietgisemba.smartsaving.screens.SaveApp
import com.julietgisemba.smartsaving.screens.SavingViewModel
import com.julietgisemba.smartsaving.ui.theme.SmartSavingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartSavingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel: SavingViewModel by viewModels()

                    val savingList = viewModel.totalSavings.collectAsState().value

                    SaveApp(
                        savingsList = savingList,
                        updateStartAmount = { viewModel.updateStartAmount(it) },
                        onAddSavings = { viewModel.addSavings(it) }
                    )
                }
            }
        }
    }
}