package com.example.RoomDatabase.DAO

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.RoomDatabase.entities.Contact

@Dao
interface ContactDao {

    @Insert
    suspend fun insertContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Delete
    suspend fun deleteAllContact(list: List<Contact>)

    @Query("SELECT * FROM Contact")
    fun getContacts() : LiveData<List<Contact>>

}