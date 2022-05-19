package com.joel.contactapp.navigation

sealed class Routes (
    val routes : String
        ){
    object Contacts : Routes(
        routes = "contacts_screen"
    )
    object Input : Routes(
        routes = "input_screen"
    )

}
