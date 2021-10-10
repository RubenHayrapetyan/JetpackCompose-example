package com.domovedov.ru.ui.home.housecard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.domovedov.ru.R
import com.domovedov.ru.noRippleClickable

@ExperimentalMaterialApi
@Composable
fun HouseCardBottomSheet(modalBottomSheetValue: ModalBottomSheetValue){
    val bottomState = rememberModalBottomSheetState(modalBottomSheetValue)
    //val bottomState = rememberModalBottomSheetState(ModalBottomSheetValue.Expanded)


    ModalBottomSheetLayout(
        sheetState = bottomState,
        sheetShape = MaterialTheme.shapes.large,
        sheetContent = {

            ConstraintLayout(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.9f)
                    .background(Color.White)
                    .padding(top = 30.dp)
                    .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                //   .requiredWidth(LocalConfiguration.current.screenWidthDp.dp * 1f)
            ) {
                val (mainTitle, smallFavoriteImg, callImg, closeOvalImg,
                    smallTitle, size,
                ) = createRefs()

                val guideLineFromTop = createGuidelineFromTop(0.05f)

                Text(
                    text = "BLYSKÄR",
                    fontSize = 27.sp,
                    fontWeight = FontWeight.W800,
                    color = Color.Black,
                    modifier = Modifier
                        .constrainAs(mainTitle) {
                            top.linkTo(closeOvalImg.top)
                            bottom.linkTo(closeOvalImg.bottom)
                        }
                        .padding(start = 20.dp)
                    ,
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
                            // navController.navigate(Screen.ContactsBottomSheet.route)
                        }
                    ,
                )
            }
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