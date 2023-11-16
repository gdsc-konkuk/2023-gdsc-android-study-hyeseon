package kr.ac.konkuk.gdsc.hyeseon.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kr.ac.konkuk.gdsc.hyeseon.domain.entity.TodoItem
import kr.ac.konkuk.gdsc.hyeseon.domain.repository.TodoRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val todoRepository: TodoRepository
): ViewModel() {
    private val _todoList = MutableStateFlow<List<TodoItem>>(emptyList())
    val todoList: StateFlow<List<TodoItem>> = _todoList

    init {
        viewModelScope.launch {
            _todoList.value = todoRepository.getAllTodos().first().map { it }
        }
    }

    fun updateDoneBtn(item: TodoItem) {
        viewModelScope.launch {
            val updatedItem = item.copy(isDone = !item.isDone)
            todoRepository.updateTodo(updatedItem)
            val updatedList = _todoList.value.map { todoItem ->
                if (todoItem.id == item.id) {
                    updatedItem
                } else {
                    todoItem
                }
            }
            _todoList.value = updatedList
        }
    }


    fun getToDoDoneCount(): Int {
        return _todoList.value.count { it.isDone }
    }
}