package com.domovedov.ru.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.domovedov.ru.navigation.BottomNavigationBar
import com.domovedov.ru.navigation.Navigation
import com.domovedov.ru.navigation.Screen
import com.domovedov.ru.ui.home.stories.StoriesViewModel
import com.domovedov.ru.ui.theme.DomovedovTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import org.koin.androidx.compose.getViewModel

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
                    val vm = getViewModel<StoriesViewModel>()
                    val navBarVisibility: Boolean by vm.bottomNavBar.observeAsState(true)
                    var bottomBarState by remember{ mutableStateOf(true) }

                    Scaffold(
                        //   topBar = { TopBar() },

                        bottomBar = {
                            bottomBarState = navBarVisibility
                            if (navBarVisibility){
                                BottomNavigationBar(navController)
                              //  Toast.makeText(this, "Visible", Toast.LENGTH_SHORT).show()
                            }else{
                               // Toast.makeText(this, "Hidden", Toast.LENGTH_SHORT).show()

                            }
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


