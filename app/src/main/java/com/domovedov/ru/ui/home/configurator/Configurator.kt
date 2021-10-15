package com.domovedov.ru.ui.home.configurator

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.domovedov.entities.local.DeliveryLocalModel
import com.domovedov.entities.local.FacadeLocalModel
import com.domovedov.entities.local.FoundationLocalModel
import com.domovedov.ru.*
import com.domovedov.ru.R
import com.domovedov.ru.navigation.Screen

@ExperimentalMaterialApi
@Preview
@Composable
fun ConfiguratorScreenPreview() {

    val navController = rememberNavController()
    ConfiguratorScreen(navController)
}

@ExperimentalMaterialApi
@Composable
fun ConfiguratorScreen(navController: NavController) {

    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 45.dp)
    ) {

        Image(
            modifier = Modifier
                .padding(start = 20.dp)
                .noRippleClickable {
                    navController.popBackStack()
                },
            painter = painterResource(id = R.drawable.ic_back_black_arrow),
            contentDescription = "Back arrow"
        )

        Spacer(modifier = Modifier.padding(top = 45.dp))

        ConstraintLayout(
            Modifier
                .verticalScroll(ScrollState(0))
        ) {
            val (configuratorTitle, configuratorDescription,
                callImg, foundation, facade, delivery, exactCoast) = createRefs()

            Text(
                modifier = Modifier
                    .constrainAs(configuratorTitle) {
                        // top.linkTo(backArrow.bottom)
                    }
                    .padding(start = 20.dp),
                text = stringResource(id = R.string.configurator),
                fontSize = 27.sp,
                fontWeight = FontWeight.W800,
                color = Color.Black
            )

            Image(
                modifier = Modifier
                    .constrainAs(callImg) {
                        top.linkTo(parent.top)
                        bottom.linkTo(configuratorTitle.bottom)
                        end.linkTo(parent.end)
                    }
                    .noRippleClickable {
                        navController.navigate(Screen.ContactsBottomSheet.route)
                    }
                    .padding(end = 30.dp, top = 45.dp),
                painter = painterResource(id = R.drawable.ic_call),
                contentDescription = "Back arrow"
            )

            Text(
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(top = 10.dp, start = 20.dp, end = 80.dp)
                    .constrainAs(configuratorDescription) {
                        top.linkTo(configuratorTitle.bottom)
                        start.linkTo(parent.start)
                    }
                    .fillMaxWidth(),
                text = stringResource(id = R.string.sformirovali_konfiguraciyu_no),
                fontSize = 16.sp,
                fontWeight = FontWeight.W600,
                color = Color.Black
            )

            FoundationRow(
                modifier = Modifier
                    .padding(top = 45.dp)
                    .constrainAs(foundation) {
                        top.linkTo(configuratorDescription.bottom)
                        start.linkTo(parent.start)
                    },
                foundationLocalModel = foundationList
            )

            FacadeRow(
                modifier = Modifier
                    .padding(top = 35.dp)
                    .constrainAs(facade) {
                        top.linkTo(foundation.bottom)
                        start.linkTo(parent.start)
                    },
                facadeLocalModel = facadeList
            )

            DeliveryRow(
                modifier = Modifier
                    .padding(top = 35.dp)
                    .constrainAs(delivery) {
                        top.linkTo(facade.bottom)
                        start.linkTo(parent.start)
                    },
                deliveryLocalModel = deliveryList
            )

            ExactCoast(
                modifier = Modifier
                    .constrainAs(exactCoast) {
                        top.linkTo(delivery.bottom)
                    }
                    .fillMaxWidth()
                    .padding(top = 50.dp, start = 20.dp, end = 20.dp, bottom = 20.dp)
            )
        }
    }
}

@Composable
private fun FoundationRow(
    modifier: Modifier,
    foundationLocalModel: List<FoundationLocalModel>
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = stringResource(id = R.string.foundation),
            fontSize = 16.sp,
            fontWeight = FontWeight.W800,
            color = Color.Black,
            modifier = Modifier.padding(start = 20.dp)
        )

        Spacer(modifier = Modifier.padding(7.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(25.dp),
            contentPadding = PaddingValues(start = 20.dp, end = 20.dp)
        ) {
            items(foundationLocalModel.size) { item ->
                FoundationItem(
                    foundationLocalModel = foundationLocalModel[item]
                )
            }
        }
    }
}

