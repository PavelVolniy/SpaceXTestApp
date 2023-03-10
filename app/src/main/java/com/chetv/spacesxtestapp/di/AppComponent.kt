package com.chetv.spacesxtestapp.di

import android.content.Context
import com.chetv.spacesxtestapp.utils.AndroidResourceProviderImpl
import com.chetv.spacesxtestapp.utils.ResourceProvider
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {
  fun resources(): ResourceProvider

  @Component.Builder
  abstract class Builder{
    @BindsInstance
    abstract  fun appContext(context: Context): Builder
    abstract fun build(): AppComponent
  }
}

@Module
abstract class AppModule{
  @Binds
  @Singleton
  abstract fun bindResourceProvider(provider: AndroidResourceProviderImpl): ResourceProvider
}