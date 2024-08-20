package com.tneagu.recipeapp.feature.recipelist.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.tneagu.recipeapp.core.data.model.Recipe
import com.tneagu.recipeapp.feature.recipelist.domain.repo.RecipeRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RecipeRepoImpl @Inject constructor(
    private val api: RecipeApi
) : RecipeRepo {
    override fun getAll(): Flow<PagingData<Recipe>> {
        return Pager(
            config = PagingConfig(pageSize = 10, enablePlaceholders = false),
            pagingSourceFactory = { RecipePagingSource(api) }
        ).flow
    }

    override suspend fun getRecipe(id: String): Recipe {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: String): Boolean {
        TODO("Not yet implemented")
    }
}