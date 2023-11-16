package kr.ac.konkuk.gdsc.hyeseon.data.source

import kotlinx.coroutines.flow.Flow
import kr.ac.konkuk.gdsc.hyeseon.domain.entity.TodoEntity

interface TodoDataSource {
    fun getAllTodos(): Flow<List<TodoEntity>>
    suspend fun insertTodo(todoEntity: TodoEntity)
    suspend fun deleteTodo(todoEntity: TodoEntity)
    suspend fun updateTodo(todoEntity: TodoEntity)
}
