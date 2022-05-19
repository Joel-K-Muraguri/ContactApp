package com.joel.contactapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.joel.contactapp.contactlistscreen.ContactScreen
import com.joel.contactapp.inputscreen.InputScreen


@Composable
fun Navigation(
    navController: NavHostController
){
    NavHost(navController = navController,
        startDestination = Routes.Contacts.routes){
        composable(route = Routes.Contacts.routes){
            ContactScreen(navController)
        }
        composable(route = Routes.Input.routes){
            InputScreen(navController)
        }
    }

}
