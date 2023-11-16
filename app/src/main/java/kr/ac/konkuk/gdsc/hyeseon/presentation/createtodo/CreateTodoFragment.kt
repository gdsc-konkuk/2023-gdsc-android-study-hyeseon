package kr.ac.konkuk.gdsc.hyeseon.presentation.createtodo

import android.os.Bundle
import android.view.View
import dagger.hilt.android.AndroidEntryPoint
import kr.ac.konkuk.gdsc.hyeseon.R
import kr.ac.konkuk.gdsc.hyeseon.databinding.FragmentMyPageBinding
import kr.ac.konkuk.gdsc.hyeseon.util.binding.BindingFragment

@AndroidEntryPoint
class CreateTodoFragment : BindingFragment<FragmentMyPageBinding>(R.layout.fragment_create_todo) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}