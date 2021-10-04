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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.domovedov.entities.local.StoriesFullScreenModel
import com.domovedov.ru.R
import com.domovedov.ru.activities.MainActivity
import com.domovedov.ru.noRippleClickable
import com.domovedov.ru.ui.home.configurator.storiesList
import com.domovedov.ru.ui.home.picturesList
import org.koin.androidx.compose.getViewModel

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun StoriesFullScreenView(navController: NavController) {

    val vm = getViewModel<StoriesViewModel>()
    StoriesContent( vm, storiesList, navController)
}


@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
private fun StoriesContent(
    vm: StoriesViewModel,
    storiesFullScreenModel: List<StoriesFullScreenModel>,
    navController: NavController){


    var storyIndex by remember { mutableStateOf(0) }
    var pictureUrl = picturesList[storyIndex]
    val pictureListLength = storiesFullScreenModel.size



    ConstraintLayout {
        val (storyProgress, closeIcon, title, description) = createRefs()

        Box(
            Modifier.fillMaxSize()
        ) {
            Row {
                Column(
                    Modifier
                        .background(Color.Transparent)
                        .fillMaxSize()
                        .weight(1f)
                        .noRippleClickable {
                            if (storyIndex != 0) {
                                storyIndex--
                                pictureUrl = storiesFullScreenModel[storyIndex].pictureUrl
                            }
                        }) {
                }
                Column(
                    Modifier
                        .background(Color.Transparent)
                        .fillMaxSize()
                        .weight(1f)
                        .noRippleClickable {

                            if (storyIndex != pictureListLength - 1) {
                                Log.i("clickTest", "pictureIndex = $storyIndex")
                                Log.i("clickTest", "pictureListLength = $pictureListLength ")
                                storyIndex++
                                pictureUrl = storiesFullScreenModel[storyIndex].pictureUrl
                            }
                        }) {
                }
            }

            Image(
                painter = rememberImagePainter(pictureUrl),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }

        StoryTimeProgress(
            storiesFullScreenModel,
            vm = vm,
            modifier = Modifier
                .constrainAs(storyProgress) {
                    top.linkTo(parent.top, margin = 30.dp)
                },
            pictureListLength
        )

        Image(painter = painterResource(
            id = R.drawable.ic_close
        ),
            contentDescription = "Close icon",
            Modifier
                .constrainAs(closeIcon) {
                    top.linkTo(parent.top, margin = 60.dp)
                    start.linkTo(parent.start, margin = 20.dp)
                }
                .clickable {
                    navController.popBackStack()
                }
        )

        Text(
            text = storiesFullScreenModel[storyIndex].title,
            fontWeight = FontWeight.W800,
            fontSize = 30.sp,
            color = Color.White,
            modifier = Modifier
                .constrainAs(title) {
                    bottom.linkTo(description.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
        )

        val guideLineFromBottom = createGuidelineFromBottom(0.1f)

        Text(
            text = storiesFullScreenModel[storyIndex].description,
            fontWeight = FontWeight.W600,
            color = Color.White,
            fontSize = 18.sp,
            modifier = Modifier
                .constrainAs(description) {
                    bottom.linkTo(guideLineFromBottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(start = 20.dp, end = 20.dp)
        )
    }
}

@ExperimentalFoundationApi
@Composable
fun StoryTimeProgress(
    storiesFullScreenModel: List<StoriesFullScreenModel>,
    vm: StoriesViewModel,
    modifier: Modifier,
    storyCount: Int
) {
    val seconds = 10L
    vm.startAndInitTimer(seconds)
    val timer: Long by vm.timer.observeAsState(0L)
    var progressState by remember {
        mutableStateOf(0f)
    }
    Log.i("timerValue", "timer = ${timer.toFloat() / 10000}")

    LazyVerticalGrid(
        cells = GridCells.Fixed(storyCount),
        modifier = modifier
    ) {
        items(storyCount) {
            LazyRow {
                items(1) { item ->
//                    storiesFullScreenModel[item].storyProgress = timer.toFloat() / seconds * 1000
//                    val temp = storiesFullScreenModel[item].storyProgress
//                    progressState = temp
                    Row(
                            Modifier
                                .fillParentMaxWidth()
                                .height(10.dp)
                    ) {
                        LinearProgressIndicator(
                            progress = timer.toFloat() / 10000,
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