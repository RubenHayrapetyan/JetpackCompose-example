package com.domovedov.ru.ui.region

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.domovedov.ru.R

@Preview
@Composable
fun RegionChooseHouseScreenPreview(){
    RegionChooseHouseScreen()
}

@Composable
fun RegionChooseHouseScreen(){
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (bigText, smallText, button) = createRefs()

        val guideLineFromTop = createGuidelineFromTop(0.1f)
        val guideLineFromBottom = createGuidelineFromBottom(0.15f)

        Text(
            text = stringResource(id = R.string.skoro_tut_budet_marketplace),
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
            text = stringResource(id = R.string.no_uje_seychas_mi_proveryaem),
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

        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.blue)),
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(button) {
                    bottom.linkTo(guideLineFromBottom)
                }
                .padding(start = 20.dp, end = 20.dp)
                .clip(RoundedCornerShape(50.dp))

        ) {
            Text(
                text = stringResource(id = R.string.vibrat_dom),
                fontWeight = FontWeight.W800,
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
            )
        }
    }
}