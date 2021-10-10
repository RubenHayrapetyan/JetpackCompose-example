package com.domovedov.ru.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.domovedov.entities.local.HomeFilterLocalModel
import com.domovedov.entities.local.HomeItemLocalModel
import com.domovedov.entities.local.StoryLocalModel
import com.domovedov.ru.R
import com.domovedov.ru.navigation.Screen
import com.domovedov.ru.ui.home.housecard.HouseCardBottomSheet
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Preview
@Composable
fun MainPreview() {
    val navController = rememberNavController()
    HomeScreen(navController = navController)
}

val storiesList = listOf(
    StoryLocalModel("Экспертиза строительных работ", picturesList[0], false),
    StoryLocalModel("Дом BLYSKAR", picturesList[1], false),
    StoryLocalModel("Нас не просили, но мы сделали", picturesList[2], true),
    StoryLocalModel("Инстаграмный лестничный комплект", picturesList[3], true),
    StoryLocalModel("Story 5", picturesList[1], true)
)

val filters = listOf(
    HomeFilterLocalModel(1, "вахверк", false),
    HomeFilterLocalModel(2, "клееный брус", false),
    HomeFilterLocalModel(3, "газобетон", false),
    HomeFilterLocalModel(4, "газобетон2", false),
    HomeFilterLocalModel(5, "газобетон3", false)
)

val homeItemLocalModel = listOf(
    HomeItemLocalModel(
        picturesList,
        false,
        "Клееный брус",
        "BLYSKÄR",
        " Недавно Проект–Сервис запустил линейку домов из " +
                "клееного бруса. Отличительной чертой",
        "140 м2",
        "3,5-6 млн ₽"
    ),
    HomeItemLocalModel(
        picturesList2,
        false,
        "Клееный брус 2",
        "22 BLYSKÄR",
        " Недавно Проект–Сервис запустил линейку домов из " +
                "клееного бруса. Отличительной чертой",
        "160 м2",
        "4,5-6 млн ₽"
    ),
    HomeItemLocalModel(
        picturesList,
        false,
        "Клееный брус 3",
        "BLYSKÄR 33",
        " Недавно Проект–Сервис запустил линейку домов из " +
                "клееного бруса. Отличительной чертой",
        "110 м2",
        "2,4-6 млн ₽"
    )
)

@ExperimentalCoilApi
@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun HomeScreen(navController: NavController) {
    val bottomState = rememberModalBottomSheetState(ModalBottomSheetValue.Expanded)

    Box {

        Column(Modifier.fillMaxSize()) {

            Stories(storiesList = storiesList, navController = navController)

            Spacer(modifier = Modifier.padding(top = 35.dp))

            Text(
                text = stringResource(id = R.string.moskovskaya_oblast),
                fontSize = 27.sp,
                modifier = Modifier.padding(start = 20.dp),
                fontWeight = FontWeight(800).also { FontWeight.Bold }
            )

            Spacer(modifier = Modifier.padding(top = 30.dp))

            Filters(filters)

            Spacer(modifier = Modifier.padding(top = 26.dp))

            Text(
                text = "Клееный брус (15)",
                Modifier.padding(start = 20.dp),
                fontWeight = FontWeight(800).also { FontWeight.Bold },
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.padding(top = 18.dp))

            HomeItems(homeItemLocalModel) {

               // bottomState.show()
              //  navController.navigate(Screen.HouseCardBottomSheet.route)
            }
         //   OpenBottomSheet(bottomState.currentValue)
        }
    }
}

//@Composable
//@ExperimentalMaterialApi
//private fun OpenBottomSheet(modalBottomSheetValue: ModalBottomSheetValue){
//    HouseCardBottomSheet(modalBottomSheetValue = modalBottomSheetValue)
//}

@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
private fun Stories(storiesList: List<StoryLocalModel>, navController: NavController) {
    LazyRow(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.25f),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(start = 20.dp, top = 50.dp, end = 20.dp)
    ) {
        itemsIndexed(items = storiesList) { index, item ->
            Row(
                Modifier
                    .fillParentMaxHeight()
                    .fillParentMaxWidth(0.3f)
            ) {
                Story(storyResponseModel = item, navController = navController)
            }
        }
    }
}

@Composable
private fun Filters(filters: List<HomeFilterLocalModel>) {

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(start = 20.dp, end = 20.dp)
    ) {
        items(filters.size) { item ->
            FilterTypesView(filters[item])
        }
    }
}

@ExperimentalCoilApi
@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
private fun HomeItems(
    homeItemsList: List<HomeItemLocalModel>,
    onClick: () -> Unit
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(bottom = 30.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(homeItemsList.size) { item ->
            Column(Modifier.fillParentMaxSize()) {
                HomeItemMain(homeItemsList[item]) {
                    onClick.invoke()
                }
            }
        }
    }
}