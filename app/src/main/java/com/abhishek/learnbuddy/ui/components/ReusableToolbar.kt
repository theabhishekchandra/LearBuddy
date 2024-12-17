package com.abhishek.learnbuddy.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReusableToolbar(
    title: String,
    onNavigationClick: (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    titleStyle: TextStyle = MaterialTheme.typography.titleSmall.copy(color = Color.White)
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = titleStyle
            )
        },
        navigationIcon = ((if (onNavigationClick != null) {
            {
                IconButton(onClick = onNavigationClick) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack, // Use desired icon
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            }
        } else null)!!),
        actions = actions,
//        backgroundColor = backgroundColor,
//         = 4.dp
    )
}

