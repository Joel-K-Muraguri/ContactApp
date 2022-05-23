package com.joel.contactapp.contactlistscreen

import com.joel.contactapp.data.Contact

sealed class ContactEvent {
    data class OnContactClick (val contact: Contact) : ContactEvent()
    object OnAddScreenNavigate : ContactEvent()

}
