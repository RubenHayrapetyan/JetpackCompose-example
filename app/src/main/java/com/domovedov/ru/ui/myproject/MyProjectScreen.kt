package com.domovedov.ru.ui.myproject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.domovedov.ru.navigation.Screen

@Composable
fun MyProjectScreen(navController: NavController){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Blue)) {

        Button(onClick = {
            navController.navigate(Screen.ConfiguratorScreen.route)

        }, Modifier.padding(top = 100.dp, start = 100.dp)) {
            Text(text = "Go to configurator")
        }
    }
}