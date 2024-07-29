package com.tneagu.recipeapp.feature.recipelist.domain.usecase

import com.tneagu.recipeapp.core.data.model.Recipe
import com.tneagu.recipeapp.feature.recipelist.domain.repo.RecipeRepo
import javax.inject.Inject

class GetRecipesUseCase @Inject constructor(
    private val recipeRepository: RecipeRepo
) {

    suspend fun execute(): List<Recipe> = recipeRepository.getAll()

}