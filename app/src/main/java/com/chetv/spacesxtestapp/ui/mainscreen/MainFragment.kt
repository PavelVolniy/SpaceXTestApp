package com.chetv.spacesxtestapp.ui.mainscreen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.chetv.spacesxtestapp.R
import com.chetv.spacesxtestapp.databinding.MainFragmentBinding
import com.chetv.spacesxtestapp.di.MainScreenComponent
import com.chetv.spacesxtestapp.utils.viewBinding
import com.chetv.spacesxtestapp.viewmodels.MainViewModel

class MainFragment : Fragment(R.layout.main_fragment) {
  private val component by lazy { MainScreenComponent.create() }
  private val binding by viewBinding { MainFragmentBinding.bind(it) }
  private val viewModel by viewModels<MainViewModel> { component.viewModelFactory() }
  private val adapter = MainVerticalAdapter()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    with(binding) {
      tvRecyclerview.adapter = adapter

      viewModel.data.observe(viewLifecycleOwner) {
        adapter.items = it
      }
    }
  }
}