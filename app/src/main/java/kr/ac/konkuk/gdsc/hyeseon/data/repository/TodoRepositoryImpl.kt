package kr.ac.konkuk.gdsc.hyeseon.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kr.ac.konkuk.gdsc.hyeseon.data.model.TodoDao
import kr.ac.konkuk.gdsc.hyeseon.domain.entity.TodoEntity
import kr.ac.konkuk.gdsc.hyeseon.domain.entity.TodoItem
import kr.ac.konkuk.gdsc.hyeseon.domain.repository.TodoRepository
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(
    private val todoDao: TodoDao
) : TodoRepository {
    override fun getAllTodos(): Flow<List<TodoItem>> = todoDao.getAll().map { list ->
        list.map { it.mapToItem() }
    }

    override suspend fun insertTodo(todoItem: TodoItem) = todoDao.insert(todoItem.mapToEntity())

    override suspend fun deleteTodo(todoItem: TodoItem) = todoDao.delete(todoItem.mapToEntity())

    override suspend fun updateTodo(todoItem: TodoItem) = todoDao.update(todoItem.mapToEntity())

    private fun TodoEntity.mapToItem(): TodoItem {
        return TodoItem(id = id, body = body, isDone = isDone)
    }

    private fun TodoItem.mapToEntity(): TodoEntity {
        return TodoEntity(id = id, body = body, isDone = isDone)
    }
}
