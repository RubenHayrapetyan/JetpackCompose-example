package com.domovedov.ru.ui.favorites

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import com.domovedov.entities.local.HomeItemLocalModel
import com.domovedov.ru.R
import com.domovedov.ru.montBold
import com.domovedov.ru.ui.home.HomeItemMain
import com.domovedov.ru.ui.home.homeItemLocalModel
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.launch

@ExperimentalCoilApi
@ExperimentalMaterialApi
@ExperimentalPagerApi
@Preview
@Composable
fun FavoritesScreenPreview(){
    FavoritesScreen()
}

@ExperimentalCoilApi
@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun FavoritesScreen(){
    Column(modifier = Modifier
        .fillMaxSize()) {

        Spacer(modifier = Modifier.padding(top = 50.dp))
        
        Text(
            text = stringResource(id = R.string.favorite),
            color = Color.Black,
            fontSize = 27.sp,
            fontWeight = FontWeight.W800,
            fontFamily = montBold(),
            modifier = Modifier.padding(start = 20.dp)
        )

        Spacer(modifier = Modifier.padding(top = 40.dp))

        HomeItems(homeItemLocalModel) {
            Log.i("clickTest", "Clicked")
        }
    }
}

@ExperimentalCoilApi
@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
private fun HomeItems(
    homeItemsList: List<HomeItemLocalModel>,
    onClick: () -> Unit){
    val listState = rememberLazyListState()

    LazyColumn(
        state = listState,
        verticalArrangement = Arrangement.spacedBy(30.dp),
    ){
        itemsIndexed(items = homeItemsList) { index, item ->
            Column(
                if (index == homeItemsList.lastIndex){
                Modifier.padding(bottom = 90.dp)
            }else{
                Modifier.padding(0.dp)
                }

            ) {
                HomeItemMain(homeItemsList[index]) {
                    onClick.invoke()
                }
            }
        }
    }
}

