package com.domovedov.ru.ui.home.housecard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.domovedov.ru.R
import kotlinx.coroutines.launch

//@ExperimentalMaterialApi
//@Preview
//@Composable
//fun HoseCardPreview() {
//   // HouseCard()
//}


@ExperimentalMaterialApi
@Composable
fun HouseCard(modalBottomSheetValue: ModalBottomSheetValue) {

    val bottomState = rememberModalBottomSheetState(modalBottomSheetValue)

    ModalBottomSheetLayout(
        sheetState = bottomState,
        sheetShape = MaterialTheme.shapes.large,
        sheetContent = {
            Scaffold(
                topBar = {
                         TopAppBar(Modifier.background(Color.Transparent)) {
                             
                         }
                },
                content = { innerPadding ->
                    ConstraintLayout(Modifier.fillMaxSize()) {
                        val (title, smallFavoriteImg, callImg, closeOvalImg
                        ) = createRefs()

                        val guideLineFromTop = createGuidelineFromTop(0.05f)

                        Text(
                            text = "BLYSKÄR",
                            fontSize = 27.sp,
                            fontWeight = FontWeight.W800,
                            color = Color.Black,
                            modifier = Modifier
                                .constrainAs(title) {
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
                                    top.linkTo(title.top)
                                    bottom.linkTo(title.bottom)
                                    start.linkTo(title.end)
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
                                .padding(end = 15.dp),
                        )

                    }
                }
            )

        },
//        sheetPeekHeight = 200.dp
    ) {



//        coroutineScope.launch {
//
//            if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
//                bottomSheetScaffoldState.bottomSheetState.expand()
//            } else {
//                bottomSheetScaffoldState.bottomSheetState.collapse()
//            }
//        }
    }
}