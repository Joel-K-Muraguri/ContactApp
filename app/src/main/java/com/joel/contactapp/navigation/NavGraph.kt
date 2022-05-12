package com.joel.contactapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.joel.contactapp.inputscreen.InputScreen
import com.joel.contactapp.listscreen.ContactScreen

@Composable
fun NavGraph(
    navController: NavHostController
){
    NavHost(navController = navController, startDestination = AppBarScreens.Contacts.route){
        composable(route = AppBarScreens.Contacts.route){
            ContactScreen()
        }
        composable(route = AppBarScreens.FixAndMerge.route){
            InputScreen()
        }
    }
}