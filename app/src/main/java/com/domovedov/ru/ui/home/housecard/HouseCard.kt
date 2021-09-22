package com.domovedov.ru.ui.home.housecard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

//@ExperimentalMaterialApi
//@Composable
//fun HouseCard(){
////    val bottomState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
////    ModalBottomSheetLayout(
////        sheetState = bottomState,
////        sheetShape = MaterialTheme.shapes.large,
////    ){}
//}

@ExperimentalMaterialApi
@Preview
@Composable
fun HoseCardPreview(){
    HouseCard()
}


@ExperimentalMaterialApi
@Composable
fun HouseCard() {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )
    val coroutineScope = rememberCoroutineScope()
    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetShape = MaterialTheme.shapes.large,
        sheetContent = {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Color.Blue)
            ) {
                Text(text = "Hello from sheet")
            }
        }, sheetPeekHeight = 100.dp
    ) {
        coroutineScope.launch {

            if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                bottomSheetScaffoldState.bottomSheetState.expand()
            } else {
                bottomSheetScaffoldState.bottomSheetState.collapse()
            }
        }
    }
}