package com.example.RoomDatabase.database

import androidx.room.RoomDatabase
import com.example.RoomDatabase.DAO.ContactDao
import com.example.RoomDatabase.entities.Contact

@androidx.room.Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {

    abstract fun contactDou() : ContactDao
}