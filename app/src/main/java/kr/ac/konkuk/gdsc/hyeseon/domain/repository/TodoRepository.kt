package kr.ac.konkuk.gdsc.hyeseon.domain.repository

import kotlinx.coroutines.flow.Flow
import kr.ac.konkuk.gdsc.hyeseon.domain.entity.TodoItem

interface TodoRepository {
    fun getAllTodos(): Flow<List<TodoItem>>
    suspend fun insertTodo(todoItem: TodoItem)
    suspend fun deleteTodo(todoItem: TodoItem)
    suspend fun updateTodo(todoItem: TodoItem)
}
