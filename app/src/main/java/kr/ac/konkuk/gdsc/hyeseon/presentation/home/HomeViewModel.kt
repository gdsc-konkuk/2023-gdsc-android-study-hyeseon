package kr.ac.konkuk.gdsc.hyeseon.presentation.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kr.ac.konkuk.gdsc.hyeseon.domain.entity.TodoItem
import kr.ac.konkuk.gdsc.hyeseon.domain.entity.TodoItem.Companion.DummyList
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel() {
    private val _todoList = MutableStateFlow(DummyList)
    val todoList: StateFlow<List<TodoItem>> = _todoList

    fun updateDoneBtn(item: TodoItem) {
        val updatedList = _todoList.value.map { todoItem ->
            if (todoItem.id == item.id) {
                todoItem.copy(isDone = !todoItem.isDone)
            } else {
                todoItem
            }
        }
        _todoList.value = updatedList
    }

    fun getToDoDoneCount(): Int {
        return _todoList.value.count { it.isDone }
    }
}