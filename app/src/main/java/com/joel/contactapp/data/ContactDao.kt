package com.joel.contactapp.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {

    @Query("SELECT * FROM Contacts_table")
    fun getAllContacts() : Flow<List<Contact>>

    @Query("SELECT * FROM Contacts_table WHERE id =:id")
    fun getContactById(id: Int):Contact?

    @Insert
    suspend fun insert(contact: Contact)

    @Update
    suspend fun update(contact: Contact)

    @Delete
    suspend fun deleteContacts(contact: Contact)

    @Query("DELETE FROM Contacts_table")
    suspend fun deleteAllContacts()

}