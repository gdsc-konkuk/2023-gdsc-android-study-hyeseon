package kr.ac.konkuk.gdsc.hyeseon.data.service

import kr.ac.konkuk.gdsc.hyeseon.data.model.remote.response.ResponseGetRandomImgDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ImgService {
    @GET("photos/random")
    suspend fun getRandomImg(
        @Query("count") count: Int
    ): List<ResponseGetRandomImgDto>

}
