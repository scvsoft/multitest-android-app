package com.example.scvmultitest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.scvmultitest.screens.HomeScreen
import com.example.scvmultitest.screens.SplashScreen
import com.example.scvmultitest.screens.PreviewUserDataScreen

@Composable
fun AppNavigation(){
  val navController = rememberNavController()
  NavHost(
    navController = navController,
    startDestination = AppScreens.SplashScreen.route
  ){
    composable(route = AppScreens.SplashScreen.route){
      SplashScreen(navController)
    }
    composable(route = AppScreens.HomeScreen.route){
      HomeScreen(navController)
    }
    composable(route = AppScreens.PreviewUserDataScreen.route){
      PreviewUserDataScreen(navController)
    }
  }

}