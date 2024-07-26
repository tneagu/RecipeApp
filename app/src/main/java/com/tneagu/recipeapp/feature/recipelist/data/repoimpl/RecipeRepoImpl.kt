package com.tneagu.recipeapp.feature.recipelist.data.repoimpl

import com.tneagu.recipeapp.core.data.model.Recipe
import com.tneagu.recipeapp.feature.recipelist.domain.repo.RecipeRepo
import javax.inject.Inject

class RecipeRepoImpl @Inject constructor(
    val api: RecipeApi
): RecipeRepo {
    override suspend fun getAll(): List<Recipe> {
        TODO("Not yet implemented")
    }

    override suspend fun getRecipe(id: String): Recipe {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: String): Boolean {
        TODO("Not yet implemented")
    }
}