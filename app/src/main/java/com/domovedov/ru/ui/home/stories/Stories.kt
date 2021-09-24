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
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.domovedov.entities.local.StoryFullScreenModel
import com.domovedov.ru.R
import com.domovedov.ru.noRippleClickable
import com.domovedov.ru.ui.home.picturesList

@ExperimentalFoundationApi
@Composable
fun StoriesFullScreenView() {

    val storyFullScreenModel = StoryFullScreenModel(
        "Story title", "This is description",
        picturesList
    )
    StoriesFullScreen(storyFullScreenModel)
}

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun StoriesFullScreen(storyFullScreenModel: StoryFullScreenModel) {

    var pictureUrl by remember { mutableStateOf(storyFullScreenModel.pictureUrl[0]) }

    ConstraintLayout {
        val (storyProgress, closeIcon) = createRefs()

        Box(
            Modifier
                .fillMaxSize()
                .background(Color.Red)
        ) {

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

        StoryTimeProgress(modifier = Modifier
            .fillMaxSize()
            .constrainAs(storyProgress) {
                top.linkTo(parent.top, margin = 30.dp)
            })

        Icon(painter = painterResource(
            id = R.drawable.ic_close
        ),
            contentDescription = "Close icon",
            Modifier
                .constrainAs(closeIcon) {
                    top.linkTo(storyProgress.bottom)
                    start.linkTo(parent.start)
                }
                .padding(top = 30.dp, start = 20.dp).size(30.dp)
        )
    }

}

@ExperimentalFoundationApi
@Composable
fun StoryTimeProgress(modifier: Modifier) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(5),
        modifier = modifier
    ) {
        items(5) {
            LazyRow {
                items(1) { item ->
                    Row(
                        Modifier
                            .fillParentMaxWidth()
                            .height(10.dp)) {
                        LinearProgressIndicator(
                            progress = 0.2f,
                            modifier = Modifier
                                .padding(4.dp)
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