import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import com.domovedov.ru.navigation.MainSubScreen
import com.domovedov.ru.navigation.Screen

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

@Composable
private fun NavController.currentScreen(): State<Boolean> {

    val currentScreen = remember { mutableStateOf(false) }

    DisposableEffect(key1 = this) {

        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->

            when {

                destination.hierarchy.any { it.route == Screen.StoriesFullScreen.route } -> {

                    currentScreen.value = Screen.StoriesFullScreen

                } else -> currentScreen.value = MainSubScreen.NoBottomBar

            }

        }

        addOnDestinationChangedListener(listener)

    }

    return currentScreen

}