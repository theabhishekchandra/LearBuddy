package com.abhishek.learnbuddy.ui.navigation

sealed class ScreenNav(val route: String) {
    object HomeScreen : ScreenNav("home")
    object Search : ScreenNav("search")
    object Settings : ScreenNav("settings")
    object NoticeBoard : ScreenNav("notice_board")
    object LessonPlan : ScreenNav("lesson_plan")
    object Notes : ScreenNav("notes")
    object Assignments : ScreenNav("assignments")


}