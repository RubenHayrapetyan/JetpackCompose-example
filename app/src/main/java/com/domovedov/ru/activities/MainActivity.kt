package com.domovedov.ru.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.domovedov.ru.navigation.BottomNavigationBar
import com.domovedov.ru.navigation.Navigation
import com.domovedov.ru.navigation.Screen
import com.domovedov.ru.ui.theme.DomovedovTheme
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {

    @ExperimentalPagerApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        hideSystemUI()
        super.onCreate(savedInstanceState)
        setContent {
            DomovedovTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()

                    Scaffold(
                        //   topBar = { TopBar() },
                        bottomBar = {

                                BottomNavigationBar(navController)

                        }
                    ) {
                        Navigation(navController)
                    }
                }
            }
        }
    }

    private fun hideSystemUI() {
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE

                        // Hide the nav bar and status bar
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
    }
}


