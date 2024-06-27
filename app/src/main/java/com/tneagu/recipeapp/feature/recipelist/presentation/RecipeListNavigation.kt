package com.tneagu.recipeapp.feature.recipelist.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val RECIPE_LIST_ROUTE = "recipeList"

fun NavGraphBuilder.recipeListScreen(
    onRecipeClick: () -> Unit,
) {
    composable(route = RECIPE_LIST_ROUTE) {
        RecipeListRoute(onRecipeClick = onRecipeClick)
    }
}