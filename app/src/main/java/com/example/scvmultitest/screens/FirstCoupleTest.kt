package com.example.scvmultitest.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scvmultitest.Question
import com.example.scvmultitest.getMedia
import com.example.scvmultitest.questions

@Preview
@Composable
fun FirstCoupleTest() {

    LazyColumn() {
        items(questions) { question ->
            QuestionItem(question)
        }
    }

}

@Composable
fun QuestionItem(question: Question) {
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
