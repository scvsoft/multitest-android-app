package com.example.scvmultitest.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.scvmultitest.Question
import com.example.scvmultitest.navigation.AppScreens
import com.example.scvmultitest.questions


@Composable
fun FirstCoupleTest(navController: NavHostController) {
    Column() {
        LazyColumn() {
            items(questions) { question ->
                QuestionItem(question, navController = navController )
            }
        }
    }
    Box() {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Button(onClick = {
                navController.navigate(AppScreens.HomeScreen.route)
            }) {
                Text(text = "Go to category test screen")
            }
        }
    }




}

@Composable
fun QuestionItem(question: Question, navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
        )
        {
            Text(text = " Question ${question.id}")
        }
    }
}
