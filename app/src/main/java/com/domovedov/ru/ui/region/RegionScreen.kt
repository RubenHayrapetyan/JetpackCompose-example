package com.domovedov.ru.ui.region

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun RegionScreen() {

    Box(Modifier.fillMaxSize()) {
        MyLazyTest()
    }
}

val textList = listOf("text 1 ", "text 2", "text 3")

@Composable
private fun MyLazyTest(){
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(50.dp)
    ){
        items(5){ item->
            Column(Modifier.fillParentMaxSize()) {
               // MYTEEEEST()
            }
        }
    }
}



@ExperimentalPagerApi
@Preview
@Composable
fun RegionScreenPreview(){
    RegionScreen()
}




