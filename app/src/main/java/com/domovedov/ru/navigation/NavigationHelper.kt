import androidx.compose.runtime.*
import androidx.navigation.NavController

//package com.example.domproject.navigation
//
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.currentBackStackEntryAsState
//
//@Composable
//fun currentRoute(argumentKey: String?, navController: NavHostController): String? {
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    return navBackStackEntry?.arguments?.getString(KEY_ROUTE)
//}

//@Composable
//private fun NavController.currentScreen(): State<MainSubScreen> {
//
//    val currentScreen = remember { mutableStateOf<MainSubScreen>(MainSubScreen.Home) }
//
//    DisposableEffect(key1 = this) {
//
//        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
//
//            when {
//
//                destination.hierarchy.any { it.route == MainSubScreen.Home.route } -> {
//
//                    currentScreen.value = MainSubScreen.Home
//
//                } else -> currentScreen.value = MainSubScreen.NoBottomBar
//
//            }
//
//        }
//
//        addOnDestinationChangedListener(listener)
//
//    }
//
//    return currentScreen
//
//}