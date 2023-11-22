package kr.ac.konkuk.gdsc.hyeseon.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kr.ac.konkuk.gdsc.hyeseon.data.AppDatabase
import kr.ac.konkuk.gdsc.hyeseon.data.model.TodoDao
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DBModule {
    @Singleton
    @Provides
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): AppDatabase = Room
        .databaseBuilder(context, AppDatabase::class.java, "database")
        .build()

    @Singleton
    @Provides
    fun provideTodoDao(appDatabase: AppDatabase): TodoDao = appDatabase.todoDao()
}