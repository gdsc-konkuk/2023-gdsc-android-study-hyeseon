package kr.ac.konkuk.gdsc.hyeseon.presentation.mypage

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch
import kr.ac.konkuk.gdsc.hyeseon.R
import kr.ac.konkuk.gdsc.hyeseon.databinding.ActivityEditBinding
import kr.ac.konkuk.gdsc.hyeseon.util.activity.toast
import kr.ac.konkuk.gdsc.hyeseon.util.binding.BindingActivity
import kr.ac.konkuk.gdsc.hyeseon.util.context.hideKeyboard
import kr.ac.konkuk.gdsc.hyeseon.util.view.InputUiState

class EditActivity : BindingActivity<ActivityEditBinding>(R.layout.activity_edit) {
    private val viewModel by viewModels<EditViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        initSaveBtnClickListener()
        checkIsNickNameValid()
        initEditTextWatcher()
        initRootLayoutClickListener()
    }

    private fun initEditTextWatcher() {
        binding.etEditNickname.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.isEdited.value = true
            }
        })
    }

    private fun checkIsNickNameValid() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.isValidNickName.collect { value ->
                    if (value is InputUiState.Failure) {
                        toast(MSG_NICKNAME_ISBLANK)
                    }
                }
            }
        }
    }

    private fun initSaveBtnClickListener() {
        binding.btnEditSave.setOnClickListener {
            setResult()
        }
    }

    private fun setResult() {
        val intent = Intent()
        intent.putExtra("name", viewModel.editableNickName)
        setResult(RESULT_OK, intent)
        if (!isFinishing) finish()
    }


    private fun initRootLayoutClickListener() {
        binding.root.setOnClickListener {
            hideKeyboard(binding.root)
            binding.etEditNickname.clearFocus()
        }
    }

    companion object {
        const val MSG_NICKNAME_ISBLANK = "닉네임은 공백일 수 없습니다"
    }
}