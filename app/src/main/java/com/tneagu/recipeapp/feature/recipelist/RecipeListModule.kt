package com.tneagu.recipeapp.feature.recipelist

import com.tneagu.recipeapp.feature.recipelist.data.RecipeApi
import com.tneagu.recipeapp.feature.recipelist.data.RecipeRepoImpl
import com.tneagu.recipeapp.feature.recipelist.domain.repo.RecipeRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RecipeListModule {

    @Provides
    @Singleton
    fun provideRecipeApi(retrofit: Retrofit): RecipeApi = retrofit.create(RecipeApi::class.java)

    @Provides
    @Singleton
    fun provideRecipeRepo(api: RecipeApi): RecipeRepo = RecipeRepoImpl(api)
}