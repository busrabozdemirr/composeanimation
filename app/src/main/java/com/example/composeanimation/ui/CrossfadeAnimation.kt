package com.example.composeanimation.ui

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeanimation.util.MainActions

@Composable
fun CrossFadeAnimation(action: MainActions) {
    var currentPage by remember { mutableStateOf(PageList.A) }
    Column (){
        Row {
            PageList.values().forEach { pageList ->
                Button(
                    onClick = { currentPage = pageList },
                    Modifier
                        .weight(1f, true)
                        .height(80.dp)
                        .padding(10.dp)
                ) {
                    Text(pageList.name, modifier = Modifier.padding(top = 10.dp))
                }
            }
        }
        Crossfade(targetState = currentPage, animationSpec = tween(2000)) { screen ->
            when (screen) {
                PageList.A -> Text(
                    text = "Crossfade animation for ${PageList.A}",
                    modifier = Modifier.padding(16.dp),
                    fontSize = 24.sp
                )
                PageList.B -> Text(
                    text = "Crossfade animation for ${PageList.B}",
                    fontSize = 32.sp
                )
                PageList.C -> Text(text = "Crossfade animation for ${PageList.C}")
            }
        }
    }
}

enum class PageList() {
    A, B, C
}