package com.example.RoomDatabase.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.databinding.UserListItemBinding
import com.example.RoomDatabase.entities.Contact

class UserListAdapter(var list: List<Contact>) : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    lateinit var binding: UserListItemBinding

    inner class ViewHolder(binding: UserListItemBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = UserListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return list.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        binding.apply {

            val user = list[position]
            txtName.text = user.Name
            txtEmail.text = user.Email

        }
    }

    fun reload(list: List<Contact>) {

        this.list = list
        notifyDataSetChanged()
    }
}