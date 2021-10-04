package com.domovedov.ru.ui.home.configurator

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconToggleButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.domovedov.entities.local.DeliveryLocalModel
import com.domovedov.entities.local.FacadeLocalModel
import com.domovedov.entities.local.FoundationLocalModel
import com.domovedov.ru.R

@Preview
@Composable
fun ConfiguratorScreenPreview() {
    ConfiguratorScreen()
}

@Composable
fun ConfiguratorScreen() {

    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 45.dp, bottom = 22.5.dp)) {

        Image(
            modifier = Modifier
                .padding(start = 20.dp),
            painter = painterResource(id = R.drawable.ic_back_black_arrow),
            contentDescription = "Back arrow"
        )

        ConstraintLayout(
            Modifier
                .verticalScroll(ScrollState(0))
        ) {
            val ( configuratorTitle, configuratorDescription,
                callImg, foundation, facade, delivery, exactCoast) = createRefs()

            Text(
                modifier = Modifier
                    .constrainAs(configuratorTitle) {
                        // top.linkTo(backArrow.bottom)
                    }
                    .padding(top = 22.5.dp, start = 20.dp),
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
                    .padding(end = 30.dp, top = 45.dp),
                painter = painterResource(id = R.drawable.ic_call),
                contentDescription = "Back arrow"
            )

            Text(
                modifier = Modifier
                    .constrainAs(configuratorDescription) {
                        top.linkTo(configuratorTitle.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(callImg.start)
                    }
                    .padding(top = 10.dp, end = 10.dp, start = 20.dp)
                ,
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
                    .constrainAs(exactCoast){
                        top.linkTo(delivery.bottom)
                        start.linkTo(parent.start)
                    }
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
                )
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
private fun ExactCoast(modifier: Modifier){

    ConstraintLayout(modifier = modifier
        .padding(top = 50.dp, start = 20.dp, end = 20.dp, bottom = 20.dp)
    ) {
        val (costTitle, cost, costDescription, greyLine,
            mortgageTitle, mortgageDescription, toggle) = createRefs()

        Text(
            text = stringResource(id = R.string.tochnaya_stoimost),
            fontSize = 20.sp,
            fontWeight = FontWeight.W800,
            color = Color.Black,
            modifier = Modifier
                .constrainAs(costTitle) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(cost.start)
                }
                .padding(end = 10.dp)
        )

        Text(
            text = "4.600.000" + "R",
            fontSize = 20.sp,
            fontWeight = FontWeight.W800,
            color = Color.Black,
            modifier = Modifier
                .constrainAs(cost){
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
        )

        Text(
            text = stringResource(id = R.string.esli_chto_to_potrebuetsya),
            fontSize = 12.sp,
            fontWeight = FontWeight.W600,
            color = Color.Black,
            modifier = Modifier
                .constrainAs(costDescription){
                    top.linkTo(costTitle.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(cost.start)
                }
                .padding(top = 5.dp, end = 2.dp)
        )
        
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .padding(top = 25.dp)
                .background(color = colorResource(id = R.color.grey2))
                .constrainAs(greyLine) {
                    top.linkTo(costDescription.bottom)
                }
        ) {}

        Text(
            text = stringResource(id = R.string.need_mortgage),
            fontSize = 14.sp,
            fontWeight = FontWeight.W600,
            color = Color.Black,
            modifier = Modifier
                .constrainAs(mortgageTitle) {
                    top.linkTo(greyLine.bottom)
                    start.linkTo(parent.start)
                }
                .padding(top = 25.dp)
        )

        Text(
            text = stringResource(id = R.string.we_will_fill),
            fontSize = 12.sp,
            fontWeight = FontWeight.W600,
            color = Color.Black,
            modifier = Modifier
                .constrainAs(mortgageDescription) {
                    top.linkTo(mortgageTitle.bottom)
                    start.linkTo(parent.start)
                }
                .padding(top = 5.dp)
        )
        
        IconToggleButton(checked = false, onCheckedChange = {

        },
        modifier = Modifier.constrainAs(toggle){
            top.linkTo(mortgageTitle.top)
            bottom.linkTo(mortgageDescription.bottom)
            end.linkTo(parent.end)
        }
        ) {
            
        }
    }
}