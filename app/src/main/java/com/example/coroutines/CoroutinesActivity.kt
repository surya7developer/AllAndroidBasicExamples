package com.example.coroutines

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.databinding.ActivityMainBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class CoroutinesActivity : AppCompatActivity() {

   private val TAG = "CheckThreadName"

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "Thread Name onCreate : ${Thread.currentThread().name}")

    }

    @OptIn(DelicateCoroutinesApi::class)
    fun runLongRunningTaskWithCoroutines() {

        GlobalScope.launch {

            Log.d(TAG, "Thread Name runLongRunningTaskWithCoroutines : ${Thread.currentThread().name}")

            for (i in 1..1000000){
                runOnUiThread { binding.txtCoroutineCount.text = i.toString() }
                delay(1)
            }
        }
    }

    fun runLongRunningTaskWithThread() {
        thread(start = true){
            Log.d(TAG, "Thread Name runLongRunningTaskWithThread : ${Thread.currentThread().name}")

            for (i in 1..1000000){
                runOnUiThread { binding.txtAnotherThreadCount.text = i.toString() }
                Thread.sleep(1)
            }
        }
    }

    fun runLongRunningTask() {
        Log.d(TAG, "Thread Name runLongRunningTask : ${Thread.currentThread().name}")

        for (i in 1..1000000){
        }
    }

    @SuppressLint("SetTextI18n")
    fun updateCounter() {
        binding.apply {
            txtCount.text =  "${txtCount.text.toString().toInt() + 1}"
        }
    }

}