package com.joel.contactapp.data

import kotlinx.coroutines.flow.Flow

class RepositoryImplemen (
    private val repository: ContactDao
        ): Repository {
    override fun getAllContacts(): Flow<List<Contact>> {
        return repository.getAllContacts()
    }

    override fun getContactById(id: Int): Contact? {
        return repository.getContactById(id)
    }

    override suspend fun insert(contact: Contact) {
        repository.insert(contact)
    }

    override suspend fun update(contact: Contact) {
        repository.update(contact)
    }

    override suspend fun deleteContacts(contact: Contact) {
        repository.deleteContacts(contact)
    }

    override suspend fun deleteAllContacts() {
        repository.deleteAllContacts()
    }
}