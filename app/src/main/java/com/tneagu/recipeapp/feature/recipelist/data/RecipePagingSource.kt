package com.tneagu.recipeapp.feature.recipelist.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.tneagu.recipeapp.core.data.model.Recipe
import kotlinx.coroutines.delay
import retrofit2.HttpException
import java.io.IOException

class RecipePagingSource(
    private val api: RecipeApi
) : PagingSource<Int, Recipe>() {

    companion object {
        private const val STARTING_KEY = 1
    }

    override fun getRefreshKey(state: PagingState<Int, Recipe>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Recipe> {
        val startKey = params.key ?: STARTING_KEY
        return try {
            val offset = startKey * params.loadSize
            val apiResponse = api.getRecipes(offset = offset, expectedResults = params.loadSize)

            val nextKey = if (apiResponse.results.isEmpty()) null else offset + 1
            LoadResult.Page(
                data = apiResponse.results.map { it.toRecipe() },
                prevKey = if (startKey == STARTING_KEY) null else startKey - 1,
                nextKey = nextKey
            )


        } catch (e: IOException) {
            return LoadResult.Error(e)
        } catch (httpException: HttpException) {
            return LoadResult.Error(httpException)
        }
    }
}