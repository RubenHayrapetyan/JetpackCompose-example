package com.domovedov.ru.ui.requests

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.domovedov.ru.*
import com.domovedov.ru.R
import com.domovedov.ru.common.MulticoloredCardRow
import com.domovedov.ru.navigation.Screen

@Preview
@Composable
fun SendRequestScreenPreview() {
    val navController = rememberNavController()
    SendRequestScreen(navController)
}

@Composable
fun SendRequestScreen(navController: NavController) {
    ConstraintLayout(
        Modifier
            .verticalScroll(ScrollState(0))
    ) {
        val (
            backArrow, mainTitle, description, callImg, multicoloredCardRow,

        ) = createRefs()

        Image(
            modifier = Modifier
                .constrainAs(backArrow) {
                    top.linkTo(parent.top)
                }
                .padding(start = 20.dp, top = 70.dp)
                .noRippleClickable {
                    navController.popBackStack()
                },
            painter = painterResource(id = R.drawable.ic_back_black_arrow),
            contentDescription = "Back arrow"
        )

        Text(
            modifier = Modifier
                .constrainAs(mainTitle) {
                    top.linkTo(backArrow.bottom)
                }
                .padding(start = 20.dp, top = 42.dp),
            text = "BLYSKÄR",
            fontSize = 27.sp,
            fontWeight = FontWeight.W800,
            color = Color.Black
        )

        Image(
            modifier = Modifier
                .constrainAs(callImg) {
                    top.linkTo(backArrow.bottom)
                    bottom.linkTo(mainTitle.bottom)
                    end.linkTo(parent.end)
                }
                .noRippleClickable {
                    navController.navigate(Screen.ContactsBottomSheet.route)
                }
                .padding(end = 30.dp, top = 42.dp),
            painter = painterResource(id = R.drawable.ic_call),
            contentDescription = "Back arrow"
        )

        Text(
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(top = 10.dp, start = 20.dp, end = 80.dp)
                .constrainAs(description) {
                    top.linkTo(mainTitle.bottom)
                    start.linkTo(parent.start)
                }
                .fillMaxWidth(),
            text = stringResource(id = R.string.sformirovali_konfiguraciyu_no),
            fontSize = 16.sp,
            fontWeight = FontWeight.W600,
            color = Color.Black
        )

        MulticoloredCardRow(modifier = Modifier
            .constrainAs(multicoloredCardRow) {
                top.linkTo(description.bottom)
                start.linkTo(parent.start)
            }
            .padding(top = 30.dp)
        )
    }
}