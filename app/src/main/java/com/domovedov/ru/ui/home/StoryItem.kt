package com.domovedov.ru.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.domovedov.entities.local.StoryLocalModel
import com.domovedov.ru.R
import com.domovedov.ru.montRegular
import com.domovedov.ru.navigation.Screen

@ExperimentalMaterialApi
@ExperimentalCoilApi
@Preview
@Composable
fun StoriesPreview() {
    val storyLocalModel = StoryLocalModel(
        "Doma budut postroeni",
        pictureUrl = picturesList[0],
        false
    )
    val navController = rememberNavController()
    Story(storyLocalModel, navController)
}

@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun Story(storyResponseModel: StoryLocalModel, navController: NavController) {
    val font = FontFamily(Font(R.font.mont_regular))

    var isStoryWatched by remember {
        mutableStateOf(storyResponseModel.isStoryWatched)
    }

    Card(
        modifier = Modifier
            .fillMaxSize()
            .border(
                width = 1.dp,
                color = colorResource(
                    id = if (!isStoryWatched) R.color.blue
                    else R.color.transparent
                ),
                shape = RoundedCornerShape(10.dp)
            ),
        shape = RoundedCornerShape(10.dp),
        onClick = {
            storyResponseModel.isStoryWatched = true
            isStoryWatched = storyResponseModel.isStoryWatched
            navController.navigate(Screen.StoriesFullScreen.route)
        }
    ) {
        Box(Modifier.fillMaxSize()) {

            Image(
                painter = rememberImagePainter(storyResponseModel.pictureUrl),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )

            Text(
                modifier = Modifier
                    .wrapContentWidth()
                    .align(Alignment.BottomStart)
                    .padding(
                        start = 11.dp,
                        end = 11.dp,
                        bottom = 14.dp
                    ),
                text = storyResponseModel.title,
                color = colorResource(id = R.color.white),
                fontSize = 11.sp,
                fontWeight = FontWeight(600),
                fontFamily = montRegular()
            )
        }
    }
}