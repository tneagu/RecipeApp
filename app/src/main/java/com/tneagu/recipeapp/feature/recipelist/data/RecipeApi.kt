package com.tneagu.recipeapp.feature.recipelist.data

import com.tneagu.recipeapp.core.network.NetworkConstants
import com.tneagu.recipeapp.feature.recipelist.data.model.GetRecipeResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApi {

    /**
     * Docs: https://spoonacular.com/food-api/docs
     */
    @GET("recipes/complexSearch")
    suspend fun getRecipes(
        @Query("number") expectedResults: Int = 10,
        @Query("offset") offset: Int = 0,
        @Query("apiKey") apiKey: String = NetworkConstants.API_KEY,
    ): GetRecipeResponseDto
}