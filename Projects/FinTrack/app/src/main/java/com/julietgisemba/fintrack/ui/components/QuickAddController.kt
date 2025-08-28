package com.julietgisemba.fintrack.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.julietgisemba.fintrack.model.QuickAddData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class QuickAddController {
    var quickAddData by mutableStateOf<QuickAddData?>(null)
    @OptIn(ExperimentalMaterial3Api::class)
    lateinit var sheetState: SheetState

    @OptIn(ExperimentalMaterial3Api::class)
    fun showQuickAdd(data: QuickAddData, scope: CoroutineScope) {
        quickAddData = data
        scope.launch { sheetState.show() }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    fun hideQuickAdd(scope: CoroutineScope) {
        scope.launch {
            sheetState.hide()
            quickAddData = null
        }
    }
}
