package kr.ac.konkuk.gdsc.hyeseon.data.source

import kr.ac.konkuk.gdsc.hyeseon.data.model.remote.response.ResponseGetRandomImgDto
import kr.ac.konkuk.gdsc.hyeseon.data.service.ImgService
import javax.inject.Inject

class ImgDataSource @Inject constructor(
    private val imgService: ImgService
){
    suspend fun getRandomImg(
        count: Int
    ): List<ResponseGetRandomImgDto> =
        imgService.getRandomImg(count)
}