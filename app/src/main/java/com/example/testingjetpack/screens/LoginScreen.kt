package com.example.testingjetpack.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.testingjetpack.R

//Imports importantes para la función de rememberSaveable { mutableStateOf("") }
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.testingjetpack.navigation.AppScreens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController){
    Scaffold {
        Column(modifier= Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Logo(navController)
            Session(navController)
        }
    }
}

@Composable
fun Logo(navController: NavController){
    //Insersión de una imagen
    Image(
        painter= painterResource(R.drawable.mixteca_manda),
        contentDescription ="Logo de la Corona",
        alignment = Alignment.Center,
        //El modifier es la clave en los composables,
        //permite ajustar las propiedades de los componentes
        modifier = Modifier
            .size(308.dp)
            .padding(top = 30.dp, bottom = 10.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Session(navController: NavController) {
    //Variables para almacenar el usuario y contraseña (Aún no se ocupan)
    var password by rememberSaveable { mutableStateOf("") }
    var passwordHidden by rememberSaveable { mutableStateOf(true) }

    var text by rememberSaveable { mutableStateOf("") }
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Text(
            text = "On Route"
        )
        Text(
            text = "Iniciar Sesión",
            modifier = Modifier.padding(top=20.dp)
        )

        OutlinedTextField(
            value=text,
            onValueChange = {text = it},
            label = { Text("Usuario") },
            modifier = Modifier.padding(top=20.dp)
        )

        OutlinedTextField(
            value=password,
            onValueChange = {password = it},
            singleLine = true,
            label = { Text("Contraseña") },
            modifier = Modifier.padding(top=20.dp),

            //Es un conjunto de acciones visuales para el caso de las contraseñas, para no mostrar su contenido
            //Es algo más complejo que hacerlo simplemente en un xml.
            //hay que tener cuidado con los imports y la librería icons (puse un comentario en el BuildGradle)
            visualTransformation =
            if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                IconButton(onClick = { passwordHidden = !passwordHidden }) {
                    val visibilityIcon =
                        if (passwordHidden) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                    // Please provide localized description for accessibility services
                    val description = if (passwordHidden) "Show password" else "Hide password"
                    Icon(imageVector = visibilityIcon, contentDescription = description)
                }
            }

        )

        Button(onClick = {
                         navController.navigate(route = AppScreens.MenuScreen.route)
                         },
            modifier = Modifier
                .padding(top = 15.dp)
                .width(308.dp)) {
            Text(
                text = "Iniciar Sesión",
                style = TextStyle(
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }

}
