package com.tneagu.recipeapp.feature.recipelist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tneagu.recipeapp.core.data.model.Recipe
import com.tneagu.recipeapp.feature.recipelist.presentation.model.RecipeListScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor() : ViewModel() {

    private val _screenState =
        MutableStateFlow<RecipeListScreenState>(RecipeListScreenState.Loading)
    val screenState: StateFlow<RecipeListScreenState> = _screenState.asStateFlow()

    init {
        viewModelScope.launch {
            fetchRecipes()
        }
    }

    private suspend fun fetchRecipes() {
        delay(2000)

        val recipes = listOf(
            Recipe("1", "Recipe 1"),
            Recipe("2", "Recipe 2"),
        )

        // Update the screen state based on the fetched recipes
        _screenState.value = if (recipes.isEmpty()) {
            RecipeListScreenState.Empty
        } else {
            RecipeListScreenState.Success(recipes)
        }
    }
}