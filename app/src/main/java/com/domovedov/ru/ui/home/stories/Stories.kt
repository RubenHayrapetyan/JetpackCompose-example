package com.domovedov.ru.ui.home.stories

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.domovedov.ru.R

@ExperimentalFoundationApi
@Composable
fun StoriesFullScreen() {

    var name by remember { mutableStateOf("") }

    Box(Modifier.fillMaxSize().background(Color.Blue)) {
        Column() {
            Spacer(modifier = Modifier.padding(top = 20.dp))
            StoryTimeProgress()
        }
        // Image(painter = , contentDescription = )
    }
}

@ExperimentalFoundationApi
@Composable
fun StoryTimeProgress() {
    LazyVerticalGrid(cells = GridCells.Fixed(5), Modifier.fillMaxSize()) {
        items(1) {
            LazyRow {
                items(4) { item ->
                    Row(Modifier.fillParentMaxSize()) {
                        LinearProgressIndicator(
                            progress = 0.2f,
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                            color = Color.White,
                            backgroundColor = colorResource(id = R.color.white_gradient_50_percent)
                        )
                    }
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun StoryFullScreenPreview() {
    StoriesFullScreen()
}