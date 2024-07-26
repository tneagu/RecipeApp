package com.tneagu.recipeapp

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.tneagu.recipeapp.feature.recipelist.presentation.RECIPE_LIST_ROUTE
import com.tneagu.recipeapp.feature.recipelist.presentation.recipeListScreen

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        NavHost(
            navController = navController,
            startDestination = RECIPE_LIST_ROUTE,
        ) {
            recipeListScreen(onRecipeClick = {})
        }
    }
}