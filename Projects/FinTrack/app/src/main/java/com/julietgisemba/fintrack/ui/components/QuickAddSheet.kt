package com.julietgisemba.fintrack.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx. compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.julietgisemba.fintrack.model.QuickAddType
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuickAddSheet(
    type: QuickAddType,
    onDismiss: () -> Unit,
    onSaveTransaction: ((amount: Double, category: String, title: String, note: String?, isIncome: Boolean) -> Unit)? = null,
    onSaveBudget: ((category: String, limit: Double, isRecurring: Boolean) -> Unit)? = null,
    onSaveGoal: ((title: String, target: Double, deadline: Date?) -> Unit)? = null
) {
    var title by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var amountText by remember { mutableStateOf("") }
    var note by remember { mutableStateOf("") }
    var isRecurring by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            when (type) {
                is QuickAddType.Transaction -> "Add Transaction"
                is QuickAddType.Budget -> "Add Budget"
                is QuickAddType.Goal -> "Add Goal"
            },
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        // Shared field for title where needed
        if (type is QuickAddType.Transaction || type is QuickAddType.Goal) {
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Title") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Category input (Transaction + Budget)
        if (type is QuickAddType.Transaction || type is QuickAddType.Budget) {
            OutlinedTextField(
                value = category,
                onValueChange = { category = it },
                label = { Text("Category") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Amount / Target input
        OutlinedTextField(
            value = amountText,
            onValueChange = { amountText = it },
            label = {
                Text(
                    when (type) {
                        is QuickAddType.Transaction -> "Amount"
                        is QuickAddType.Budget -> "Limit"
                        is QuickAddType.Goal -> "Target Amount"
                    }
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        // Note (Transaction only)
        if (type is QuickAddType.Transaction) {
            OutlinedTextField(
                value = note,
                onValueChange = { note = it },
                label = { Text("Note (optional)") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Recurring checkbox (Budget only)
        if (type is QuickAddType.Budget) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = isRecurring, onCheckedChange = { isRecurring = it })
                Text("Recurring Budget")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            when (type) {
                is QuickAddType.Transaction -> {
                    Button(
                        onClick = {
                            val amount = amountText.toDoubleOrNull()
                            if (amount != null) {
                                onSaveTransaction?.invoke(amount, category, title, note.takeIf { it.isNotBlank() }, true)
                            }
                            onDismiss()
                        }
                    ) { Text("Add Income") }

                    Button(
                        onClick = {
                            val amount = amountText.toDoubleOrNull()
                            if (amount != null) {
                                onSaveTransaction?.invoke(amount, category, title, note.takeIf { it.isNotBlank() }, false)
                            }
                            onDismiss()
                        }
                    ) { Text("Add Expense") }
                }

                is QuickAddType.Budget -> {
                    Button(
                        onClick = {
                            val limit = amountText.toDoubleOrNull()
                            if (limit != null) {
                                onSaveBudget?.invoke(category, limit, isRecurring)
                            }
                            onDismiss()
                        }
                    ) { Text("Save Budget") }
                }

                is QuickAddType.Goal -> {
                    Button(
                        onClick = {
                            val target = amountText.toDoubleOrNull()
                            if (target != null) {
                                onSaveGoal?.invoke(title, target, null) // You can later add a DatePicker for deadline
                            }
                            onDismiss()
                        }
                    ) { Text("Save Goal") }
                }
            }
        }

        TextButton(
            onClick = onDismiss,
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Cancel")
        }
    }
}
