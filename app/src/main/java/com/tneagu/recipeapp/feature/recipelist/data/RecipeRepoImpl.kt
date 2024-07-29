package com.tneagu.recipeapp.feature.recipelist.data

import com.tneagu.recipeapp.core.data.model.Recipe
import com.tneagu.recipeapp.feature.recipelist.domain.repo.RecipeRepo
import javax.inject.Inject

class RecipeRepoImpl @Inject constructor(
    val api: RecipeApi
): RecipeRepo {
    override suspend fun getAll(): List<Recipe> {
        val apiResult = try {
            api.getRecipes()
        } catch (e: Exception){
            return emptyList()
        }

        return apiResult.results.map {
            it.toRecipe()
        }
    }

    override suspend fun getRecipe(id: String): Recipe {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: String): Boolean {
        TODO("Not yet implemented")
    }
}