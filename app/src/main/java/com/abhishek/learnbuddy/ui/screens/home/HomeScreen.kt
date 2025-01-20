package com.abhishek.learnbuddy.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.content.MediaType.Companion.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.abhishek.learnbuddy.R


@Composable
fun HomeScreen(navController: NavController) {
    val textFieldState = rememberTextFieldState()
    var expanded by rememberSaveable { mutableStateOf(false) }

    var searchQuery by rememberSaveable { mutableStateOf("") }

    Column {
        // Search Bar
        SearchBarInputField(
            query = searchQuery,
            onQueryChanged = { searchQuery = it }
        )
        // Content
        BannerBoard()
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.TopStart
        ) {
            Column {
                Text(
                    text = "Courses",
                    fontSize = 24.sp,
                    modifier = Modifier.padding(16.dp)
                )
                CourseList(
                    subjects = getSubjects().filter {
                        it.subjectName.contains(searchQuery, ignoreCase = true) // Filter based on query
                    }
                )
            }
        }
    }



}

@Composable
fun SearchBarInputField(query: String, onQueryChanged: (String) -> Unit) {
    androidx.compose.material3.TextField(
        value = query,
        onValueChange = onQueryChanged,
        placeholder = {
            Text(text = "Search courses...")
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        singleLine = true
    )
}

@Composable
fun BannerBoard() {
    Card(
        elevation = CardDefaults.elevatedCardElevation(10.dp),
        shape = CardDefaults.elevatedShape,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(200.dp)
            .clickable { }
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = stringResource(id = R.string.app_name),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f) // Take all available space in the Column
            )
            Text(
                text = "Banner Board",
                fontSize = 16.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun CourseList(subjects: List<SubjectDM>) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(subjects) { subject ->
            CourseCardView(
                subjectName = subject.subjectName,
                subjectImage = subject.subjectImage,
                language = subject.language,
                chapter = subject.chapter
            )
        }
    }
}

@Composable
fun CourseCardView(subjectName: String, subjectImage: Int, language: String, chapter: String) {
    Card(
        elevation = CardDefaults.elevatedCardElevation(10.dp),
        shape = CardDefaults.elevatedShape,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(200.dp)
            .clickable { }
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = subjectName,
                fontSize = 16.sp,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(bottom = 8.dp)
            )
            Image(
                painter = painterResource(id = subjectImage),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f) // Take all available space
            )
            Box(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Language: $language",
                    fontSize = 12.sp,
                    modifier = Modifier.align(Alignment.BottomStart)
                )
                Text(
                    text = "Chapters: $chapter",
                    fontSize = 12.sp,
                    modifier = Modifier.align(Alignment.BottomEnd)
                )
            }
        }
    }
}


data class SubjectDM(
    val subjectName: String,
    val subjectImage: Int,
    val language: String,
    val chapter: String
)
fun getSubjects(): List<SubjectDM>{
    val result = mutableListOf<SubjectDM>()
    result.add(SubjectDM("Subject 1", R.drawable.ic_launcher_foreground, "Hindi, English", "15"))
    result.add(SubjectDM("Subject 2", R.drawable.ic_launcher_foreground, "Hindi, English", "15"))
    result.add(SubjectDM("Subject 3", R.drawable.ic_launcher_foreground, "Hindi, English", "15"))
    result.add(SubjectDM("Subject 4", R.drawable.ic_launcher_foreground, "Hindi, English", "15"))
    result.add(SubjectDM("Subject 5", R.drawable.ic_launcher_foreground, "Hindi, English", "15"))
    result.add(SubjectDM("Subject 6", R.drawable.ic_launcher_foreground, "Hindi, English", "15"))
    return result
}
