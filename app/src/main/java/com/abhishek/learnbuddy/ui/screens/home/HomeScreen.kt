package com.abhishek.learnbuddy.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun HomeScreen(navController: NavController) {
    val textFieldState = rememberTextFieldState()
    var expanded by rememberSaveable { mutableStateOf(false) }

    Column {
        BannerBoard()
        Box(
            modifier = Modifier
                .fillMaxSize(),
//                .clickable {
//                    navController.navigate(ScreenNav.NoticeBoard.route)
//                },
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Courses", fontSize = 24.sp)
        }

    }



}

@Composable
fun SearchBarInputField(){
    Text(text = "Search")
}

@Composable
fun BannerBoard(){
    Card(
        elevation = CardDefaults.elevatedCardElevation(10.dp),
        shape = CardDefaults.elevatedShape,
        modifier = Modifier
            .height(200.dp)
            .width(200.dp)
            .fillMaxSize()
            .clickable { }

    ) {
        Column() {
//            Image(imageVector = R.drawable.ic_launcher_foreground, contentDescription = "Image")
            Text(text = "Banner Board" , fontSize = 16.sp, modifier = Modifier.align(Alignment.End))
        }
    }
}
@Preview
@Composable
fun CourseCardView(){
    Card(
        elevation = CardDefaults.elevatedCardElevation(10.dp),
        shape = CardDefaults.elevatedShape,
        modifier = Modifier
            .height(200.dp)
            .width(200.dp)
            .fillMaxSize()
            .clickable { }

    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Banner Board" ,
                fontSize = 16.sp,
                modifier = Modifier
                    .align(Alignment.Start)
            )
            Text(text = "Banner Board" , fontSize = 16.sp, modifier = Modifier.align(Alignment.End))
//            Image(imageVector = R.drawable.ic_launcher_foreground, contentDescription = "Image")
//            Text(text = "Banner Board" , fontSize = 16.sp, modifier = Modifier.align(Alignment.End))
//            Text(text = "Banner Board" , fontSize = 16.sp, modifier = Modifier.align(Alignment.End))
        }
    }
}
