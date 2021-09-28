package com.domovedov.ru.ui.favorites

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.domovedov.ru.R

@Composable
fun NoFavoritesScreen() {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (bigText, smallText, bigFavoriteImage) = createRefs()

        val guideLineFromTop = createGuidelineFromTop(0.1f)

        Text(
            text = stringResource(id = R.string.poka_tut_pusto),
            fontSize = 27.sp,
            fontWeight = FontWeight.W800,
            color = Color.Black,
            modifier = Modifier
                .constrainAs(bigText) {
                    top.linkTo(guideLineFromTop)
                    start.linkTo(parent.start)
                }
                .padding(start = 20.dp, end = 20.dp)
        )

        Text(
            text = stringResource(id = R.string.najimayte_na_flajok_kartochki),
            fontSize = 16.sp,
            fontWeight = FontWeight.W600,
            color = Color.Black,
            modifier = Modifier
                .constrainAs(smallText) {
                    top.linkTo(bigText.bottom)
                    start.linkTo(parent.start)
                }
                .padding(start = 20.dp, end = 20.dp, top = 15.dp)
        )

        Image(painter = painterResource(
            id = R.drawable.ic_big_favorite
        ),
            contentDescription = "Big favorite image",
            modifier = Modifier
                .constrainAs(bigFavoriteImage) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
    }
}

@Preview
@Composable
fun NoFavoritesScreenPreview() {
    NoFavoritesScreen()
}