package com.julietgisemba.fintrack.model

sealed class QuickAddType {
    object Transaction : QuickAddType()
    object Budget : QuickAddType()
    object Goal : QuickAddType()
}