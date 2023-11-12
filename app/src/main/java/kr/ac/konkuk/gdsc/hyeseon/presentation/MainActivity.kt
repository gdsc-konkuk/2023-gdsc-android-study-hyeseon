package kr.ac.konkuk.gdsc.hyeseon.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import kr.ac.konkuk.gdsc.hyeseon.R
import kr.ac.konkuk.gdsc.hyeseon.databinding.ActivityMainBinding
import kr.ac.konkuk.gdsc.hyeseon.presentation.createtodo.CreateTodoFragment
import kr.ac.konkuk.gdsc.hyeseon.presentation.home.HomeFragment
import kr.ac.konkuk.gdsc.hyeseon.presentation.mypage.MyPageFragment
import kr.ac.konkuk.gdsc.hyeseon.util.binding.BindingActivity

class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigateTo<HomeFragment>()
        initBnvItemSelectedListener()
        syncBottomNavigationBackStackAdded()
    }

    private fun initBnvItemSelectedListener() {
        binding.bnvMain.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> navigateTo<HomeFragment>()
                R.id.menu_mypage -> navigateTo<MyPageFragment>()
            }
            true
        }
        binding.fabMain.setOnClickListener {
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
            is HomeFragment -> binding.bnvMain.selectedItemId = R.id.menu_home
            is MyPageFragment -> binding.bnvMain.selectedItemId = R.id.menu_mypage
        }
    }

    private inline fun <reified T : Fragment> navigateTo() {
        supportFragmentManager.commit {
            replace<T>(R.id.fcv_main, T::class.simpleName)
        }
    }
}