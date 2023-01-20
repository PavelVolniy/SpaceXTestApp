package com.chetv.spacesxtestapp.ui.detailsscreen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.load
import com.chetv.spacesxtestapp.R
import com.chetv.spacesxtestapp.databinding.DetailsFragmentBinding
import com.chetv.spacesxtestapp.di.DetailsComponent
import com.chetv.spacesxtestapp.utils.ArgsBundle
import com.chetv.spacesxtestapp.utils.ParserDate
import com.chetv.spacesxtestapp.utils.viewBinding
import com.chetv.spacesxtestapp.viewmodels.DetailsViewModel

class DetailsFragment(

) : Fragment(R.layout.details_fragment) {
  private val component by lazy { DetailsComponent.create() }
  private val binding by viewBinding { DetailsFragmentBinding.bind(it) }
  private val viewModel by viewModels<DetailsViewModel> { component.viewModelFactory() }
  private val adapter = DetailsVerticalAdapter()
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    with(binding) {
      container.adapter = adapter
      arguments?.let {
        binding.tvTitleName.text = it.getString(ArgsBundle.NAME)
        binding.ivLargeIcon.load(it.getString(ArgsBundle.IMAGE))
        binding.tvDetails.text = it.getString(ArgsBundle.DETAILS)
        binding.tvCoresFlight.text = it.getString(ArgsBundle.FLIGHT)
        binding.tvStatus.text = it.getString(ArgsBundle.STATUS)
        binding.tvTime.text = it.getString(ArgsBundle.DATE)?.let { it1 -> ParserDate.getTime(it1) }
        binding.tvDate.text = it.getString(ArgsBundle.DATE)?.let { it1 -> ParserDate.getDate(it1) }
      }

      viewModel.data.observe(viewLifecycleOwner) {
        adapter.items = it
      }
    }

  }

  fun newInstance(bundle: Bundle): DetailsFragment {
    val fragment = DetailsFragment()
    fragment.arguments = bundle
    return fragment
  }
}
