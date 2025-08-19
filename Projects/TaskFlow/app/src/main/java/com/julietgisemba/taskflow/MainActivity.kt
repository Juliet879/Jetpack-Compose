package com.julietgisemba.taskflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.julietgisemba.taskflow.data.model.Task
import com.julietgisemba.taskflow.ui.theme.TaskFlowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskFlowTheme {
                var task by remember { mutableStateOf("") }
                var tasks by remember { mutableStateOf(listOf<Task>()) }

                Scaffold(
                    floatingActionButton = {
                        FloatingActionButton(onClick = { /* TODO: Add action */ }) {
                            Icon(imageVector = Icons.Default.Add, contentDescription = "Add Task")
                        }
                    }
                ) { paddingValues ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                            .safeDrawingPadding(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "TaskFlow",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(30.dp)
                        )

                        Row(
                            modifier = Modifier.padding(10.dp)
                        ) {
                            OutlinedTextField(
                                value = task,
                                onValueChange = { text -> task = text },
                                modifier = Modifier.weight(1f)
                            )
                            Spacer(Modifier.width(10.dp))
                            Button(onClick = {
                                if (task.isNotBlank()) {
                                    tasks = tasks + Task(task)
                                    task = ""
                                }
                            }) {
                                Icon(
                                    imageVector = Icons.Default.AddCircle,
                                    contentDescription = "Add Task"
                                )
                            }
                        }

                        LazyColumn {
                            items(tasks) { taskItem ->
                                // animate scale per-task
                                val scale by animateFloatAsState(
                                    targetValue = if (taskItem.isCompleted) 1.2f else 1f,
                                    animationSpec = tween(durationMillis = 300),
                                    label = "checkboxScale"
                                )

                                Row(
                                    modifier = Modifier
                                        .background(Color.White)
                                        .fillMaxWidth()
                                        .padding(10.dp)
                                        .shadow(0.5.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Checkbox(
                                        checked = taskItem.isCompleted,
                                        onCheckedChange = { checked ->
                                            tasks = tasks.map {
                                                if (it == taskItem) it.copy(isCompleted = checked)
                                                else it
                                            }
                                        },
                                        modifier = Modifier.scale(scale)
                                    )
                                    Text(
                                        taskItem.name,
                                        modifier = Modifier
                                            .padding(start = 15.dp)
                                            .clip(CircleShape)
                                            .fillMaxWidth(),
                                        fontSize = 18.sp
                                    )
                                }
                                Divider()
                            }
                        }
                    }
                }
            }
        }
    }
}
