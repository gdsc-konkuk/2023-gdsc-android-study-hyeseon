package kr.ac.konkuk.gdsc.hyeseon.util.view

import kr.ac.konkuk.gdsc.hyeseon.util.code.ErrorCode

sealed class InputUiState {
    object Empty : InputUiState()
    object Success : InputUiState()
    data class Failure(val code: ErrorCode) : InputUiState()
}