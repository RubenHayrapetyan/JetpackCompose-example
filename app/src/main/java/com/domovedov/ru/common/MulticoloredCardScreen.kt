package com.domovedov.ru.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.domovedov.ru.R
import com.domovedov.ru.montBold
import com.domovedov.ru.montRegular

@Preview
@Composable
fun MulticoloredCardRowPreview(){
  //  MulticoloredCardRow()
}

@Composable
fun MulticoloredCardRow(modifier: Modifier){
    MulticoloredCardItem(modifier)
}

@Composable
fun MulticoloredCardItem(modifier: Modifier){
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .height(383.dp)
            .width(299.dp)
    ) {
        ConstraintLayout(Modifier
            .background(Color.Blue)
            .padding(top = 35.dp, bottom = 47.dp, start = 30.dp, end = 30.dp)
        ) {
            val (title, description, nextArrow) = createRefs()

            Text(
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .constrainAs(title) {
                        top.linkTo(parent.top)
                    }
                    .fillMaxWidth(),
                text = stringResource(id = R.string.sformirovali_konfiguraciyu_no),
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
                    }
                    .fillMaxWidth(),
                text = "bla bla bla bla  bla bla bla  bla bla bla  bla bla bla  bla bla bla" +
                        " bla bla bla  bla bla bla  bla bla bla  bla bla bla  bla bla bla",
                fontSize = 14.sp,
                fontWeight = FontWeight.W600,
                fontFamily = montRegular(),
                color = Color.Black
            )

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