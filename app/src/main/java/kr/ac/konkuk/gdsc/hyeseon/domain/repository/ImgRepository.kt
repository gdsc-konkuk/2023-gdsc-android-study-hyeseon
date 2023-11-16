package kr.ac.konkuk.gdsc.hyeseon.domain.repository

import kr.ac.konkuk.gdsc.hyeseon.data.model.remote.response.ResponseGetRandomImgDto
import kr.ac.konkuk.gdsc.hyeseon.domain.entity.Img

interface ImgRepository {
    suspend fun getRandomImg(
        count: Int
    ): Result<Img>
}