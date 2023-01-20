package com.chetv.spacesxtestapp.di

import androidx.lifecycle.ViewModel
import com.chetv.spacesxtestapp.network.SpaceXApi
import com.chetv.spacesxtestapp.utils.ResourceProvider
import com.chetv.spacesxtestapp.utils.ViewModelFactory
import com.chetv.spacesxtestapp.viewmodels.DetailsViewModel
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Component(modules = [DetailsModule::class])
@Singleton
interface DetailsComponent {
  fun viewModelFactory(): ViewModelFactory

  @Component.Builder
  interface Builder {
    @BindsInstance
    fun resource(resourceProvider: ResourceProvider): Builder

    @BindsInstance
    fun api(api: SpaceXApi): Builder
    fun build(): DetailsComponent
  }
    companion object {
      fun create() = with(Di.appComponent) {
        DaggerDetailsComponent.builder()
          .resource(resources())
          .api(Di.networkComponent.api())
          .build()
      }

  }
}

@Module
abstract class DetailsModule {
  @Binds
  @IntoMap
  @ViewModelKey(DetailsViewModel::class)
  abstract fun detailsViewModel(viewModel: DetailsViewModel): ViewModel
}