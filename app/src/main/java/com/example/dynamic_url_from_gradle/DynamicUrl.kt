package com.example.dynamic_url_from_gradle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.databinding.ActivityDynamicUrlBinding

class DynamicUrl : AppCompatActivity() {

    var count = 0

    private lateinit var binding: ActivityDynamicUrlBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityDynamicUrlBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            btn.setOnClickListener {
                count++
                txtBuildType.text = count.toString()
            }
        }

    }
}