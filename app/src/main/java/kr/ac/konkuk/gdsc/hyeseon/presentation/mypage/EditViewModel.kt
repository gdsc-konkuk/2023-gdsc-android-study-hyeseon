package kr.ac.konkuk.gdsc.hyeseon.presentation.mypage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kr.ac.konkuk.gdsc.hyeseon.util.code.ErrorCode
import kr.ac.konkuk.gdsc.hyeseon.util.view.InputUiState

class EditViewModel : ViewModel() {

    val _editableNickName = MutableStateFlow("")
    val editableNickName: String get() = _editableNickName.value
    val isEdited = MutableStateFlow(false)
    val isValidNickName = _editableNickName.map { value ->
        if (value.isBlank() && isEdited.value) {
            InputUiState.Failure(ErrorCode.CODE_BLANK_INPUT)
        } else {
            InputUiState.Success
        }
    }


    val inputUiState: StateFlow<Boolean> = isValidNickName.map { validateNickname(it) }
        .stateIn(
            initialValue = false,
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(PRODUCE_STOP_TIMEOUT)
        )

    private fun validateNickname(state: InputUiState) = state == InputUiState.Success


    companion object {
        private const val PRODUCE_STOP_TIMEOUT = 5000L

    }
}


