package com.domovedov.ru.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@ExperimentalFoundationApi
@Preview
@Composable
fun MyBottomNavigationPreview(){
    MyBottomNavigation()
}

@ExperimentalFoundationApi
@Composable
fun MyBottomNavigation(){

    LazyVerticalGrid(
        cells = GridCells.Fixed(5),
        modifier = Modifier
            .clip(
                RoundedCornerShape(
                    topStart = 25.dp,
                    topEnd = 25.dp
                )
            )
    ) {
        items(5) {
            LazyRow {
                items(1) { item ->
                    Text(
                        text = "102",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}

