package com.example.composeanimation.util

import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.composeanimation.util.MainDestination.ANIMATABLE
import com.example.composeanimation.util.MainDestination.ANIMATE_VISIBILITY
import com.example.composeanimation.util.MainDestination.COLOR_AS_STATE
import com.example.composeanimation.util.MainDestination.CONTENT_SIZE
import com.example.composeanimation.util.MainDestination.CROSSFADE
import com.example.composeanimation.util.MainDestination.FLOAT_AS_STATE
import com.example.composeanimation.util.MainDestination.INFINITE_TRANSITION
import com.example.composeanimation.util.MainDestination.MAIN_SCREEN
import com.example.composeanimation.util.MainDestination.UPDATE_TRANSITION

class MainActions(navController: NavHostController) {
    val mainScreen: () -> Unit = { navController.navigate(MAIN_SCREEN) }
    val animatable: () -> Unit = { navController.navigate(ANIMATABLE) }
    val colorAsState: () -> Unit = { navController.navigate(COLOR_AS_STATE) }
    val floatAsState: () -> Unit = { navController.navigate(FLOAT_AS_STATE) }
    val contentSize: () -> Unit = { navController.navigate(CONTENT_SIZE) }
    val animatedVisibility: () -> Unit = { navController.navigate(ANIMATE_VISIBILITY) }
    val crossfade: () -> Unit = { navController.navigate(CROSSFADE) }
    val inifiniteTransition: () -> Unit = { navController.navigate(INFINITE_TRANSITION) }
    val updateTransition: () -> Unit = { navController.navigate(UPDATE_TRANSITION) }
}