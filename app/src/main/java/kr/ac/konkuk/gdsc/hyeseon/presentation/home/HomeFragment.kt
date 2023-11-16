package kr.ac.konkuk.gdsc.hyeseon.presentation.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kr.ac.konkuk.gdsc.hyeseon.R
import kr.ac.konkuk.gdsc.hyeseon.databinding.FragmentHomeBinding
import kr.ac.konkuk.gdsc.hyeseon.util.binding.BindingFragment

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private val viewModel by viewModels<HomeViewModel>()
    private lateinit var homeAdapter: HomeAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        getDummyTodoList()
    }

    private fun initAdapter() {
        homeAdapter = HomeAdapter(
            onDoneBtnClicked = { todoItem ->
                viewModel.updateDoneBtn(todoItem)
            }
        )
        binding.rvHomeTodolist.adapter = homeAdapter
    }

    private fun getDummyTodoList() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.todoList.collectLatest { todoList ->
                    homeAdapter.submitList(todoList)
                }
            }
        }
    }
}