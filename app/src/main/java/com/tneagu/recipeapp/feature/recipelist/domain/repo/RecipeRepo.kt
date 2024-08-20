package com.tneagu.recipeapp.feature.recipelist.domain.repo

import androidx.paging.PagingData
import com.tneagu.recipeapp.core.data.model.Recipe
import kotlinx.coroutines.flow.Flow

interface RecipeRepo {

    fun getAll(): Flow<PagingData<Recipe>>

    suspend fun getRecipe(id: String): Recipe

    suspend fun delete(id: String): Boolean
}