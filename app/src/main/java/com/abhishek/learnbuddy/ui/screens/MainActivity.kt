package com.abhishek.learnbuddy.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.core.view.WindowCompat
import com.abhishek.learnbuddy.ui.navigation.AppNavigation
import com.abhishek.learnbuddy.ui.theme.LearnBuddyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge rendering
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            LearnBuddyTheme {
                AppNavigation() // Set up navigation here
            }
        }
    }
}
