package com.example.testingjetpack.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.testingjetpack.R
import com.example.testingjetpack.dataModels.Cliente
import com.example.testingjetpack.navigation.AppScreens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListadoClientes(navController: NavController){
    //La función principal que dibuja el resto, el scaffold ayuda a acomodar el contenido
    Scaffold {
        ListContent(navController)
    }
}

@Composable
fun ListContent(navController: NavController){

//    var personList = listOf(
//        "Jorge Negrete",
//        "Jorge Negrete",
//        "Jorge Negrete"
//    )

    val personList = listOf(
        Cliente(1,"El Charro","Jorge Negrete"),
        Cliente(2,"El Charro","Jorge Negrete"),
        Cliente(3,"El Charro","Jorge Negrete")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Listado de Clientes",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        )
        val context= LocalContext.current
        Image(
            painter = painterResource(R.drawable.ic_scanner),
            contentDescription = "QR_Scan",
            modifier = Modifier
                .padding(top = 5.dp)
                .size(25.dp)
                .clickable {
                    Toast
                        .makeText(context, "Abriendo Scanner QR", Toast.LENGTH_SHORT)
                        .show()
                }
        )

        //Lazy Column funciona para mostrar elementos de forma dinámica
        LazyColumn(horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(10.dp)){
            items(
                items = personList,
                itemContent = { person ->

                    Column(modifier = Modifier.clickable {
                        Toast
                            .makeText(context, person.nombreCliente, Toast.LENGTH_SHORT)
                            .show()
                        navController.navigate(route = "cliente_info_screen/${person.nombreCliente}/${person.idCliente}")
                    }) {
                        Text(text = person.nombreNegocio,
                            style = TextStyle(
                                fontWeight = FontWeight.Bold
                            ),
                            modifier = Modifier
                                .padding(top=10.dp, start = 10.dp)
                        )
                        Text(text = person.nombreCliente,
                            style = TextStyle(
                                color = Color.Blue
                            ),
                            modifier = Modifier
                                .padding(start = 10.dp)
                        )
                        Divider()
                    }

                }
            )
        }
    }
}
//
//@Preview(showBackground = true)
//@Composable
//fun preview()
//{
//    ListContent()
//}