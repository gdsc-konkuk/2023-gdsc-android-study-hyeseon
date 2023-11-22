package kr.ac.konkuk.gdsc.hyeseon.data.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import kr.ac.konkuk.gdsc.hyeseon.domain.entity.TodoEntity

@Dao
interface TodoDao {

    @Query("SELECT * FROM todoentity")
    fun getAll(): Flow<List<TodoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(todoEntity: TodoEntity)

    @Delete
    suspend fun delete(todoEntity: TodoEntity)

    @Update
    suspend fun update(todoEntity: TodoEntity)
}