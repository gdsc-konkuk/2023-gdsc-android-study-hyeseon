package kr.ac.konkuk.gdsc.hyeseon.util.activity

import android.app.Activity
import android.view.View
import android.widget.Toast
import kr.ac.konkuk.gdsc.hyeseon.util.context.hideKeyboard

fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}

fun Activity.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}