package com.example.composeanimation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.getValue
import com.example.composeanimation.util.MainActions

@Composable
fun Animatable(actions: MainActions) {
    val ok by remember {
        mutableStateOf(true)
    }
    val color = remember { androidx.compose.animation.Animatable(Color.Gray) }
    LaunchedEffect(ok) {
        color.animateTo(if (ok) Color.Green else Color.Red)
    }
    Box(
        Modifier
            .fillMaxSize()
            .background(color.value))
}