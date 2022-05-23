package com.joel.contactapp.inputscreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joel.contactapp.data.Contact
import com.joel.contactapp.data.Repository
import com.joel.contactapp.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InputViewModel @Inject constructor(
    private val repository: Repository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    var contact by mutableStateOf<Contact?>(null)
        private set

    var name by mutableStateOf("")
        private set

    var phoneNumber by mutableStateOf("")
        private set

    init {
        val todoId = savedStateHandle.get<Int>("todoId")!!
        if (todoId != -1){
            viewModelScope.launch {
                repository.getContactById(todoId)?.let { contact ->
                    name = contact.name
                    phoneNumber = (contact.phoneNumber ?: "") as String
                    this@InputViewModel.contact = contact
                }
            }
        }
    }



    fun onEvent(event: InputEvents){
        when(event) {
            is InputEvents.OnNameChange -> {
                name = event.title

            }
            is InputEvents.OnPhoneNumberChange -> {
                phoneNumber = event.phoneNumber
            }
            is InputEvents.OnSaveContact -> {
                viewModelScope.launch {
                    repository.insert(
                        Contact(
                            id = contact?.id,
                            name = name,
                            phoneNumber = phoneNumber,
                        )
                    )
                }
            }
            is InputEvents.OnTodoListScreen -> {
                sendUiEvent(UiEvent.PopBackStack)
            }
        }
    }

    private fun sendUiEvent(event: UiEvent){
       viewModelScope.launch {
           _uiEvent.send(event)
       }
    }
}