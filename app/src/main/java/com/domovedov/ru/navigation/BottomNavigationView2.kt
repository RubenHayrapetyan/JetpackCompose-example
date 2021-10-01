//package com.domovedov.ru.navigation
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.selection.selectableGroup
//import androidx.compose.material.BottomNavigationItem
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.zIndex
//
//@Preview
//@Composable
//fun vvv(){
//    dddd()
//}
//
//@Composable
//fun dddd(){
//    BoxWithConstraints(
//        modifier = Modifier
//            .fillMaxWidth()
//            .wrapContentHeight()
//            .background(Color.Transparent)
//    ) {
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(56.dp)
//                .background(Color.White)
//                .align(Alignment.BottomCenter)
//        )
//        Row(
//            modifier = Modifier
//                .zIndex(56.dp.value)
//                .fillMaxWidth()
//                .selectableGroup(),
//            horizontalArrangement = Arrangement.SpaceBetween,
//        ) {
//            items.forEach { item ->
//                val selected = item == currentSection
//
//                BottomNavigationItem(
//                    modifier = Modifier
//                        .align(Alignment.Bottom)
//                        .then(
//                            Modifier.height(
//                                if (item == HomeSection.SCAN) 84.dp else 56.dp
//                            )
//                        ),
//                    selected = selected,
//                    icon = {
//                        if (item == HomeSection.SCAN) {
//                            ScanButton(navController = navController, visible = true)
//                        } else {
//                            ImageBottomBar(
//                                icon = if (selected) item.iconOnSelected else item.icon,
//                                description = stringResource(id = item.title)
//                            )
//                        }
//                    },
//                    label = {
//                        Text(
//                            text = stringResource(item.title),
//                            color = if (selected) Color(0xFF361DC0) else LocalContentColor.current.copy(
//                                alpha = LocalContentAlpha.current
//                            ),
//                            style = TextStyle(
//                                fontFamily = RavierFont,
//                                fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal,
//                                fontSize = 12.sp,
//                                lineHeight = 18.sp,
//                            ),
//                            maxLines = 1,
//                        )
//                    },
//                    onClick = {
//                        if (item.route != currentRoute && item != HomeSection.SCAN) {
//                            navController.navigate(item.route) {
//                                launchSingleTop = true
//                                restoreState = true
//                                popUpTo(findStartDestination(navController.graph).id) {
//                                    saveState = true
//                                }
//                            }
//                        }
//                    }
//                )
//            }
//        }
//    }
//}