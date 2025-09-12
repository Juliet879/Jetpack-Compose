package com.julietgisemba.fintrack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.julietgisemba.fintrack.navigation.AppNavHost
import com.julietgisemba.fintrack.navigation.Destinations
import com.julietgisemba.fintrack.ui.components.BottomBar
import com.julietgisemba.fintrack.ui.theme.FinTrackTheme
import com.julietgisemba.fintrack.viewmodel.FinanceViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val items = listOf(
                Destinations.Dashboard,
                Destinations.Transactions,
                Destinations.Budgets,
                Destinations.Goals,
                Destinations.Profile
            )

            Scaffold(
                bottomBar = {
                    BottomBar(navController = navController, destinations = items)
                }
            ) { innerPadding ->
//                if (quickAddController.quickAddData != null) {
//                    ModalBottomSheet(
//                        sheetState = sheetState,
//                        onDismissRequest = { quickAddController.quickAddData = null }
//                    ) {
//
//                    }
//                }
                AppNavHost(
                    navController = navController,
                    modifier = Modifier.padding(innerPadding),
                    hiltViewModel()
                )
            }
        }
    }
}
