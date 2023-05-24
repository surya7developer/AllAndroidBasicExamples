package com.example.RoomDatabase.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contact")
data class Contact(

    @PrimaryKey(autoGenerate = true)
    val id:Long,
    val Name:String,
    val Email:String,

)
