package com.joel.contactapp.contactlistscreen

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.joel.contactapp.R
import com.joel.contactapp.navigation.Routes

// This page should contain :
// TopAppBar - menu for drawers, ImageButton, Vertical three dots and search bar
// BottomAppBar - two items - contacts and fix and merge
// List of Contacts to be sorted in letters
@Composable
fun ContactScreen(
    navController: NavHostController
){
    Scaffold(
        topBar ={
                TopAppBar(
                    title = {
                        Text(text = "Contacts")
                    }
                ) 
        } ,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Routes.Input.routes)
                 }) {
                Icon(imageVector = Icons.Filled.Add,
                    contentDescription = stringResource(id = R.string.add_contacts))
            }
        }
    ) {

    }
}