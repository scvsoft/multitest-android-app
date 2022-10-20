package com.example.scvmultitest

data class Question(
    val id: Int,
    val text: String
)

val questions = buildList {
    (1..5).forEach{questionId ->
    add(
        Question(
            id = questionId,
            text = "Question $questionId"
        )
    )
    }
}

