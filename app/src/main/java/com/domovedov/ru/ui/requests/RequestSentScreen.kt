package com.domovedov.ru.ui.requests

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.domovedov.ru.R

@Preview
@Composable
fun RequestSentScreenPreview(){
    RequestSentScreen()
}

@Composable
fun RequestSentScreen(){

    Column(
        Modifier.fillMaxSize().padding(start = 45.dp, end = 45.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_big_tick),
            contentDescription = "Small favorite",
        )
        
        Spacer(modifier = Modifier.padding(top = 28.dp))

        Text(
            text = stringResource(id = R.string.zayavka_otpravlena),
            fontWeight = FontWeight.W800,
            fontSize = 27.sp
        )

        Spacer(modifier = Modifier.padding(top = 15.dp))


        Text(
            text = stringResource(id = R.string.nam_potrebuetsya_nemnogo),
            fontWeight = FontWeight.W600,
            fontSize = 16.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 25.dp, end = 25.dp)
            )

        Spacer(modifier = Modifier.padding(top = 40.dp))


        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.blue)),
            onClick = { },
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .clip(RoundedCornerShape(50.dp))
        ) {
            Text(
                text = stringResource(id = R.string.pereyti_v_sdelku),
                fontWeight = FontWeight.W800,
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
            )
        }
    }
}