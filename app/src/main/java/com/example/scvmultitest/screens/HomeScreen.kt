package com.example.scvmultitest.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.scvmultitest.navigation.AppScreens
import kotlinx.coroutines.delay

@Composable
fun HomeScreen(navController: NavHostController) {
  LaunchedEffect(key1 = true){
    delay(2000)
    navController.popBackStack()
    navController.navigate(AppScreens.TestSelectionScreen.route)
  }
  Home()
}

@Composable
fun Home() {
  Column(
    modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    Text(text = "Soy un text principal")
  }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
  Home()
}