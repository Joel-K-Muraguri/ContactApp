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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.joel.contactapp.navigation.Routes

@Composable
fun InputScreen(
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            InputScreenAppBar(navController = navController)
        }
    ) {
        InputScreenTextField()
    }
}

@Composable
fun InputScreenAppBar(
    navController: NavHostController
){
    TopAppBar(
        backgroundColor = Color.White,
        navigationIcon = {
                         IconButton(onClick = {
                             navController.navigate(Routes.Contacts.routes)
                         }) {
                           Icon(imageVector = Icons.Filled.Close,
                               contentDescription = "Close")
                         }
        },
        title = { Text(text = "Create Contact")},
        actions = {
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(
                    text = "Save",
                )
            }
        }
    )
}

/*@Preview(showBackground = true)
@Composable
fun InputScreenAppBarPreview(){
    InputScreenAppBar()
}*/

@Composable
fun InputScreenTextField(){
    var name by remember {
        mutableStateOf("")
    }
    var phoneNumber by remember {
        mutableStateOf("")
    }

    Column (
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
            ){
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            shape = RoundedCornerShape(20.dp),
            label = { Text(text = "Name")}
        )
        Spacer(modifier = Modifier.height(20.dp))

       OutlinedTextField(
           value = phoneNumber ,
           onValueChange = {phoneNumber = it},
           shape = RoundedCornerShape(20.dp),
           label = { Text(text = "Phone Number")},
           keyboardActions = KeyboardActions {

           },
           keyboardOptions = KeyboardOptions(
               keyboardType = KeyboardType.Phone
           )
       )
    }
}

@Preview(showBackground = true)
@Composable
fun InputScreenPreview(){
    val navController = rememberNavController()
    InputScreen(navController)
}