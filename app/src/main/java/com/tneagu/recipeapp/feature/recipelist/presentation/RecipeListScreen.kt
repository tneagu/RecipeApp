package com.tneagu.recipeapp.feature.recipelist.presentation

import RecipeItem
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.tneagu.recipeapp.feature.recipelist.presentation.model.RecipeListScreenState

@Composable
fun RecipeListRoute(
    onRecipeClick: () -> Unit,
    viewModel: RecipeListViewModel = hiltViewModel(),
) {
    val state by viewModel.screenState.collectAsState()
    RecipeListScreen(state = state)
}

@Composable
private fun RecipeListScreen(
    state: RecipeListScreenState
) {
    Box(modifier = Modifier.fillMaxSize()) {
        when (state) {
            is RecipeListScreenState.Loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            is RecipeListScreenState.Empty -> {
                // Show empty state message
            }

            is RecipeListScreenState.Success -> {
                // Display the list of recipes
                LazyColumn {
                    items(state.recipes) { recipe ->
                        RecipeItem(recipe = recipe)
                    }
                }
            }

            is RecipeListScreenState.Error -> {
                // Show error message
            }
        }
    }

}