package kr.ac.konkuk.gdsc.hyeseon.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import kr.ac.konkuk.gdsc.hyeseon.R
import kr.ac.konkuk.gdsc.hyeseon.databinding.ActivityMainBinding
import kr.ac.konkuk.gdsc.hyeseon.presentation.createtodo.CreateTodoFragment
import kr.ac.konkuk.gdsc.hyeseon.presentation.mypage.MyPageFragment
import kr.ac.konkuk.gdsc.hyeseon.presentation.todolist.TodoHomeFragment
import kr.ac.konkuk.gdsc.hyeseon.util.activity.toast
import kr.ac.konkuk.gdsc.hyeseon.util.binding.BindingActivity

class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigateTo<TodoHomeFragment>()
        initBnvItemSelectedListener()
        syncBottomNavigationBackStackAdded()
    }

    private fun initBnvItemSelectedListener() {
        binding.fcvMain.setOnClickListener {
            toast("hello")
        }
        binding.bnvMain.setOnItemSelectedListener { item ->
            Log.e("id", item.itemId.toString())
            when (item.itemId) {
                R.id.menu_home -> navigateTo<TodoHomeFragment>()
                R.id.menu_mypage -> navigateTo<MyPageFragment>()
            }
            true
        }
        binding.fabMain.setOnClickListener {
            Log.e("hi", "ji")
            navigateTo<CreateTodoFragment>()
        }
    }

    private fun syncBottomNavigationBackStackAdded() {
        supportFragmentManager.addOnBackStackChangedListener {
            syncBottomNavigation()
        }
    }

    private fun syncBottomNavigation() {
        when (supportFragmentManager.findFragmentById(R.id.fcv_main)) {
            is TodoHomeFragment -> binding.bnvMain.selectedItemId = R.id.menu_home
            is MyPageFragment -> binding.bnvMain.selectedItemId = R.id.menu_mypage
        }
    }

    private inline fun <reified T : Fragment> navigateTo() {
        supportFragmentManager.commit {
            replace<T>(R.id.fcv_main, T::class.simpleName)
        }
    }
}