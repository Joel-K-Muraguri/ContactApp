package com.joel.contactapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.joel.contactapp.contactlistscreen.ContactViewModel
import com.joel.contactapp.inputscreen.InputViewModel
import com.joel.contactapp.navigation.Navigation
import com.joel.contactapp.ui.theme.ContactAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

     private lateinit var navController: NavHostController

     private val inputViewModel by viewModels<InputViewModel>()

    private val contactViewModel by viewModels<ContactViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = androidx.compose.ui.Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                   navController = rememberNavController()
                  //  NavGraph(navController = navController)
                    Navigation(
                        navController = navController,
                        inputViewModel = inputViewModel,
                        contactViewModel = contactViewModel

                    )

                }
            }
        }
    }
}

