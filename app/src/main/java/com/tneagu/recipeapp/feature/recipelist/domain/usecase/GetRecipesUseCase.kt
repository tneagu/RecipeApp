package com.tneagu.recipeapp.feature.recipelist.domain.usecase

import androidx.paging.PagingData
import com.tneagu.recipeapp.core.data.model.Recipe
import com.tneagu.recipeapp.feature.recipelist.domain.repo.RecipeRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRecipesUseCase @Inject constructor(
    private val recipeRepository: RecipeRepo
) {

    fun execute(): Flow<PagingData<Recipe>> = recipeRepository.getAll()

}