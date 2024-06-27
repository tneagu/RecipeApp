package com.tneagu.recipeapp.feature.recipelist.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun RecipeListRoute(
    onRecipeClick: () -> Unit,
    viewModel: RecipeListViewModel = hiltViewModel(),
){
    RecipeListScreen()
}

@Composable
private fun RecipeListScreen() {
    Text("Recipe List")
}