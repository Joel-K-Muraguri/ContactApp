package com.joel.contactapp.contactlistscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.joel.contactapp.R
import com.joel.contactapp.util.UiEvent
import kotlinx.coroutines.flow.collect

// This page should contain :
// TopAppBar - menu for drawers, ImageButton, Vertical three dots and search bar
// BottomAppBar - two items - contacts and fix and merge
// List of Contacts to be sorted in letters
@Composable
fun ContactScreen(
    onNavigate : (UiEvent.Navigate) -> Unit,
    mViewModel: ContactViewModel

){
    val contacts = mViewModel.contacts.collectAsState(initial = emptyList())
    val scaffoldState = rememberScaffoldState()
    LaunchedEffect(key1 = true){
        mViewModel.uiEvent.collect { event ->
            when(event){
                is UiEvent.Navigate -> onNavigate(event)
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
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
                    mViewModel.onEvent(ContactEvent.OnAddScreenNavigate)
                 }) {
                Icon(imageVector = Icons.Filled.Add,
                    contentDescription = stringResource(id = R.string.add_contacts))
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ){
            items(contacts.value){ contact ->
                ContactItem(
                    contact = contact ,
                    modifier = Modifier
                        .clickable(
                            onClick = {
                                mViewModel.onEvent(ContactEvent.OnContactClick(contact))
                            }
                        )
                        .fillMaxWidth()
                )
            }
        }
    }
}