package com.example.RoomDatabase.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.RoomDatabase.DAO.ContactDao
import com.example.RoomDatabase.entities.Contact

@androidx.room.Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDou(): ContactDao
    companion object {

        var dbObject: ContactDatabase? = null
        fun getDatabase(context: Context): ContactDatabase {
            synchronized(this) {
                if (dbObject == null) {
                    dbObject = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDatabase::class.java,
                        "contactDB"
                    )
                        .build()
                }
            }
            return dbObject!!
        }
    }
}