package com.tneagu.recipeapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.tneagu.recipeapp.MainNavHost

@Composable
fun RecipeApp() {
    MainNavHost(navController = rememberNavController())
}