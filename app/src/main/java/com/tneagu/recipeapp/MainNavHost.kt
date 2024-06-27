package com.tneagu.recipeapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.tneagu.recipeapp.feature.recipelist.presentation.RECIPE_LIST_ROUTE
import com.tneagu.recipeapp.feature.recipelist.presentation.recipeListScreen

@Composable
fun MainNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = RECIPE_LIST_ROUTE,
    ) {
        recipeListScreen(onRecipeClick = {})
    }
}