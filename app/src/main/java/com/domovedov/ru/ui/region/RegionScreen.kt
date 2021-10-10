package com.domovedov.ru.ui.region

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.domovedov.ru.ui.home.housecard.HouseCardBottomSheet
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun RegionScreen() {
    val bottomState = rememberModalBottomSheetState(ModalBottomSheetValue.Expanded)

    OpenBottomSheet(modalBottomSheetValue = bottomState.currentValue)
}

@Composable
@ExperimentalMaterialApi
private fun OpenBottomSheet(modalBottomSheetValue: ModalBottomSheetValue){
    HouseCardBottomSheet(modalBottomSheetValue = modalBottomSheetValue)
}

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Preview
@Composable
fun RegionScreenPreview(){
    RegionScreen()
}




