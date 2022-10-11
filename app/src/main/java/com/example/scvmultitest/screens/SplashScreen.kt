package com.example.scvmultitest.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.scvmultitest.R
import com.example.scvmultitest.navigation.AppScreens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
  LaunchedEffect(key1 = true){
    delay(2000)
    navController.popBackStack()
    navController.navigate(AppScreens.HomeScreen.route)
  }
  Splash()
}

@Composable
fun Splash(){
  Column(
    modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    Image(painter= painterResource(
      id = R.drawable.scvsoft),
      contentDescription = "Logo SCVSoft",
      Modifier.size(150.dp, 150.dp)
    )
    Text(
      text = "Multitest",
      fontSize = 30.sp,
      fontWeight = FontWeight.Bold
    )
  }
}


@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){
  Splash()
}