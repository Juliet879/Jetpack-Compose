package com.julietgisemba.fintrack.model

import androidx.compose.ui.graphics.vector.ImageVector

data class UserProfile(
    val name: String,
    val email: String,
    val imageUrl: ImageVector,
    val isProMember: Boolean
)
