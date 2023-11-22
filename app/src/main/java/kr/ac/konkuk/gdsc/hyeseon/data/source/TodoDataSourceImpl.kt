package kr.ac.konkuk.gdsc.hyeseon.data.source

import kotlinx.coroutines.flow.Flow
import kr.ac.konkuk.gdsc.hyeseon.data.model.TodoDao
import kr.ac.konkuk.gdsc.hyeseon.domain.entity.TodoEntity
import javax.inject.Inject

class TodoDataSourceImpl @Inject constructor(
    private val todoDao: TodoDao
) : TodoDataSource {
    override fun getAllTodos(): Flow<List<TodoEntity>> {
        return todoDao.getAll()
    }

    override suspend fun insertTodo(todoEntity: TodoEntity) {
        todoDao.insert(todoEntity)
    }

    override suspend fun deleteTodo(todoEntity: TodoEntity) {
        todoDao.delete(todoEntity)
    }

    override suspend fun updateTodo(todoEntity: TodoEntity) {
        todoDao.update(todoEntity)
    }
}
