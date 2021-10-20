package com.domovedov.ru.ui.home.housecard.item

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.domovedov.entities.local.PeculiaritiesLocalModel
import com.domovedov.ru.montBold
import com.domovedov.ru.montRegular
import com.domovedov.ru.peculiaritiesList


@Composable
private fun PeculiaritiesItem(peculiaritiesLocalModel: PeculiaritiesLocalModel){
    Column(
        modifier = Modifier.width(290.dp)
    ){
        Text(
            text = peculiaritiesLocalModel.title,
            fontFamily = montBold(),
            fontWeight = FontWeight.W800,
            color = Color.Black,
            fontSize = 16.sp
        )
        
        Spacer(modifier = Modifier.padding(5.dp))

        Text(
            text = peculiaritiesLocalModel.description,
            fontFamily = montRegular(),
            fontWeight = FontWeight.W600,
            color = Color.Black,
            fontSize = 14.sp
        )
    }
}

@Composable
fun PeculiaritiesRow(modifier: Modifier){
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        contentPadding = PaddingValues(start = 20.dp, end = 20.dp)
    ) {
        items(peculiaritiesList.size) { item ->
            PeculiaritiesItem(peculiaritiesLocalModel = peculiaritiesList[item])
        }
    }
}