package com.julietgisemba.fintrack.model

import androidx.compose.ui.graphics.vector.ImageVector

data class ProfileOverview(
    val title: String,
    val subtitle: String,
    val amount: String? = null,
    val icon: ImageVector,
    val moreInfoIcon: ImageVector? = null,
)