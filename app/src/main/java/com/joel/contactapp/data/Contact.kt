package com.joel.contactapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contacts_table")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val name: String,
    val phoneNumber: String,
)
