package com.tneagu.recipeapp.feature.recipelist.presentation.model

import androidx.paging.PagingData
import com.tneagu.recipeapp.core.data.model.Recipe

sealed class RecipeListScreenState {

    data object Loading : RecipeListScreenState()

    data object Empty : RecipeListScreenState()

    data object Error : RecipeListScreenState()

    data class Success(val recipes: PagingData<Recipe>) : RecipeListScreenState()

}