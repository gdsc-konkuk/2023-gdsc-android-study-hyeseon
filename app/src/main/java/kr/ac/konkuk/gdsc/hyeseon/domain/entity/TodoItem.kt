package kr.ac.konkuk.gdsc.hyeseon.domain.entity

data class TodoItem(
    val id : Int,
    val body: String,
    val isDone: Boolean,
) {
    companion object {
        val DummyList = listOf(
            TodoItem(1, "안드로이드 스터디 과제하기", false),
            TodoItem(2, "졸프 설계서 작성하기", true),
            TodoItem(3, "친구 생일선물 사기", true),
            TodoItem(4, "슬랙 확인하기", false),
            TodoItem(5, "23시 회의", true),
            TodoItem(6, "안드로이드 스터디 자료만들기", true)
        )
    }
}