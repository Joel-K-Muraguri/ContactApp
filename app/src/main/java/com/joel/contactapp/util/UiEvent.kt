package com.joel.contactapp.util

sealed class UiEvent(){
   data class Navigate(val route: String) : UiEvent()


}
