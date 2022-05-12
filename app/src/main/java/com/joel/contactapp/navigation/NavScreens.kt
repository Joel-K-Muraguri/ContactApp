package com.joel.contactapp.navigation

sealed class NavScreens(
    val route : String
){
    object InputScreen : NavScreens(
        route = "input_screen"
    )
}
