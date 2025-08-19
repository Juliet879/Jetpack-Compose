package com.julietgisemba.mkoba.navigation

enum class AppScreen {
    SplashScreen,
    Login;

    companion object {
        fun fromRoute(route: String?) =
            when(route?.substringBefore("/")) {
                SplashScreen.name -> SplashScreen
                Login.name -> Login
                else -> IllegalArgumentException("Route $route is not recognized")
            }
    }
}