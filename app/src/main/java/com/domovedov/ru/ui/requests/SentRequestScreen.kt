package com.domovedov.ru.ui.requests

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.domovedov.ru.R
import com.domovedov.ru.montBold

@Preview
@Composable
fun SentRequestScreenPreview(){
    SentRequestScreen()
}

@Composable
fun SentRequestScreen(){
    ConstraintLayout(
        Modifier
            .fillMaxSize()
            .verticalScroll(ScrollState(0))
            .padding(bottom = 20.dp)
    ) {
        val (
            mainTitle, smallFavoriteImg, callImg, closeOvalImg,
            smallTitleAndSize, description, peculiarities, peculiaritiesRow,
            housePictures, priceTitle, priceDescription, price,
            configuratorBtn, moreInfo
        ) = createRefs()

        val guideLineFromTop = createGuidelineFromTop(0.05f)

        Text(
            text = "BLYSKÄR",
            fontSize = 27.sp,
            fontWeight = FontWeight.W800,
            fontFamily = montBold(),
            color = Color.Black,
            modifier = Modifier
                .constrainAs(mainTitle) {
                    top.linkTo(closeOvalImg.top)
                    bottom.linkTo(closeOvalImg.bottom)
                }
                .padding(start = 20.dp),
        )

        Image(
            painter = painterResource(id = R.drawable.ic_small_favorite),
            contentDescription = "Small favorite",
            modifier = Modifier
                .constrainAs(smallFavoriteImg) {
                    top.linkTo(mainTitle.top)
                    bottom.linkTo(mainTitle.bottom)
                    start.linkTo(mainTitle.end)
                }
                .padding(start = 12.dp),
        )
    }
}