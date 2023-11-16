package kr.ac.konkuk.gdsc.hyeseon.data.repository

import kr.ac.konkuk.gdsc.hyeseon.data.model.remote.response.ResponseGetRandomImgDto
import kr.ac.konkuk.gdsc.hyeseon.data.source.ImgDataSource
import kr.ac.konkuk.gdsc.hyeseon.domain.entity.Img
import kr.ac.konkuk.gdsc.hyeseon.domain.repository.ImgRepository
import javax.inject.Inject

class ImgRepositoryImpl @Inject constructor(
    private val imgDataSource: ImgDataSource
): ImgRepository {
    override suspend fun getRandomImg(
        count: Int
    ): Result<Img> =
        runCatching {
            imgDataSource.getRandomImg(count)[0].toImg()
        }
}