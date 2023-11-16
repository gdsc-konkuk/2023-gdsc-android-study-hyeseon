package kr.ac.konkuk.gdsc.hyeseon.presentation.mypage

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kr.ac.konkuk.gdsc.hyeseon.R
import kr.ac.konkuk.gdsc.hyeseon.databinding.ActivityEditBinding
import kr.ac.konkuk.gdsc.hyeseon.util.activity.toast
import kr.ac.konkuk.gdsc.hyeseon.util.binding.BindingActivity
import kr.ac.konkuk.gdsc.hyeseon.util.context.hideKeyboard
import kr.ac.konkuk.gdsc.hyeseon.util.view.InputUiState
@AndroidEntryPoint
class EditActivity : BindingActivity<ActivityEditBinding>(R.layout.activity_edit) {
    private val viewModel by viewModels<EditViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        initSaveBtnClickListener()
        initEditTextWatcher()
        initEditTextFocusListener()
        initRootLayoutClickListener()
        updateNickNameFromResult()
        checkIsNickNameValid()
    }

    private fun updateNickNameFromResult() {
        val nickname = intent.getStringExtra(KEY_NICKNAME_FROM_MYPAGE).toString()
        viewModel._editableNickName.value = nickname
        binding.tvEditName.text = nickname
    }

    private fun initEditTextFocusListener() {
        binding.etEditNickname.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                binding.etEditNickname.setText("")
            }
        }
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
            setResultToMyPage()
        }
    }

    private fun setResultToMyPage() {
        val intent = Intent()
        intent.putExtra(KEY_NICKNAME_TO_MYPAGE, viewModel.editableNickName)
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
        const val KEY_NICKNAME_TO_MYPAGE = "nickname"
        const val KEY_NICKNAME_FROM_MYPAGE = "nickname"
    }
}