package com.chetv.spacesxtestapp

import android.app.Application

class App: Application() {
  override fun onCreate() {
    super.onCreate()
    initDi()
  }

  private fun initDi() {

  }
}