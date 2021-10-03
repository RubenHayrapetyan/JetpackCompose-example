package com.domovedov.ru.ui.home.configurator

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.domovedov.entities.local.FoundationLocalModel
import com.domovedov.ru.R

@Composable
fun FoundationItem(
    foundationLocalModel: FoundationLocalModel
) {
    var isSelectedState by remember { mutableStateOf(foundationLocalModel.isSelected) }

    Box(
        Modifier
            .clip(RoundedCornerShape(20.dp))
            .width(315.dp)
            .background(
                colorResource(
                    id =
                    if (isSelectedState) R.color.light_pink
                    else R.color.transparent
                )
            )
            .clickable {
                foundationLocalModel.isSelected = !foundationLocalModel.isSelected
                isSelectedState = foundationLocalModel.isSelected
            }
        ,
    ) {
        ConstraintLayout(
            modifier = Modifier
                .padding(
                    top = 15.dp,
                    bottom = 15.dp,
                    start = 26.dp,
                    end = 15.dp
                )
        ) {
            val (title, description, tickImg) = createRefs()

            Text(
                textAlign = TextAlign.Start,
                text = foundationLocalModel.title,
                fontSize = 14.sp,
                fontWeight = FontWeight.W600,
                color = Color.Black,
                modifier = Modifier
                    .padding(end = 20.dp)
                    .constrainAs(title) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .fillMaxWidth()
            )

            Text(
                textAlign = TextAlign.Start,
                text = foundationLocalModel.description,
                fontSize = 12.sp,
                fontWeight = FontWeight.W600,
                color = Color.Black,
                modifier = Modifier
                    .padding(top = 5.dp, end = 20.dp)
                    .constrainAs(description) {
                        top.linkTo(title.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .fillMaxWidth()
            )
            if (isSelectedState){
                Image(
                    painter = painterResource(id = R.drawable.ic_small_blue_tick),
                    contentDescription = "Small blue tick",
                    modifier = Modifier.constrainAs(tickImg) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    }
                )
            }
        }
    }
}