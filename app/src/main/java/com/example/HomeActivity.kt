package com.example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.Coroutines.CoroutinesActivity
import com.example.RoomDatabase.RoomLoginPage

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    fun openCoroutine(view:View) {

        startActivity(Intent(this@HomeActivity,CoroutinesActivity::class.java))
    }

    fun openRoomDatabase(view: View) {
        startActivity(Intent(this@HomeActivity,RoomLoginPage::class.java))

    }
}