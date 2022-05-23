package com.joel.contactapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.joel.contactapp.contactlistscreen.ContactScreen
import com.joel.contactapp.contactlistscreen.ContactViewModel
import com.joel.contactapp.inputscreen.InputScreen
import com.joel.contactapp.inputscreen.InputViewModel
import com.joel.contactapp.util.Constants


@Composable
fun Navigation(
    navController: NavHostController,
    inputViewModel : InputViewModel,
    contactViewModel: ContactViewModel
){
    NavHost(
        navController = navController,
        startDestination = Constants.CONTACTS_LIST
    ) {
        composable(Constants.CONTACTS_LIST) {
            ContactScreen(
                onNavigate = {
                    navController.navigate(it.route)
                },
               mViewModel = contactViewModel
            )
        }
        composable(
            route = Constants.ADD_CONTACT_SCREEN + "?todoId={todoId}",
            arguments = listOf(
                navArgument(name = "todoId") {
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ) {
            InputScreen(onPopBackStack = {
                navController.popBackStack()
            },
                mViewModel = inputViewModel
            )
        }
    }

}
