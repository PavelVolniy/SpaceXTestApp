package com.chetv.spacesxtestapp.di

import com.chetv.spacesxtestapp.BuildConfig
import com.chetv.spacesxtestapp.network.SpaceXApi
import dagger.Component
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Component(modules = [NetWorkModule::class])
@Singleton
interface NetWorkComponent {

  fun api(): SpaceXApi
}

@Module
abstract class NetWorkModule {

  companion object {
    private const val BASE_URL = "https://api.spacexdata.com"

    @Provides
    @Singleton
    fun provideApi(): SpaceXApi = Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .client(
        OkHttpClient.Builder()
          .addInterceptor(HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
          }).build()
      ).build().create(SpaceXApi::class.java)
  }
}