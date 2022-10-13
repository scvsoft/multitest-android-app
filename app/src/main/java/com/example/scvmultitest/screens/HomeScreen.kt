package com.example.scvmultitest.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.scvmultitest.navigation.AppScreens
import com.example.scvmultitest.ui.theme.Purple200


@Composable
fun HomeScreen(navController: NavHostController) {
  ShowHomeScreen(navController)
}

@Composable
fun ShowHomeScreen(navController: NavHostController) {
  Column(
    modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
      scaffoldState = scaffoldState,
      topBar = {
        TopAppBar(
          title = {Text("Select category test")},
          backgroundColor = Purple200)
      },
      content = {
        Column(
          modifier = Modifier.fillMaxSize(),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center
        ){
          Text(text = "Space for category cards")
          Button(onClick = {
            navController.navigate(AppScreens.PreviewUserDataScreen.route)
          }) {
            Text(text = "Go to Preview Test Page")
          }
        }
      },
    )
  }
}