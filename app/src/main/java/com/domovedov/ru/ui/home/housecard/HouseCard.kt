package com.domovedov.ru.ui.home.housecard

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.domovedov.ru.*
import com.domovedov.ru.R
import com.domovedov.ru.navigation.Screen

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Preview
@Composable
fun HoseCardDialogPreview() {
    val navController = rememberNavController()
    HouseCard(navController)
}

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun HouseCard(navController: NavController) {

    ConstraintLayout(
        Modifier
            .fillMaxSize()
            .padding(top = 30.dp)
            .verticalScroll(ScrollState(0))
//            .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
    ) {
        val (
            mainTitle, smallFavoriteImg, callImg, closeOvalImg,
            smallTitleAndSize, description, peculiarities, peculiaritiesRow
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

        Image(
            painter = painterResource(id = R.drawable.ic_close_with_oval),
            contentDescription = "Close with oval ",
            modifier = Modifier
                .constrainAs(closeOvalImg) {
                    top.linkTo(guideLineFromTop)
                    end.linkTo(parent.end)
                }
                .noRippleClickable {
                    navController.popBackStack()
                }
                .padding(end = 20.dp),
        )

        Image(
            painter = painterResource(id = R.drawable.ic_call),
            contentDescription = "Close with oval ",
            modifier = Modifier
                .constrainAs(callImg) {
                    top.linkTo(guideLineFromTop)
                    end.linkTo(closeOvalImg.start)
                }
                .padding(end = 15.dp)
                .noRippleClickable {
                    navController.navigate(Screen.ContactsBottomSheet.route)
                },
        )
        
        Text(
            text = "Фахверк | 147 м2",
            modifier = Modifier
                .constrainAs(smallTitleAndSize) {
                    top.linkTo(mainTitle.bottom)
                    start.linkTo(parent.start)
                }
                .padding(start = 20.dp),
            fontFamily = montSemiBold(),
            fontWeight = FontWeight.W800,
            color = Color.Black,
            fontSize = 20.sp
        )

        Text(
            text = com.domovedov.ru.description,
            modifier = Modifier
                .constrainAs(description) {
                    top.linkTo(smallTitleAndSize.bottom)
                    start.linkTo(parent.start)
                }
                .padding(start = 20.dp, top = 12.dp),
            fontFamily = montRegular(),
            fontWeight = FontWeight.W600,
            color = Color.Black,
            fontSize = 16.sp
        )

        Text(
            text = stringResource(id = R.string.peculiarities),
            modifier = Modifier
                .constrainAs(peculiarities) {
                    top.linkTo(description.bottom)
                    start.linkTo(parent.start)
                }
                .padding(start = 20.dp, top = 25.dp),
            fontFamily = montBold(),
            fontWeight = FontWeight.W800,
            color = Color.Black,
            fontSize = 20.sp
        )
    }

}

