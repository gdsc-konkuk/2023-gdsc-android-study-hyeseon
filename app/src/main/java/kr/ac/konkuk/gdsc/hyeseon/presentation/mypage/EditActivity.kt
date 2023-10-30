package kr.ac.konkuk.gdsc.hyeseon.presentation.mypage

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch
import kr.ac.konkuk.gdsc.hyeseon.R
import kr.ac.konkuk.gdsc.hyeseon.databinding.ActivityEditBinding
import kr.ac.konkuk.gdsc.hyeseon.util.binding.BindingActivity
import kr.ac.konkuk.gdsc.hyeseon.util.context.hideKeyboard
import kr.ac.konkuk.gdsc.hyeseon.util.view.InputUiState

class EditActivity : BindingActivity<ActivityEditBinding>(R.layout.activity_edit) {
    private val viewModel by viewModels<EditViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        initSaveBtnClickListener()

    }

    private fun initSaveBtnClickListener() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.isValidNickName.collect { inputUiState ->
                    if (inputUiState is InputUiState.Failure) {
                        showToast(MSG_NICKNAME_ISBLANK)
                    }
                }
            }
        }
    }


    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }


    companion object {
        const val MSG_NICKNAME_ISBLANK = "닉네임은 공백일 수 없습니다"
    }
}