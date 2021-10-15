package com.domovedov.ru.ui.home.housecard

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.domovedov.ru.*
import com.domovedov.ru.R
import com.domovedov.ru.activities.MainActivity
import com.domovedov.ru.navigation.Screen
import com.domovedov.ru.common.HomePicturesPager
import com.domovedov.ru.ui.home.housecard.item.PeculiaritiesRow
import com.domovedov.ru.ui.home.picturesList
import com.domovedov.ru.ui.theme.DomovedovTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@ExperimentalCoilApi
@ExperimentalPagerApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Preview
@Composable
fun HoseCardDialogPreview() {
    val navController = rememberNavController()
    HouseCard(navController)
}

@ExperimentalCoilApi
@ExperimentalPagerApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun HouseCard(navController: NavController) {

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
                .background(colorResource(id = R.color.grey_status_bar))
        ) {}

        Card(
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.grey_status_bar))
        ) {
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
                        .padding(start = 20.dp, top = 25.dp),
                    fontFamily = montBold(),
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
                        .padding(start = 20.dp, end = 20.dp, top = 12.dp),
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

                PeculiaritiesRow(modifier = Modifier
                    .padding(top = 17.dp)
                    .constrainAs(peculiaritiesRow) {
                        top.linkTo(peculiarities.bottom)
                        start.linkTo(parent.start)
                    }
                )

                Box(
                    modifier = Modifier
                        .height(326.dp)
                        .fillMaxWidth()
                        .padding(top = 35.dp)
                        .constrainAs(housePictures) {
                            top.linkTo(peculiaritiesRow.bottom)
                            start.linkTo(parent.start)
                        }
                ) {

                    HomePicturesPager(selectedItemPictureList = picturesList)
                }

                Text(
                    text = stringResource(id = R.string.price_text),
                    modifier = Modifier
                        .constrainAs(priceTitle) {
                            top.linkTo(housePictures.bottom)
                            start.linkTo(parent.start)
                        }
                        .padding(start = 20.dp, top = 25.dp),
                    fontFamily = montBold(),
                    fontWeight = FontWeight.W800,
                    color = Color.Black,
                    fontSize = 20.sp
                )

                Text(
                    text = "3,5 - 6 млн. ₽",
                    modifier = Modifier
                        .constrainAs(price) {
                            top.linkTo(housePictures.bottom)
                            end.linkTo(parent.end)
                        }
                        .padding(end = 20.dp, top = 25.dp),
                    fontFamily = montBold(),
                    fontWeight = FontWeight.W800,
                    color = Color.Black,
                    fontSize = 20.sp
                )

                Text(
                    text = stringResource(id = R.string.exact_price_is_in_configurator),
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .constrainAs(priceDescription) {
                            top.linkTo(priceTitle.bottom)
                            start.linkTo(priceTitle.start)
                        }
                        .padding(top = 4.dp, start = 20.dp),
                    fontFamily = montRegular(),
                    fontWeight = FontWeight.W600,
                    color = Color.Black,
                    fontSize = 10.sp
                )

                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.blue)),
                    onClick = {
                        navController.navigate(Screen.ConfiguratorScreen.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .constrainAs(configuratorBtn) {
                            top.linkTo(priceDescription.bottom)
                        }
                        .padding(top = 40.dp, start = 20.dp, end = 20.dp)
                        .clip(RoundedCornerShape(50.dp))
                ) {
                    Text(
                        text = stringResource(id = R.string.configurator),
                        fontWeight = FontWeight.W800,
                        fontFamily = montBold(),
                        fontSize = 16.sp,
                        color = Color.White,
                        modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
                    )
                }

                Text(
                    text = stringResource(id = R.string.more_info),
                    fontWeight = FontWeight.W600,
                    fontFamily = montRegular(),
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.blue),
                    modifier = Modifier
                        .padding(top = 17.dp)
                        .constrainAs(moreInfo) {
                            top.linkTo(configuratorBtn.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                )
            }

        }
    }

}