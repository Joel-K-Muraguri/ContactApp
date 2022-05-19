package com.joel.contactapp.data

import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getAllContacts() : Flow<List<Contact>>

    fun getContactById(id: Int):Contact?

    suspend fun insert(contact: Contact)

    suspend fun update(contact: Contact)

    suspend fun deleteContacts(contact: Contact)

    suspend fun deleteAllContacts()
}