package com.domovedov.ru.ui.home.stories

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.domovedov.entities.local.StoryFullScreenModel
import com.domovedov.ru.R
import com.domovedov.ru.noRippleClickable
import com.domovedov.ru.ui.home.picturesList

@ExperimentalFoundationApi
@Composable
fun StoriesFullScreenView(){

    val storyFullScreenModel = StoryFullScreenModel("Story title", "This is description",
        picturesList)
    StoriesFullScreen(storyFullScreenModel)
}

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun StoriesFullScreen(storyFullScreenModel: StoryFullScreenModel) {

    var pictureUrl by remember { mutableStateOf(storyFullScreenModel.pictureUrl[0]) }

    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Red)) {

        Image(
            painter = rememberImagePainter(pictureUrl),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Row {
            Column(
                Modifier
                    .background(Color.Transparent)
                    .fillMaxSize()
                    .weight(1f)
                    .noRippleClickable {
                        Log.i("asdvasvd", "dzax")
                    }) {

            }
            Column(
                Modifier
                    .background(Color.Transparent)
                    .fillMaxSize()
                    .weight(1f)
                    .noRippleClickable {
                        Log.i("asdvasvd", "aj")
                    }) {
            }
        }
    }

//    Box(
//        Modifier
//            .fillMaxSize()
//            .background(Color.Blue)) {
//
//        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//            Spacer(modifier = Modifier.padding(top = 20.dp))
//            StoryTimeProgress()
//        }
//        Image(
//            painter = rememberImagePainter(pictureUrl),
//            contentDescription = null,
//            modifier = Modifier.fillMaxSize(),
//            contentScale = ContentScale.FillBounds
//        )
//    }
}

@ExperimentalFoundationApi
@Composable
fun StoryTimeProgress() {
    LazyVerticalGrid(cells = GridCells.Fixed(5), Modifier.fillMaxSize()) {
        items(5) {
            LazyRow {
                items(1) { item ->
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
   // StoriesFullScreen()
}