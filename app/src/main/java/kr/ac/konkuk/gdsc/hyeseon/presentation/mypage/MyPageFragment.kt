package kr.ac.konkuk.gdsc.hyeseon.presentation.mypage

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kr.ac.konkuk.gdsc.hyeseon.R
import kr.ac.konkuk.gdsc.hyeseon.databinding.FragmentMyPageBinding
import kr.ac.konkuk.gdsc.hyeseon.presentation.home.HomeViewModel
import kr.ac.konkuk.gdsc.hyeseon.util.binding.BindingFragment
import kr.ac.konkuk.gdsc.hyeseon.util.view.UiState

@AndroidEntryPoint
class MyPageFragment : BindingFragment<FragmentMyPageBinding>(R.layout.fragment_my_page) {
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private val homeViewModel by viewModels<HomeViewModel>()
    private val myPageViewModel by viewModels<MyPageViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setNickNameResult()
        navigateToEdit()
        getTodoDoneCount()
        setUserImg()
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
        viewLifecycleOwner.lifecycleScope.launch {
            binding.layoutMypageTodo.tvTodoCount.text =
                getString(R.string.mypage_todo_count, homeViewModel.getToDoDoneCount())
        }
    }

    private fun setUserImg() {
        binding.ivMypageProfile.setOnClickListener {
            myPageViewModel.getRandomImg()
        }
        myPageViewModel.getRandomImgState.flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach { state ->
                when (state) {
                    is UiState.Loading -> {

                    }

                    is UiState.Success -> {
                        binding.data = state.data
                    }

                    is UiState.Failure -> {

                    }

                    is UiState.Empty -> {

                    }
                }
            }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    companion object {
        const val KEY_NICKNAME_TO_EDIT = "nickname"
        const val KEY_NICKNAME_FROM_EDIT = "nickname"
    }
}