package com.example.DiffUtil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.R
import com.example.databinding.ActivityDiffUtillBinding

class DiffUtilActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDiffUtillBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiffUtillBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {

            val adapter =  DiffAdapter()

            val diff1 = DiffModel(1,"Suresh","suresh@gmail.com")
            val diff2 = DiffModel(2,"Himani","himani@gmail.com")
            val diff3 = DiffModel(3,"Heli","heli@gmail.com")
            val diff7 = DiffModel(4,"Ravi","heli@gmail.com")
            val diff8 = DiffModel(5,"Vipul","heli@gmail.com")

            adapter.submitList(listOf(diff1,diff2,diff3,diff7,diff8))
            rvDiff.adapter = adapter


            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                val diff0 = DiffModel(1,"Suresh","suresh@gmail.com")
                val diff4 = DiffModel(4,"Rinkal","rinkal@gmail.com")
                val diff5 = DiffModel(5,"meet","meet@gmail.com")

                adapter.submitList(listOf(diff0,diff4,diff5))

            },5000)


        }

    }
}