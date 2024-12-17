package com.abhishek.learnbuddy.ui.screens.noticeboard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.abhishek.learnbuddy.ui.navigation.ScreenNav

@Composable
fun NoticeBoard(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Notice Board",
            modifier = Modifier.clickable {
                navController.popBackStack()
            },
            color = Color.White
        )
    }
}
