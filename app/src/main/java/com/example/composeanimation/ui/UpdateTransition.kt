package com.example.composeanimation.ui

import androidx.compose.animation.core.animateOffset
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.composeanimation.util.MainActions
import com.example.composeanimation.R

private enum class BoxPosition {
    TopRight,
    TopLeft,
    BottomRight,
    BottomLeft
}

@Composable
fun UpdateTransition(
    modifier: Modifier = Modifier,
    actions: MainActions
) {
    var boxPosition by remember { mutableStateOf(BoxPosition.TopLeft) }
    val transition = updateTransition(targetState = boxPosition)

    val boxOffset by transition.animateOffset(
        transitionSpec = {
            tween(durationMillis = 1_000)
        }
    ) { position ->
        when (position) {
            BoxPosition.TopLeft -> Offset(0F, 0F)
            BoxPosition.BottomRight -> Offset(80F, 80F)
            BoxPosition.TopRight -> Offset(60F, 0F)
            BoxPosition.BottomLeft -> Offset(0F, 40F)
        }
    }

    Surface(modifier = modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                modifier = Modifier.padding(top = 20.dp, bottom = 30.dp),
                onClick = {
                    boxPosition = getNextPosition(boxPosition)
                }
            ) {
                Text("Update")
            }
            Box(
                modifier = Modifier
                    .background(colorResource(id = R.color.dark_purple))
                    .size(150.dp)
            ) {
                Box(
                    modifier = Modifier
                        .offset(boxOffset.x.dp, boxOffset.y.dp)
                        .size(30.dp)
                        .background(colorResource(id = R.color.light_purple))
                )
            }
        }
    }
}

private fun getNextPosition(position: BoxPosition) =
    when (position) {
        BoxPosition.TopLeft -> BoxPosition.BottomRight
        BoxPosition.BottomRight -> BoxPosition.TopRight
        BoxPosition.TopRight -> BoxPosition.BottomLeft
        BoxPosition.BottomLeft -> BoxPosition.TopLeft
    }
