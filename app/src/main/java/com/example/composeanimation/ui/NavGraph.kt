package com.example.composeanimation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeanimation.ui.CrossFadeAnimation
import com.example.composeanimation.ui.UpdateTransition
import com.example.composeanimation.util.MainActions
import com.example.composeanimation.util.MainDestination.ANIMATABLE
import com.example.composeanimation.util.MainDestination.ANIMATE_VISIBILITY
import com.example.composeanimation.util.MainDestination.COLOR_AS_STATE
import com.example.composeanimation.util.MainDestination.CONTENT_SIZE
import com.example.composeanimation.util.MainDestination.CROSSFADE
import com.example.composeanimation.util.MainDestination.FLOAT_AS_STATE
import com.example.composeanimation.util.MainDestination.INFINITE_TRANSITION
import com.example.composeanimation.util.MainDestination.MAIN_SCREEN
import com.example.composeanimation.util.MainDestination.UPDATE_TRANSITION

@ExperimentalAnimationApi
@Composable
fun NavGraph(startDestination: String = MAIN_SCREEN) {
    val navController = rememberNavController()
    val actions = remember(navController) { MainActions(navController) }
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MAIN_SCREEN) {
            MainScreen(actions)
        }
        composable(ANIMATABLE) { Animatable(actions) }
        composable(COLOR_AS_STATE) { AnimateColorAsState(actions) }
        composable(FLOAT_AS_STATE) { AnimateFloatAsState(actions) }
        composable(ANIMATE_VISIBILITY) { AnimateVisibilityAnimation(actions) }
        composable(CONTENT_SIZE) { AnimateContentSize() }
        composable(CROSSFADE) { CrossFadeAnimation(actions) }
        composable(INFINITE_TRANSITION) { InifiniteTransition(actions) }
        composable(UPDATE_TRANSITION) {
            UpdateTransition(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        vertical = 20.dp
                    ), actions
            )
        }
    }
}