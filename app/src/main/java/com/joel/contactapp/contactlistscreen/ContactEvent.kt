package com.joel.contactapp.contactlistscreen

sealed class ContactEvent(){
    object OnContactClick : ContactEvent()
    object OnNavigate : ContactEvent()

}
