package com.domovedov.ru.ui.home

import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.widget.TextView
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.domovedov.entities.local.HomeItemLocalModel
import com.domovedov.ru.R
import com.google.accompanist.pager.ExperimentalPagerApi


private val clickEvent = {}

@ExperimentalPagerApi
@Composable
fun HomeItemMain(
    homeItemModel: HomeItemLocalModel,
    onClick: () -> Unit
) {
    Box(Modifier.fillMaxSize()){
      //  Icon(painter = painterResource(id = R.drawable.), contentDescription = )

        Column(
            Modifier.fillMaxSize()
        ) {
            Row(
                Modifier
                    .weight(0.7f)
                    .fillMaxWidth()

            ) {
                HomePicturesPager(selectedItemPictureList = homeItemModel.homeIcon)
            }
            Row(
                Modifier
                    .weight(0.3f)
                    .fillMaxWidth()
                    .background(color = Color.White)
            ) {
                Description(homeItemModel){
                    onClick.invoke()
                }
            }
        }
    }
}

@Composable
fun Dot(){
    Box(
        modifier = Modifier
            .size(25.dp)
            .clip(CircleShape)
            .background(Color.Red)
    )
}

@Composable
private fun Description(homeItemModel: HomeItemLocalModel, onClick: () -> Unit) {
    val font = FontFamily(Font(R.font.mont_heavy, FontWeight.SemiBold))
    val fontSize = 12.sp
    val blackColor = Color.Black
    Column(
        Modifier
            .fillMaxWidth()
            .clickable { onClick.invoke() }
            .padding(start = 20.dp, end = 20.dp),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            val homeName =
                if (homeItemModel.name.length > 17) homeItemModel.name.dropLast(3) + "..."
                else homeItemModel.name
            Text(text = homeName, fontFamily = font, fontSize = fontSize, color = blackColor)

            Spacer(modifier = Modifier.padding(12.dp))

            Icon(
                painter = painterResource(id = R.drawable.ic_point),
                contentDescription = "Point icon"
            )

            Spacer(modifier = Modifier.padding(12.dp))

            Text(text = homeItemModel.size, fontFamily = font, fontSize = fontSize, color = blackColor)

            Spacer(modifier = Modifier.padding(12.dp))

            Icon(
                painter = painterResource(id = R.drawable.ic_point),
                contentDescription = "Point icon"
            )
            Spacer(modifier = Modifier.padding(12.dp))

            Text(text = homeItemModel.price, fontFamily = font, fontSize = fontSize, color = blackColor)


        }
        Row() {
            val description =
                if (homeItemModel.description.length > 50 &&
                    homeItemModel.description.contains("...")
                ) {
                    homeItemModel.description
                } else homeItemModel.description
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = colorResource(id = R.color.black),
                            fontSize = 20.sp
                        )
                    ) {
                        append(homeItemModel.descriptionBlackName)
                        append(description)
                    }
                },
                maxLines = 2

            )
        }
    }
}

fun makeTextViewResizable(tv: TextView, maxLine: Int, expandText: String) {
    if (tv.tag == null) {
        tv.tag = tv.text
    }
    val vto = tv.viewTreeObserver
    vto.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            val obs = tv.viewTreeObserver
            obs.removeGlobalOnLayoutListener(this)
            if (maxLine <= 0) {
                val lineEndIndex = tv.layout.getLineEnd(0)
                val text = tv.text.subSequence(0, lineEndIndex - expandText.length + 1)
                    .toString() + " " + expandText
                tv.text = text
            } else if (tv.lineCount >= maxLine) {
                val lineEndIndex = tv.layout.getLineEnd(maxLine - 1)
                val text = tv.text.subSequence(0, lineEndIndex - expandText.length + 1)
                    .toString() + " " + expandText
                tv.text = text
            }
        }
    })
}

private fun addMoreTextToEndOfTheText(descriptionText: String, maxLine: Int): String {
    if (maxLine >= 2) return "$descriptionText more"
    else return descriptionText
}

@ExperimentalPagerApi
@Preview
@Composable
fun HomeItemMainPreview() {
    HomeItemMain(homeItemModel = HomeItemLocalModel(
        picturesList,
        false,
        "Клееный брус 3",
        "BLYSKÄR 33",
        " Недавно Проект–Сервис запустил линейку домов из " +
                "клееного бруса. Отличительной чертой",
        "110 м2",
        "2,4-6 млн ₽"
    ), clickEvent)
}