package com.example.testingjetpack.screens

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClienteInfo(navController: NavController){
    //La función principal que dibuja el resto, el scaffold ayuda a acomodar el contenido
    Scaffold {
        ListContentCliente()
    }
}

@Composable
fun ListContentCliente(){

}

@Preview
@Composable
fun ClienteinfoPreview(){
    ListContentCliente()
}