package com.chetv.spacesxtestapp.di

import androidx.lifecycle.ViewModel
import com.chetv.spacesxtestapp.network.SpaceXApi
import com.chetv.spacesxtestapp.utils.ResourceProvider
import com.chetv.spacesxtestapp.utils.ViewModelFactory
import com.chetv.spacesxtestapp.viewmodels.MainViewModel
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Component(modules = [MainScreenModule::class])
@Singleton
interface MainScreenComponent {
  fun viewModelFactory(): ViewModelFactory

  @Component.Builder
  interface Builder {
    @BindsInstance
    fun resource(resourceProvider: ResourceProvider): Builder

    @BindsInstance
    fun api(api: SpaceXApi): Builder
    fun build(): MainScreenComponent
  }

  companion object {
    fun create() = with(Di.appComponent) {
      DaggerMainScreenComponent.builder()
        .resource(resources())
        .api(Di.networkComponent.api())
        .build()
    }
  }

}

@Module
abstract class MainScreenModule {
  @Binds
  @IntoMap
  @ViewModelKey(MainViewModel::class)
  abstract fun mainViewModel(viewModel: MainViewModel): ViewModel
}
