package com.example.testingjetpack.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testingjetpack.screens.ClienteInfo
import com.example.testingjetpack.screens.ListadoClientes
import com.example.testingjetpack.screens.LoginScreen
import com.example.testingjetpack.screens.Menu

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.MainScreen.route){
        //Las rutas para la navegación dentro del programa.
        composable(route=AppScreens.MainScreen.route){
            LoginScreen(navController)
        }
        composable(route=AppScreens.MenuScreen.route){
            Menu(navController)
        }
        composable(route=AppScreens.ListaClientesScreen.route){
            ListadoClientes(navController)
        }
        composable(route=AppScreens.ClienteInfoScreen.route){
            //Así se pasan los argumentos entre Screens
            val item = it.arguments?.getString("item")
            val item1 = it.arguments?.getLong("item1")
            ClienteInfo(navController,item = item,item1 = item1)
        }
    }
}