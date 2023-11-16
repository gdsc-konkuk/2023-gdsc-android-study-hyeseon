package kr.ac.konkuk.gdsc.hyeseon.presentation.mypage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kr.ac.konkuk.gdsc.hyeseon.domain.entity.Img
import kr.ac.konkuk.gdsc.hyeseon.domain.repository.ImgRepository
import kr.ac.konkuk.gdsc.hyeseon.util.view.UiState
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val imgRepository: ImgRepository
) : ViewModel() {
    private val _getRandomImgState =
        MutableStateFlow<UiState<Img>>(UiState.Loading)
    val getRandomImgState: StateFlow<UiState<Img>> =
        _getRandomImgState.asStateFlow()

    init {
        getRandomImg()
    }

    fun getRandomImg() {
        viewModelScope.launch {
            imgRepository.getRandomImg(NUN_IMG_COUNT)
                .onSuccess { response ->
                    _getRandomImgState.value = UiState.Success(response)
                }
                .onFailure { t ->
                    _getRandomImgState.value = UiState.Failure(MSG_FAILURE)
                }
        }
    }

    companion object {
        const val NUN_IMG_COUNT = 1
        const val MSG_FAILURE = "네트워크 연결을 확인해주세요"
    }
}