package com.joel.contactapp.listscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.joel.contactapp.navigation.NavScreens
import com.joel.contactapp.navigation.AppBarScreens
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun ContactScreen(){
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
    val navController = rememberNavController()

    Scaffold(
        topBar = {
                 TopAppBar(scope = scope,
                     scaffoldState = scaffoldState)

        },
        drawerContent = {

        },
        floatingActionButton = {
                               FloatingActionButton(
                                   onClick = { navController.navigate(NavScreens.InputScreen.route) }) {
                                   Icon(imageVector = Icons.Filled.Add,
                                       contentDescription = "Add")
                               }
        },
        bottomBar = {
                    BottomBar(navController = navController)

        },
    ) {
        ContactView()
    }
}

@Preview(showBackground = true)
@Composable
fun ContactScreenPreview(){
    ContactScreen()
}

@Composable
fun TopAppBar(
    scope:CoroutineScope,
    scaffoldState: ScaffoldState
){
    var search by remember {
        mutableStateOf("")
    }
    TopAppBar(
        navigationIcon = {
                         IconButton(onClick = {
                             scope.launch {
                                 scaffoldState.drawerState.open()
                             }
                         }) {
                             Icon(
                                 imageVector = Icons.Filled.Menu ,
                                 contentDescription =  "Menu")
                         }
        },
        title = {
            TextField(value = search ,
                onValueChange = {search = it} )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview(){
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
    TopAppBar(scope = scope, scaffoldState = scaffoldState)
}

@Composable
fun BottomBar(
     navController: NavHostController
){
    BottomAppBar {
        val items = listOf(
            AppBarScreens.Contacts,
            AppBarScreens.FixAndMerge
        )
        BottomAppBar {

            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            items.forEach { screens ->
                BottomAppBarItem(
                    screens = screens,
                    currentDestination = currentDestination,
                    navController = navController)

            }
        }
    }
}

@Composable
fun RowScope.BottomAppBarItem(
    screens: AppBarScreens,
    currentDestination: NavDestination?,
    navController: NavHostController

){
    BottomNavigationItem(
        icon = {
               Icon(imageVector = screens.icons,
                   contentDescription = screens.title)
        },
        label = {
                Text(text = screens.title)
        },
        selectedContentColor = Color.White,
        unselectedContentColor = Color.White.copy(0.6f),
        selected = currentDestination?.hierarchy?.any {
            it.route == screens.route
        } == true ,


        onClick = {
            navController.navigate(screens.route){
                navController.graph.startDestinationRoute?.let { route ->
                    popUpTo(route){
                        saveState = true
                    }
                }
                restoreState = true
                launchSingleTop = true
            } },
    )
}

@Preview(showBackground = true)
@Composable
fun BottomAppBarPreview(){
    val navController = rememberNavController()
    BottomBar(navController = navController)
}

@Composable
fun ContactView(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "CONTACTS")
    }
}