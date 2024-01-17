package com.example.testingjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.testingjetpack.navigation.AppNavigation
import com.example.testingjetpack.ui.theme.TestingJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestingJetpackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    //Abarca toda la pantalla
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Desde esta función se maneja la navegación entre pantallas
                    AppNavigation()
                }
            }
        }
    }
}

//Previsualizador, es parte del composable y ayuda a diseñar la pantalla
@Preview(showBackground = true)
@Composable
fun SessionPreview() {
    TestingJetpackTheme {
        AppNavigation()
    }
}