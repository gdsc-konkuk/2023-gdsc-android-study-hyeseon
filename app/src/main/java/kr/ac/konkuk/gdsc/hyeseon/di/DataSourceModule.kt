package kr.ac.konkuk.gdsc.hyeseon.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.ac.konkuk.gdsc.hyeseon.data.model.TodoDao
import kr.ac.konkuk.gdsc.hyeseon.data.source.TodoDataSource
import kr.ac.konkuk.gdsc.hyeseon.data.source.TodoDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun provideTodoDataSource(todoDao: TodoDao): TodoDataSource {
        return TodoDataSourceImpl(todoDao)
    }
}
