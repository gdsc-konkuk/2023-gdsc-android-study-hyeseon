package kr.ac.konkuk.gdsc.hyeseon.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class TodoEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "body") val body: String = "",
    @ColumnInfo(name = "is_done") val isDone: Boolean = false,
)
