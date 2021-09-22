package com.domovedov.ru.ui.region

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MYTEEEEST(){
    Surface(Modifier.fillMaxSize()){
        Column(
            Modifier
                .fillMaxSize()
        ) {
            Row(
                Modifier
                    .weight(0.7f)
                    .fillMaxWidth()
                    .background(Color.Blue)
            ) {

                Text(text = "teeeeeeeeeeeeeeeeeext 1")
            }
            Row(
                Modifier
                    .weight(0.3f)
                    .fillMaxWidth()
                    .background(color = Color.Red)
            ) {
                Text(text = "teeeeeeeeeeeeeeeeeext 2")
            }
        }
    }
}