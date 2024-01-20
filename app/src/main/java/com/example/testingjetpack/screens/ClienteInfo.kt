package com.example.testingjetpack.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClienteInfo(navController: NavController,item:String?=null,item1:Long?=null){
    //La función principal que dibuja el resto, el scaffold ayuda a acomodar el contenido
    Scaffold {
        ListContentCliente(item,item1)
    }
}

@Composable
fun ListContentCliente(persona:String?,idPersona:Long?){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Información de ",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        )
        if (persona != null) {
            Text(
                text = persona,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Blue
                ),
                modifier = Modifier.padding(top = 20.dp)
            )
        }

        Column(horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .padding(start=20.dp)) {
            Text(text = "Ventas anteriores",
                style = TextStyle(
                    fontSize = 16.sp
                ),
                modifier = Modifier.padding(top=40.dp))
            Text(text = "Ventas mes actual",
                style = TextStyle(
                    fontSize = 16.sp
                ),
                modifier = Modifier.padding(top=40.dp))
            Text(text = "Ventas comparativa",
                style = TextStyle(
                    fontSize = 16.sp
                ),
                modifier = Modifier.padding(top=40.dp))
            Text(text = "Límite de crédito",
                style = TextStyle(
                    fontSize = 16.sp
                ),
                modifier = Modifier.padding(top=40.dp))
            Text(text = "Adeudos",
                style = TextStyle(
                    fontSize = 16.sp
                ),
                modifier = Modifier.padding(top=40.dp))
            Text(text = "Comodatos",
                style = TextStyle(
                    fontSize = 16.sp
                ),
                modifier = Modifier.padding(top=40.dp))
            Text(text = "Observaciones/notas",
                style = TextStyle(
                    fontSize = 16.sp
                ),
                modifier = Modifier.padding(top=40.dp))
            Text(text = "Evaluaciones",
                style = TextStyle(
                    fontSize = 16.sp
                ),
                modifier = Modifier.padding(top=40.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ClienteinfoPreview(){
    val name="Juan"
    val id:Long=1
    Column(modifier = Modifier.fillMaxSize()) {
        ListContentCliente(name,id)
    }
}
