package com.example.composeanimation

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeanimation.util.MainActions

@ExperimentalAnimationApi
@Composable
fun AnimateVisibilityAnimation(actions: MainActions) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(colorResource(id = R.color.light_purple)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var editable by remember { mutableStateOf(true) }
        AnimatedVisibility(visible = editable) {
            Text(
                text = "Animated Visibility Animation",
                modifier = Modifier.padding(16.dp),
                color = colorResource(id = R.color.dark_purple),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }

        Button(
            onClick = { editable = !editable },
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(text = "Animate")
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun AnimatedVisibilityTransition() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(colorResource(id = R.color.light_purple)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var editable by remember { mutableStateOf(true) }
        AnimatedVisibility(
            visible = editable,
            enter = slideInVertically(initialOffsetY = { -40 })
                    + expandVertically(expandFrom = Alignment.Top)
                    + fadeIn(initialAlpha = 0.3f),
            exit = slideOutVertically()
                    + shrinkVertically()
                    + fadeOut()
        ) {
            Text(
                text = "Animated Visibility Animation",
                modifier = Modifier.padding(16.dp),
                color = colorResource(id = R.color.dark_purple),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }

        Button(
            onClick = { editable = !editable },
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(text = "Animate")
        }
    }
}