package com.example.testingjetpack.navigation

sealed class AppScreens(val route: String){
    //Se definen los objetos Composables sobre los cuales se pueden navegar para no acceder a objetos no deseados
    object MainScreen: AppScreens("main_screen")
    object MenuScreen: AppScreens("menu_screen")
    object ListaClientesScreen: AppScreens("lista_clientes_screen")
    object ClienteInfoScreen: AppScreens("cliente_info_screen/{item}/{item1}")
    object ResumenVentasScreen: AppScreens("resumen_ventas_screen/{titulo}/{tipo}")
}
