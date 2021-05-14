package com.example.composeanimation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composeanimation.util.MainActions

@Composable
fun AnimateColorAsState(actions: MainActions) {

    var state by remember { mutableStateOf(false) }

    val startColor = Color.Blue
    val endColor = Color.Green

    val backgroundColor by animateColorAsState(
        targetValue = if (state) endColor else startColor,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 200),
            repeatMode = RepeatMode.Reverse
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(bottom = 8.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimationButton(onValueChanged = { currState ->
            state = currState
        }, state = state)
    }
}

@Composable
fun AnimationButton(onValueChanged: (Boolean) -> Unit, state: Boolean) {
    Button(
        onClick = { onValueChanged(!state) },
        modifier = Modifier
            .height(50.dp)
            .width(100.dp)
            .padding(top = 10.dp),
        content = {
            Text(text = "Animate", color = Color.White)
        })
}