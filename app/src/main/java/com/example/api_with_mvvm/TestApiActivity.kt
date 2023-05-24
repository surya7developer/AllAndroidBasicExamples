package com.example.api_with_mvvm

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.api_with_mvvm.viewmodel.MainViewModel
import com.example.databinding.ActivityTestApiBinding

class TestApiActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: ActivityTestApiBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityTestApiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
        initObserver()

    }

    @SuppressLint("SetTextI18n")
    private fun initObserver() {

        mainViewModel.getLiveDataObserver().observe(this) {
            if (it != null) {
                for (item in it)
                    binding.apply {
                        txtResult.text = txtResult.text.toString()
                            .plus("\n\n") + "id : ${item.id}\ntitle : ${item.title}"
                    }
            }
        }

        mainViewModel.getLiveDataUserListObserver().observe(this) {
            if (it != null) {
                for (item in it)
                    binding.apply {
                        txtResult.text = txtResult.text.toString()
                            .plus("\n\n") + "postId : ${item.postId}\nid : ${item.id}\nname : ${item.name}"
                    }
            }
        }

        mainViewModel.getLiveDataUserListQueryObserver().observe(this) {
            if (it != null) {
                for (item in it)
                    binding.apply {
                        txtResult.text = txtResult.text.toString()
                            .plus("\n\n") + "postId : ${item.postId}\nid : ${item.id}\nname : ${item.name}"
                    }
            }
        }

        mainViewModel.getLiveDataUserListMultipleQueryObserver().observe(this) {
            if (it != null) {
                for (item in it)
                    binding.apply {
                        txtResult.text = txtResult.text.toString()
                            .plus("\n\n") + "postId : ${item.postId}\nid : ${item.id}\nname : ${item.name}"
                    }
            }
        }

        mainViewModel.getLiveDataUserListQueryMapObserver().observe(this) {
            if (it != null) {
                for (item in it)
                    binding.apply {
                        txtResult.text = txtResult.text.toString()
                            .plus("\n\n") + "postId : ${item.postId}\nid : ${item.id}\nname : ${item.name}"
                    }
            }
        }
    }

    private fun initViewModel() {

        mainViewModel = ViewModelProvider(this,
            MainViewModel.MainViewModelFactory(this))[MainViewModel::class.java]
        binding.mainViewModel = mainViewModel
        //mainViewModel.getApiData()
       // mainViewModel.getUserData()
       // mainViewModel.getUserDataQuery()
       // mainViewModel.getUserDataMultipleQuery()
        mainViewModel.getUserDataQueryHashMap()

    }
}