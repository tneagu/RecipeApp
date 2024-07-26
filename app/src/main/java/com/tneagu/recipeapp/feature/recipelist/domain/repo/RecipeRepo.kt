package com.tneagu.recipeapp.feature.recipelist.domain.repo

import com.tneagu.recipeapp.core.data.model.Recipe

interface RecipeRepo {

    suspend fun getAll() : List<Recipe>

    suspend fun getRecipe(id: String) : Recipe

    suspend fun delete(id: String) : Boolean
}