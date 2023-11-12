package kr.ac.konkuk.gdsc.hyeseon.data.model

data class TodoItem(
    val id: Int,
    val body: String,
    val isDone: Boolean,
    val date : String
)