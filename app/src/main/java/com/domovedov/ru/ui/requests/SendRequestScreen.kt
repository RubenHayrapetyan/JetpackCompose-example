package com.domovedov.ru.ui.requests

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.domovedov.ru.R
import com.domovedov.ru.common.MulticoloredCardRowList
import com.domovedov.ru.montBold
import com.domovedov.ru.montRegular
import com.domovedov.ru.navigation.Screen
import com.domovedov.ru.noRippleClickable

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
            backArrow, mainTitle, description, callImg, multicoloredCardRowList,
            nextSmallArrow, yourDealText, greyLine, whyDMV, phoneNumberField,
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
            fontFamily = montBold(),
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
                .padding(top = 10.dp, start = 20.dp)
                .constrainAs(description) {
                    top.linkTo(mainTitle.bottom)
                    start.linkTo(parent.start)
                    width = Dimension.fillToConstraints
                }
                .fillMaxWidth(),
            text = stringResource(id = R.string.your_deal_will),
            fontSize = 16.sp,
            fontWeight = FontWeight.W600,
            fontFamily = montRegular(),
            color = Color.Black
        )

        MulticoloredCardRowList(modifier = Modifier
            .constrainAs(multicoloredCardRowList) {
                top.linkTo(description.bottom)
                start.linkTo(parent.start)
            }
            .padding(top = 30.dp)
        )

        Text(
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(start = 20.dp, top = 40.dp)
                .constrainAs(yourDealText) {
                    top.linkTo(multicoloredCardRowList.bottom)
                    start.linkTo(parent.start)
                    width = Dimension.fillToConstraints
                }
                .fillMaxWidth(),
            text = stringResource(id = R.string.primer_otcheta),
            fontSize = 16.sp,
            fontWeight = FontWeight.W600,
            fontFamily = montRegular(),
            color = Color.Black
        )

        Image(
            modifier = Modifier
                .constrainAs(nextSmallArrow) {
                    top.linkTo(yourDealText.top)
                    bottom.linkTo(yourDealText.bottom)
                    end.linkTo(parent.end)
                    height = Dimension.fillToConstraints
                }
                .noRippleClickable {
                    navController.navigate(Screen.ContactsBottomSheet.route)
                }
                .padding(end = 20.dp, top = 40.dp),
            painter = painterResource(id = R.drawable.ic_next_small_arrow),
            contentDescription = "Back arrow"
        )

        Divider(
            color = colorResource(id = R.color.grey2),
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp, start = 20.dp, end = 20.dp)
                .background(color = colorResource(id = R.color.grey2))
                .constrainAs(greyLine) {
                    top.linkTo(yourDealText.bottom)
                }
        )

        Text(
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(start = 20.dp, top = 40.dp)
                .constrainAs(whyDMV) {
                    top.linkTo(greyLine.bottom)
                    start.linkTo(parent.start)
                    width = Dimension.fillToConstraints
                }
                .fillMaxWidth(),
            text = stringResource(id = R.string.why_dmv),
            fontSize = 20.sp,
            fontWeight = FontWeight.W800,
            fontFamily = montBold(),
            color = Color.Black
        )

        // --------------------------

        val textPhoneNumber = R.string.enter_your_phone
        var text by rememberSaveable { mutableStateOf("")}
        text = textPhoneNumber.toString()

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
                .constrainAs(phoneNumberField) {
                    top.linkTo(whyDMV.bottom)
                },
            value = text,
            onValueChange = {
                text = it
            },
//            fontSize = 20.sp,
//            fontWeight = FontWeight.W800,
//            fontFamily = montBold(),
//            color = Color.Black
        )

    }
}