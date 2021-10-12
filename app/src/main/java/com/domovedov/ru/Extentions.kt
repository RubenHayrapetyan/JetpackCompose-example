package com.domovedov.ru

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily

@SuppressLint("UnnecessaryComposedModifier")
inline fun Modifier.noRippleClickable(crossinline onClick: ()->Unit): Modifier = composed {
    clickable(indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick()
    }
}

fun montRegular() = FontFamily(Font(R.font.mont_regular))
fun montSemiBold() = FontFamily(Font(R.font.mont_semi_bold))
fun montBold() = FontFamily(Font(R.font.mont_bold))
