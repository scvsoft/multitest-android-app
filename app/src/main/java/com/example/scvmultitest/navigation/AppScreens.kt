package com.example.scvmultitest.navigation

sealed class AppScreens(val route: String){
  object SplashScreen: AppScreens("splash_screen")
  object HomeScreen: AppScreens("home_screen")
  object PreviewUserDataScreen: AppScreens("preview_user_data_screen")
}