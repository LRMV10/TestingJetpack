package com.example.testingjetpack.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.testingjetpack.R
import com.example.testingjetpack.navigation.AppScreens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Menu(navController: NavController){
    //La función principal que dibuja el resto, el scaffold ayuda a acomodar el contenido
    Scaffold {
        BodyContent(navController)
    }
}

@Composable
fun BodyContent(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Menú",
            modifier = Modifier.padding(top=20.dp))
        Row {
            Image(
                painter= painterResource(R.drawable.ic_report),
                contentDescription ="Report",
                alignment = Alignment.Center,
                //El modifier es la clave en los composables,
                //permite ajustar las propiedades de los componentes
                modifier = Modifier
                    .size(110.dp,68.dp)
                    .padding(top = 20.dp, bottom = 10.dp)
            )
            Image(
                painter= painterResource(R.drawable.ic_alert),
                contentDescription ="Alert",
                alignment = Alignment.Center,
                //El modifier es la clave en los composables,
                //permite ajustar las propiedades de los componentes
                modifier = Modifier
                    .size(110.dp,68.dp)
                    .padding(top = 20.dp, bottom = 10.dp)
            )
        }
        Row {
            Image(
                painter= painterResource(R.drawable.ic_people),
                contentDescription ="People",
                alignment = Alignment.Center,
                //El modifier es la clave en los composables,
                //permite ajustar las propiedades de los componentes
                modifier = Modifier
                    .size(110.dp,68.dp)
                    .padding(top = 20.dp, bottom = 10.dp)
                    .clickable {
                        navController.navigate(route = AppScreens.ListaClientesScreen.route)
                    }
            )
            Image(
                painter= painterResource(R.drawable.ic_sync),
                contentDescription ="Sync",
                alignment = Alignment.Center,
                //El modifier es la clave en los composables,
                //permite ajustar las propiedades de los componentes
                modifier = Modifier
                    .size(110.dp,68.dp)
                    .padding(top = 20.dp, bottom = 10.dp)
            )
        }
    }
}
