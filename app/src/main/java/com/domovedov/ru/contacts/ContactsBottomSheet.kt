package com.domovedov.ru.contacts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.domovedov.ru.R

@ExperimentalMaterialApi
@Preview
@Composable
fun ContactsBottomSheetPreview() {
  //  ContactsBottomSheet()
}

@ExperimentalMaterialApi
@Composable
fun ContactsBottomSheet(modalBottomSheetValue: ModalBottomSheetValue) {
    val bottomState = rememberModalBottomSheetState(modalBottomSheetValue)

    ModalBottomSheetLayout(
        sheetState = bottomState,
        sheetShape = MaterialTheme.shapes.large,
        sheetContent = {

            Column(Modifier.padding(start = 20.dp, top = 40.dp, bottom = 40.dp)) {
                Row() {
                    Image(
                        painter = painterResource(id = R.drawable.ic_telegram),
                        contentDescription = "Telegram Img"
                    )
                    Text(
                        text = stringResource(id = R.string.write_via_telegram),
                        fontWeight = FontWeight.W600,
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.padding(top = 30.dp))

                Row() {
                    Image(
                        painter = painterResource(id = R.drawable.ic_whatsapp),
                        contentDescription = "Whatsapp Img"
                    )
                    Text(
                        text = stringResource(id = R.string.write_via_whatsapp),
                        fontWeight = FontWeight.W600,
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.padding(top = 30.dp))

                Row() {
                    Image(
                        painter = painterResource(id = R.drawable.ic_phone),
                        contentDescription = "Phone Img"
                    )
                    Text(
                        text = stringResource(id = R.string.write_via_phone),
                        fontWeight = FontWeight.W600,
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                }
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