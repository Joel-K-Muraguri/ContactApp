package com.joel.contactapp.inputscreen


sealed class InputEvents{
    data class OnNameChange(val title: String) : InputEvents()
    data class OnPhoneNumberChange(val phoneNumber: String) : InputEvents()
    object OnSaveContact : InputEvents()
    object OnTodoListScreen : InputEvents()


}
