package com.chetv.spacesxtestapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chetv.spacesxtestapp.R
import com.chetv.spacesxtestapp.databinding.ActivityMainBinding
import com.chetv.spacesxtestapp.ui.mainscreen.MainFragment

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    if (savedInstanceState == null) {
      supportFragmentManager.beginTransaction()
        .add(R.id.container, MainFragment())
        .commitAllowingStateLoss()
    }
  }
}