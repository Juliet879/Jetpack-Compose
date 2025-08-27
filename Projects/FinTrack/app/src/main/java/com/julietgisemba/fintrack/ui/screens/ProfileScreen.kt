package com.julietgisemba.fintrack.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.julietgisemba.fintrack.model.ProfileOverview
import com.julietgisemba.fintrack.model.UserProfile
import com.julietgisemba.fintrack.ui.components.ProfileItemView
import com.julietgisemba.fintrack.ui.components.TransactionItem
import com.julietgisemba.fintrack.ui.components.UserProfileItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    val user = UserProfile(
        name = "Alex Carter",
        email = "alex.carter@example.com",
        imageUrl =  Icons.Default.Person,
        isProMember = true
    )

    val financeItems = listOf(
        ProfileOverview("Balance", "Total across accounts", "$12,450", Icons.Default.DateRange),
        ProfileOverview("Income", "This month", "$4,200", Icons.Default.ArrowForward),
        ProfileOverview("Expenses", "This month", "$3,150", Icons.Default.ArrowBack)
    )

    val preferenceItems = listOf(
        ProfileOverview("Notifications", "Manage alerts and reminders", icon = Icons.Default.Notifications, moreInfoIcon = Icons.Default.KeyboardArrowRight),
            ProfileOverview("Security", "Password, biometrics", icon = Icons.Default.Lock, moreInfoIcon = Icons.Default.KeyboardArrowRight),
            ProfileOverview("Connected accounts", "Banks and cards", icon = Icons.Default.List, moreInfoIcon = Icons.Default.KeyboardArrowRight),
            ProfileOverview("Appearance", "Theme and display", icon = Icons.Default.Settings, moreInfoIcon = Icons.Default.KeyboardArrowRight),
    )

    val supportItems = listOf(
        ProfileOverview("Help Center", "Guides and FAQs", icon = Icons.Default.ThumbUp, moreInfoIcon = Icons.Default.KeyboardArrowRight),
        ProfileOverview("Contact support", "We usually reply in a day", icon = Icons.Default.Email, moreInfoIcon = Icons.Default.KeyboardArrowRight)
    )

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
        Column(modifier = Modifier.padding(15.dp, 0.dp).padding(innerPadding) .verticalScroll(rememberScrollState())) {
            HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
            Spacer(Modifier.height(10.dp))

            UserProfileItem(user)

            Spacer(Modifier.height(20.dp))

            Text("Financial Overview", fontSize = 20.sp, fontWeight = FontWeight.Medium)
            Spacer(Modifier.height(10.dp))

            Surface(
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(0.3.dp, Color.Gray),
                modifier = Modifier
            ) {
                Column {
                    financeItems.forEach { item ->
                        ProfileItemView(item, true)
                    }
                }
            }

            Spacer(Modifier.height(20.dp))

            Text("Preferences", fontSize = 20.sp, fontWeight = FontWeight.Medium)
            Spacer(Modifier.height(10.dp))

            Surface(
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(0.3.dp, Color.Gray),
                modifier = Modifier
            ) {
                Column {
                    preferenceItems.forEach { item ->
                        ProfileItemView(item, false)
                    }
                }
            }

            Spacer(Modifier.height(20.dp))

            Text("Support", fontSize = 20.sp, fontWeight = FontWeight.Medium)
            Spacer(Modifier.height(10.dp))

            Surface(
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(0.3.dp, Color.Gray),
                modifier = Modifier
            ) {
                Column {
                    supportItems.forEach { item ->
                        ProfileItemView(item, false)
                    }
                }
            }
        }
    }
}