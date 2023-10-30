package kr.ac.konkuk.gdsc.hyeseon.util.activity

import android.app.Activity
import android.view.View
import kr.ac.konkuk.gdsc.hyeseon.util.context.hideKeyboard

fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}