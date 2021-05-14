package com.example.composeanimation

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AnimateContentSize() {
    val shortText = "What is Lorem Ipsum?"
    val longtext = "Lorem Ipsum is simply dummy text of the printing" +
            " and typesetting industry. Lorem Ipsum has been the" +
            " industry's standard dummy text ever since the 1500s," +
            " when an unknown printer took a galley of type and" +
            " scrambled it to make a type specimen book."

    var isShortText by remember { mutableStateOf(true) }

    Column(modifier = Modifier.padding(24.dp)) {
        Button(
            onClick = {
                isShortText = !isShortText
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Animate")
        }

        Box(
            modifier = Modifier
                .background(colorResource(id = R.color.light_purple))
                .padding(16.dp)
                .fillMaxWidth()
                .animateContentSize()
        ) {
            Text(
                text = if (isShortText) shortText else longtext,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.dark_purple)
            )
        }
    }
}