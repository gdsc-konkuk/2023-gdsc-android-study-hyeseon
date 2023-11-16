package kr.ac.konkuk.gdsc.hyeseon.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.ac.konkuk.gdsc.hyeseon.data.repository.ImgRepositoryImpl
import kr.ac.konkuk.gdsc.hyeseon.domain.repository.ImgRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindsImgRepository(
        imgRepositoryImpl: ImgRepositoryImpl
    ): ImgRepository
}