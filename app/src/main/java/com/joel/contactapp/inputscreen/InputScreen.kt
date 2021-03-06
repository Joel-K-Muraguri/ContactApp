package com.joel.contactapp.inputscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.joel.contactapp.R
import com.joel.contactapp.navigation.Routes
import com.joel.contactapp.util.UiEvent
import kotlinx.coroutines.flow.collect

@Composable
fun InputScreen(
    mViewModel: InputViewModel,
    onPopBackStack : () -> Unit

) {
    LaunchedEffect(key1 = true){
        mViewModel.uiEvent.collect { event ->
            when(event){
                is UiEvent.PopBackStack  -> onPopBackStack()
                else -> Unit
            }
        }
    }


    Scaffold(
        topBar = {
            TopAppBar(

                backgroundColor = Color.White,
                navigationIcon = {
                    IconButton(onClick = {
                        mViewModel.onEvent(InputEvents.OnTodoListScreen)
                    }) {
                        Icon(imageVector = Icons.Filled.Close,
                            contentDescription = "Close")
                    }
                },
                title = { Text(text = "Create Contact")},
                actions = {
                    Button(
                        onClick = {
                            mViewModel.onEvent(InputEvents.OnSaveContact) },
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Text(
                            text = "Save",
                        )
                    }
                    IconButton(
                        onClick = { /*TODO*/ },
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_drop_down_24),
                            contentDescription = stringResource(id = R.string.drop_down) )
                    }
                }
            )
        }
    ) {
        Column (
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            OutlinedTextField(
                value = mViewModel.name,
                onValueChange = {
                                mViewModel.onEvent(InputEvents.OnNameChange(it))
                },
                shape = RoundedCornerShape(20.dp),
                label = { Text(text = "Name")}
            )
            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = mViewModel.phoneNumber ,
                onValueChange = {
                                mViewModel.onEvent(InputEvents.OnPhoneNumberChange(it))
                },
                shape = RoundedCornerShape(20.dp),
                label = { Text(text = "Phone Number")},
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone
                )
            )
        }
    }
}


