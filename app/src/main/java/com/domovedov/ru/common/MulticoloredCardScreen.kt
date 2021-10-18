package com.domovedov.ru.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.domovedov.entities.local.MulticoloredCardLocalModel
import com.domovedov.ru.R
import com.domovedov.ru.montBold
import com.domovedov.ru.montRegular
import com.domovedov.ru.multicoloredCardLocalModel

@Preview
@Composable
fun MulticoloredCardRowPreview(){
    MulticoloredCardRowList(modifier = Modifier.fillMaxSize())
}

@ExperimentalCoilApi
@Composable
private fun MulticoloredCardItem(multicoloredCardLocalModel: MulticoloredCardLocalModel){
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .height(383.dp)
            .width(299.dp)
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = rememberImagePainter(multicoloredCardLocalModel.backgroundImgUrl),
            contentDescription = "Back arrow",
            contentScale = ContentScale.FillBounds
        )

        ConstraintLayout(
            Modifier
                .padding(top = 35.dp, bottom = 47.dp, start = 30.dp, end = 30.dp)
                .fillMaxSize()
        ) {
            val (title, description, nextArrow) = createRefs()

            Text(
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .constrainAs(title) {
                        top.linkTo(parent.top)
                    }
                    .fillMaxWidth(),
                text = multicoloredCardLocalModel.title,
                fontSize = 23.sp,
                fontWeight = FontWeight.W800,
                fontFamily = montBold(),
                color = Color.Black
            )

            Text(
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .verticalScroll(ScrollState(0))
                    .constrainAs(description) {
                        start.linkTo(parent.start)
                        top.linkTo(title.bottom)
                        bottom.linkTo(nextArrow.top)
                        height = Dimension.fillToConstraints
                    }
                    .fillMaxSize(),
                text = multicoloredCardLocalModel.description,
                fontSize = 14.sp,
                fontWeight = FontWeight.W600,
                fontFamily = montRegular(),
                color = Color.Black
            )

            if (multicoloredCardLocalModel.nextArrowVisibility){
                Image(
                    modifier = Modifier
                        .constrainAs(nextArrow) {
                            bottom.linkTo(parent.bottom)
                            end.linkTo(parent.end)
                        },
                    painter = painterResource(id = R.drawable.ic_oval_with_arrow),
                    contentDescription = "Back arrow"
                )
            }
        }
    }
}

@Composable
fun MulticoloredCardRowList(modifier: Modifier){
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(25.dp),
        contentPadding = PaddingValues(start = 20.dp, end = 20.dp)
    ) {
        items(multicoloredCardLocalModel.size) { item ->
            MulticoloredCardItem(multicoloredCardLocalModel[item])
        }
    }
}