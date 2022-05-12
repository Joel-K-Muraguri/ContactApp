package com.joel.contactapp.navigation

import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screens(
    val route: String,
    val icons: ImageVector,
    val title: String
){

}
