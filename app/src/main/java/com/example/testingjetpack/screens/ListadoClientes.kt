package com.example.testingjetpack.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.testingjetpack.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListadoClientes(navController: NavController){
    //La función principal que dibuja el resto, el scaffold ayuda a acomodar el contenido
    Scaffold {
        ListContent()
    }
}

@Composable
fun ListContent(){
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(top=20.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Listado de Clientes",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        )
        Image(
            painter= painterResource(R.drawable.ic_scanner),
            contentDescription ="QR_Scan",
            modifier = Modifier.padding(top=5.dp)
                .size(25.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun preview()
{
    ListContent();
}