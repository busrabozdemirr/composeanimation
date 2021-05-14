package com.example.composeanimation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeanimation.util.MainActions

@Composable
fun MainScreen(actions: MainActions) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            MyButton("AnimateVisibityAnimation", actions.animatedVisibility)
            MyButton("Animatable", actions.animatable)
            MyButton("AnimateColorAsState", actions.colorAsState)
            MyButton("AnimateFloatAsState", actions.floatAsState)
            MyButton("AnimateContentSize", actions.contentSize)
            MyButton("CrossfadeAnmation", actions.crossfade)
            MyButton("RememberInfiniteTransion", actions.inifiniteTransition)
            MyButton("UpdataTransition", actions.updateTransition)
        }
    }
}

@Composable
fun MyButton(title: String, actions: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(start = 16.dp, top = 16.dp)
    ) {
        Text(
            text = title,
            fontSize = 18.sp,

            )
        Spacer(modifier = Modifier.size(20.dp))
        Button(
            onClick = { actions() }

        ) {
            Text(text = "Go")
        }
    }
    Spacer(modifier = Modifier.size(20.dp))
}