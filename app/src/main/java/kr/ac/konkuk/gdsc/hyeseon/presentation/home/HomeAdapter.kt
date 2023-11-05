package kr.ac.konkuk.gdsc.hyeseon.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.ac.konkuk.gdsc.hyeseon.databinding.ItemHomeBinding
import kr.ac.konkuk.gdsc.hyeseon.domain.entity.TodoItem
import kr.ac.konkuk.gdsc.hyeseon.util.view.ItemDiffCallback

class HomeAdapter(
    private val onDoneBtnClicked : (TodoItem) -> Unit
) : ListAdapter<TodoItem, HomeAdapter.HomeViewHolder>(
    ItemDiffCallback<TodoItem>(
        onItemsTheSame = { old, new -> old.id == new.id },
        onContentsTheSame = { old, new -> old == new }
    )
) {

    class HomeViewHolder(
        private val binding: ItemHomeBinding,
        private val onDoneBtnClicked: (TodoItem) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: TodoItem) {
            binding.data = data
            binding.executePendingBindings()
            binding.ivHomeTodo.setOnClickListener {
                onDoneBtnClicked(data)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding =
            ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding, onDoneBtnClicked)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}