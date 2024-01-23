package com.example.testingjetpack.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testingjetpack.dataModels.VentaResumen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResumenVentas(titulo:String?=null, tipo:String?=null){
    //La función principal que dibuja el resto, el scaffold ayuda a acomodar el contenido
    Scaffold {
        ListVentas(titulo,tipo)
    }
}

@Composable
fun ListVentas(titulo: String?,tipo: String?){
    var ventas= listOf<VentaResumen>(
        VentaResumen("Coca-Cola","20","11"),
        VentaResumen("Sabritas","10","5"),
        VentaResumen("Arizona","15","2")
    )
    Column( horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp)) {
        if (titulo != null) {
            Text(text = titulo,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            )
        }
        LazyColumn(horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(10.dp)){
            items(
                items=ventas,
                itemContent = {venta ->
                    Row(modifier = Modifier.padding(top = 20.dp)/*,
                        verticalAlignment = Alignment.Start*/) {
                        Text(text = venta.nombreProducto,
                            style = TextStyle(
                                fontSize = 16.sp
                            ))
                        Spacer(modifier = Modifier.weight(1f))
                        if (tipo!=null){
                            if (tipo=="1"){
                                Text(text = venta.ventasAnterior,
                                    style = TextStyle(
                                        color = Color.Blue,
                                        fontSize = 16.sp
                                    ),
                                    modifier = Modifier
                                        .padding(start = 20.dp))
                            }
                            else if(tipo=="2"){
                                Text(text = venta.ventasActual,
                                    style = TextStyle(
                                        color = Color.Blue,
                                        fontSize = 16.sp
                                    ),
                                    modifier = Modifier.padding(start = 20.dp))
                            }
                        }
                    }
                    Divider()
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewListVentas(){
    val titulo = "Ventas del mes anterior"
    val tipo="1"
    ListVentas(titulo,tipo)
}