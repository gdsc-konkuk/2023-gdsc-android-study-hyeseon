package kr.ac.konkuk.gdsc.hyeseon.presentation.mypage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kr.ac.konkuk.gdsc.hyeseon.util.code.ErrorCode
import kr.ac.konkuk.gdsc.hyeseon.util.view.InputUiState

class EditViewModel : ViewModel() {

    val _editableNickName = MutableStateFlow("")
    val editableNickName: String get() = _editableNickName.value
    val isValidNickName = MutableSharedFlow<InputUiState>()

    fun checkValidInput() {
        if (_editableNickName.value.isBlank()) {
            viewModelScope.launch {
                isValidNickName.emit(InputUiState.Failure(ErrorCode.CODE_BLANK_INPUT))
            }
        } else {
            viewModelScope.launch {
                isValidNickName.emit(InputUiState.Success)
            }
        }
    }
}
