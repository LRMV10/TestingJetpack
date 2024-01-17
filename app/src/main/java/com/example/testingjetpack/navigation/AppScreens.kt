package com.example.testingjetpack.navigation

sealed class AppScreens(val route: String){
    //Se definen los objetos Composables sobre los cuales se pueden navegar para no acceder a objetos no deseados
    object MainScreen: AppScreens("main_screen")
    object MenuScreen: AppScreens("menu_screen")
}
