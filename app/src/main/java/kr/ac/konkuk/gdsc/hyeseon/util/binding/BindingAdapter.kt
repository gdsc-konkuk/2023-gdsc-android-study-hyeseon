package kr.ac.konkuk.gdsc.hyeseon.util.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.RoundedCornersTransformation
import kr.ac.konkuk.gdsc.hyeseon.R

@BindingAdapter("setDoneIcon")
fun setDoneIcon(view: ImageView, isDone: Boolean) {
    val imageRes = if (isDone) {
        R.drawable.ic_home_todo_done
    } else {
        R.drawable.ic_home_todo_yet
    }
    view.setImageResource(imageRes)
}

@BindingAdapter("imageUrl")
fun ImageView.imageUrl(imageUrl: String?) {
    if (imageUrl == null) return
    load(imageUrl) {
        transformations(RoundedCornersTransformation(10F))
    }
}