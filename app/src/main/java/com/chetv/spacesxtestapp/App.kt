package com.chetv.spacesxtestapp

import android.app.Application
import com.chetv.spacesxtestapp.di.DaggerAppComponent
import com.chetv.spacesxtestapp.di.DaggerNetWorkComponent
import com.chetv.spacesxtestapp.di.Di

class App: Application() {
  override fun onCreate() {
    super.onCreate()
    initDi()
  }

  private fun initDi() {
    Di.appComponent = DaggerAppComponent.builder()
      .appContext(this)
      .build()
    Di.networkComponent = DaggerNetWorkComponent.create()
  }
}