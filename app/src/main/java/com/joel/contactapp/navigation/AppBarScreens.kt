package com.joel.contactapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AppBarScreens(
    val route: String,
    val icons: ImageVector,
    val title: String
){
    object Contacts : AppBarScreens(
        route = "Contacts_Home",
        icons = Icons.Filled.Person,
        title = "Contacts"
    )
    object FixAndMerge : AppBarScreens(
        route = "FixAndMerge",
        icons = Icons.Filled.Settings,
        title = "Fix & Merge"
    )

}
