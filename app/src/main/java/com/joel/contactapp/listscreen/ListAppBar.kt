package com.joel.contactapp.listscreen

import androidx.compose.material.BottomAppBar
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.CoroutineScope

@Composable
fun AppBars(){
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {

        },
        bottomBar = {

        },
    ) {

    }


}

@Composable
fun BottomBar(){
    BottomAppBar(

    ) {

    }
}

@Composable
fun TopAppBar(
    scope:CoroutineScope,
    scaffoldState: ScaffoldState
){


}