package com.joel.contactapp.contactlistscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joel.contactapp.data.Repository
import com.joel.contactapp.util.Constants.ADD_CONTACT_SCREEN
import com.joel.contactapp.util.Constants.EDIT_CONTACT_SCREEN
import com.joel.contactapp.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(
   repository: Repository
) :ViewModel() {

    val contacts = repository.getAllContacts()

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event : ContactEvent){
        when(event){
            is ContactEvent.OnContactClick -> {
                sendUiEvent(UiEvent.Navigate(EDIT_CONTACT_SCREEN + "?todoId=${event.contact.id}"))
            }
            is ContactEvent.OnAddScreenNavigate -> {
                sendUiEvent(UiEvent.Navigate(ADD_CONTACT_SCREEN))
            }
        }
    }

    private fun sendUiEvent(event: UiEvent){
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}