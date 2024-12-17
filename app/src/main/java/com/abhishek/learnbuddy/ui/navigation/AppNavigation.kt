package com.abhishek.learnbuddy.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abhishek.learnbuddy.ui.screens.home.HomeScreen
import com.abhishek.learnbuddy.ui.screens.noticeboard.NoticeBoard

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ScreenNav.HomeScreen.route
    ) {
        composable(ScreenNav.HomeScreen.route) {
            HomeScreen(navController) // Navigate to Home Screen
        }
        composable(ScreenNav.NoticeBoard.route) {
            NoticeBoard(navController) // Navigate to NoticeBoard
        }
    }
}