@Composable
private fun FacadeRow(
    modifier: Modifier,
    facadeLocalModel: List<FacadeLocalModel>
) {
    var isSelectedState by remember { mutableStateOf(facadeLocalModel[0].isSelected) }

    Column(
        modifier = modifier,
    ) {
        Text(
            text = stringResource(id = R.string.facade),
            fontSize = 16.sp,
            fontWeight = FontWeight.W800,
            color = Color.Black,
            modifier = Modifier.padding(start = 20.dp)
        )

        Spacer(modifier = Modifier.padding(7.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(25.dp),
            contentPadding = PaddingValues(start = 20.dp, end = 20.dp)
        ) {
            items(facadeLocalModel.size) { item ->
                FacadeItem(
                    facadeLocalModel = facadeLocalModel[item]
                ) {
                    facadeLocalModel.forEach {
                        it.isSelected = false
                    }
                    isSelectedState = facadeLocalModel[item].isSelected

                }
            }
        }
    }
}

@Composable
private fun DeliveryRow(
    modifier: Modifier,
    deliveryLocalModel: List<DeliveryLocalModel>
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = stringResource(id = R.string.delivery),
            fontSize = 16.sp,
            fontWeight = FontWeight.W800,
            color = Color.Black,
            modifier = Modifier.padding(start = 20.dp)
        )

        Spacer(modifier = Modifier.padding(7.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(25.dp),
            contentPadding = PaddingValues(start = 20.dp, end = 20.dp)
        ) {
            items(deliveryLocalModel.size) { item ->
                DeliveryItem(
                    deliveryLocalModel = deliveryLocalModel[item]
                )
            }
        }
    }
}

@Composable
private fun ExactCoast(modifier: Modifier) {
    var price by remember {
        mutableStateOf(0)
    }

    ConstraintLayout(
        modifier = modifier.fillMaxWidth()
    ) {
        val (costRow, greyLine, mortgageRow, mortgageDescription, toggle,
            continueBtn, moreInfo
        ) = createRefs()

        Row(modifier = Modifier
            .constrainAs(costRow) {
                top.linkTo(parent.top)
            }
            .fillMaxWidth()
        ) {

            Column(
                modifier = Modifier
                    .weight(0.65f)
                    .fillMaxWidth()
            ) {

                Text(
                    textAlign = TextAlign.Start,
                    text = stringResource(id = R.string.tochnaya_stoimost),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W800,
                    color = Color.Black,
                    modifier = Modifier.padding(end = 10.dp)
                )

                Text(
                    text = stringResource(id = R.string.esli_chto_to_potrebuetsya),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W600,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(top = 5.dp, end = 2.dp)
                )
            }

            Text(
                textAlign = TextAlign.End,
                text = "4.600.000" + "R",
                fontSize = 20.sp,
                fontWeight = FontWeight.W800,
                color = Color.Black,
                modifier = Modifier.weight(0.35f)
            )
        }

        Divider(
            color = colorResource(id = R.color.grey2),
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp)
                .background(color = colorResource(id = R.color.grey2))
                .constrainAs(greyLine) {
                    top.linkTo(costRow.bottom)
                }
        )

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 25.dp)
            .constrainAs(mortgageRow) {
                top.linkTo(greyLine.bottom)
                start.linkTo(parent.start)
            }
        ) {
            Column(
                modifier = Modifier
                    .weight(0.65f)
                    .fillMaxWidth()

            ) {

                Text(
                    text = stringResource(id = R.string.need_mortgage),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W600,
                    color = Color.Black,
                    modifier = Modifier


                )

                Text(
                    text = stringResource(id = R.string.we_will_fill),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W600,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(top = 5.dp)
                )
            }

//            Switch(checked = false, onCheckedChange = {
//
//            },
//                modifier =
//                Modifier.weight(0.35f)
//            )
        }

        //--------------------

        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.blue)),
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(continueBtn) {
                    top.linkTo(mortgageRow.bottom)
                }
                .padding(top = 57.dp)
                .clip(RoundedCornerShape(50.dp))
        ) {
            Text(
                text = stringResource(id = R.string.continue_text),
                fontWeight = FontWeight.W800,
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
            )
        }

        Text(
            text = stringResource(id = R.string.more_info),
            fontWeight = FontWeight.W600,
            fontSize = 14.sp,
            color = colorResource(id = R.color.blue),
            modifier = Modifier
                .padding(top = 15.dp)
                .constrainAs(moreInfo) {
                    top.linkTo(continueBtn.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
    }
}