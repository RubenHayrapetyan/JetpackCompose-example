package com.domovedov.ru.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.domovedov.ru.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlin.math.absoluteValue


@ExperimentalPagerApi
@ExperimentalCoilApi
@Composable
fun HomePicturesPager(selectedItemPictureList: List<String>) {

    val pagerState = rememberPagerState(
        pageCount = selectedItemPictureList.size,
        // We increase the offscreen limit, to allow pre-loading of images
        initialOffscreenLimit = 2,
    )
    var _pageIndex = 0

    Box(Modifier.fillMaxSize()) {

        Column(Modifier.fillMaxSize()) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.weight(1f)
            ) { pageIndex ->
                _pageIndex = pagerState.currentPage
                Box(
                    modifier = Modifier
                        .graphicsLayer {
                            // Calculate the absolute offset for the current page from the
                            // scroll position. We use the absolute value which allows us to mirror
                            // any effects for both directions
                            val pageOffset = calculateCurrentOffsetForPage(pageIndex).absoluteValue

                            // We animate the scaleX + scaleY, between 85% and 100%
                            lerp(
                                start = 1f,
                                stop = 1f,
                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
                            ).also { scale ->
                                scaleX = scale
                                scaleY = scale
                            }
                        }
                        .fillMaxWidth(),
                    //   shape = RoundedCornerShape(24.dp),
                ) {

                    val pictures = picturesList[pageIndex]
                    Image(
                        painter = rememberImagePainter(pictures),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )
                }
            }
        }
        LazyRow(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 5.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            items(selectedItemPictureList.size) { item ->

                Spacer(
                    modifier = Modifier
                        .size(5.dp)
                        .clip(CircleShape)
                        .background(
                            color =
                            if (_pageIndex == item) colorResource(id = R.color.white)
                            else colorResource(id = R.color.grey_gradient_70_percent)
                        ),
                )
                Spacer(modifier = Modifier.padding(5.dp))
            }
        }
    }
}


@ExperimentalPagerApi
@ExperimentalCoilApi
@Preview
@Composable
fun HomePicturesPagerPreview() {
    Surface(color = MaterialTheme.colors.background) {
        HomePicturesPager(picturesList)
    }
}