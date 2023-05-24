package com.example.DiffUtil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.R
import com.example.databinding.UserListItemBinding

class DiffAdapter : ListAdapter<DiffModel, DiffAdapter.ViewHolder>(DiffUtil()) {

    lateinit var binding: UserListItemBinding

    class ViewHolder(view : UserListItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = UserListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item =  getItem(position)
        bindView(item)
    }

    private fun bindView(item: DiffModel?) {
        binding.apply {

         txtName.text = item?.name
         txtEmail.text = item?.email

        }
    }

    class  DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<DiffModel>() {
        override fun areItemsTheSame(oldItem: DiffModel, newItem: DiffModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: DiffModel, newItem: DiffModel): Boolean {
            return oldItem == newItem
        }
    }
}