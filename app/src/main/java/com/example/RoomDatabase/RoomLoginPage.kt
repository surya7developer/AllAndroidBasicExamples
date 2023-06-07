package com.example.RoomDatabase

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.RoomDatabase.adapter.UserListAdapter
import com.example.RoomDatabase.database.ContactDatabase
import com.example.RoomDatabase.entities.Contact
import com.example.databinding.ActivityRoomLoginPageBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RoomLoginPage : AppCompatActivity() {

    private var dataList: List<Contact>? = null
    private lateinit var binding: ActivityRoomLoginPageBinding
    lateinit var database: ContactDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityRoomLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database = ContactDatabase.getDatabase(this)

        database.contactDou().getContacts().observe(this) {
            binding.apply {
                dataList = it
                binding.btnDeleteAll.isEnabled = it.isNotEmpty()
                binding.rcUserList.adapter = UserListAdapter(it)
            }


        }
    }

    fun saveData(view: View) {


        binding.apply {

            val name = edtName.text.toString()
            val email = edtEmail.text.toString()


            if (name.isEmpty()){
                showMessage("Please enter name")
            }else if (email.isEmpty()){
                showMessage("Please enter email")

            }else
            {
                hideKeyaboard()
                val job = GlobalScope.launch {
                    database.contactDou().insertContact(Contact(
                        id = 0,
                        name,
                        email
                    ))
                }
                showMessage("Data Saved")
            }
        }
    }

    private fun hideKeyaboard() {

        val view: View? = this.currentFocus
        if (view != null) {
            val imm: InputMethodManager? =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
            imm?.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    fun deleteAllData(view: View) {

        GlobalScope.launch {
            dataList?.let { database.contactDou().deleteAllContact(it) }
        }

    }
}