package kr.ac.konkuk.gdsc.hyeseon.presentation.mypage

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import kr.ac.konkuk.gdsc.hyeseon.R
import kr.ac.konkuk.gdsc.hyeseon.databinding.FragmentMyPageBinding
import kr.ac.konkuk.gdsc.hyeseon.presentation.home.HomeViewModel
import kr.ac.konkuk.gdsc.hyeseon.util.binding.BindingFragment

class MyPageFragment : BindingFragment<FragmentMyPageBinding>(R.layout.fragment_my_page) {
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private val viewModel by viewModels<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setNickNameResult()
        navigateToEdit()
        getTodoDoneCount()
    }


    private fun setNickNameResult() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val name = result.data?.getStringExtra(KEY_NICKNAME_FROM_EDIT) ?: ""
                    binding.tvMypageName.text = name
                }
            }
    }

    private fun navigateToEdit() {
        binding.ivMypageEdit.setOnClickListener {
            val intent = Intent(requireContext(), EditActivity::class.java)
            intent.putExtra(KEY_NICKNAME_TO_EDIT, binding.tvMypageName.text.toString())
            resultLauncher.launch(intent)
        }
    }

    private fun getTodoDoneCount() {
        binding.layoutMypageTodo.tvTodoCount.text =
            getString(R.string.mypage_todo_count, viewModel.getToDoDoneCount())
    }

    companion object {
        const val KEY_NICKNAME_TO_EDIT = "nickname"
        const val KEY_NICKNAME_FROM_EDIT = "nickname"
    }
}