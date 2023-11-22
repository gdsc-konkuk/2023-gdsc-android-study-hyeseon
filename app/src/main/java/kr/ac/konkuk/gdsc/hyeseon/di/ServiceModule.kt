package kr.ac.konkuk.gdsc.hyeseon.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.ac.konkuk.gdsc.hyeseon.data.service.ImgService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun provideImgService(retrofit: Retrofit): ImgService =
        retrofit.create(ImgService::class.java)
}



