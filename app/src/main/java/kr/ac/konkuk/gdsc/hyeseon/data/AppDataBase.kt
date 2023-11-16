package kr.ac.konkuk.gdsc.hyeseon.data

import androidx.room.Database
import androidx.room.RoomDatabase
import kr.ac.konkuk.gdsc.hyeseon.data.model.TodoDao
import kr.ac.konkuk.gdsc.hyeseon.domain.entity.TodoEntity

@Database(entities = [TodoEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}