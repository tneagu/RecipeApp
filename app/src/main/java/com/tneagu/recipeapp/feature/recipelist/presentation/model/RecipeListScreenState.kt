package com.tneagu.recipeapp.feature.recipelist.presentation.model

import com.tneagu.recipeapp.core.data.model.Recipe
import com.tneagu.recipeapp.feature.recipelist.presentation.RecipeListViewModel

sealed class RecipeListScreenState {

    data object Loading : RecipeListScreenState()

    data object Empty : RecipeListScreenState()

    data object Error : RecipeListScreenState()

    data class Success(val recipes: List<Recipe>) : RecipeListScreenState()

}