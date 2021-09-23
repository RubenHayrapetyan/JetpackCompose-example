package com.domovedov.ru.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.domovedov.entities.local.HomeFilterLocalModel
import com.domovedov.ru.R
import com.domovedov.ru.noRippleClickable

@Preview
@Composable
fun FilterDefaultPreview() {
    FilterTypesView(filter = HomeFilterLocalModel(1, "вахверк", false))
}

@Composable
fun FilterTypesView(filter: HomeFilterLocalModel) {

    var selectedTypeIndex by remember {
        mutableStateOf(filter.isSelected)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .noRippleClickable {
                filter.isSelected = !filter.isSelected
                selectedTypeIndex = filter.isSelected
            }
            .clip(RoundedCornerShape(50.dp))
            .border(
                width = 1.dp,
                color = colorResource(
                    id =
                    if (!selectedTypeIndex) R.color.light_grey
                    else R.color.transparent
                ),
                shape = CircleShape
            )
            .background(
                if (filter.isSelected) colorResource(id = R.color.blue)
                else colorResource(id = R.color.transparent)
            )


    ) {
        Text(
            text = filter.text,
            color =
            if (filter.isSelected) colorResource(id = R.color.white)
            else colorResource(id = R.color.black),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(
                    start = 17.dp,
                    end = 17.dp,
                    top = 9.dp,
                    bottom = 9.dp
                )
        )

    }
}