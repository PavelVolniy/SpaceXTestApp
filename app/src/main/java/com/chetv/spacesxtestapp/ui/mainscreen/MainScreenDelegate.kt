package com.chetv.spacesxtestapp.ui.mainscreen

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import coil.load
import com.chetv.spacesxtestapp.R
import com.chetv.spacesxtestapp.data.SpaceXList
import com.chetv.spacesxtestapp.data.model.FlightListItem
import com.chetv.spacesxtestapp.databinding.FlightListItemBinding
import com.chetv.spacesxtestapp.ui.detailsscreen.DetailsFragment
import com.chetv.spacesxtestapp.utils.ArgsBundle
import com.chetv.spacesxtestapp.utils.ParserDate
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object MainScreenDelegate {

  fun flightListItemAdapter() =
    adapterDelegateViewBinding<FlightListItem, SpaceXList, FlightListItemBinding>({ inflater, container ->
      FlightListItemBinding.inflate(inflater, container, false)
    }) {
      bind {
        binding.tvNameItem.text = item.name
        binding.tvCoresFlight.text = item.flight
        binding.tvDate.text = ParserDate.getDate(item.date_utc)
        binding.tvStatus.text = item.success.toString()
        binding.ivSmallIcon.load(item.small)
        binding.clItemList.setOnClickListener {
          val bundle = Bundle()
          bundle.putString(ArgsBundle.NAME, item.name)
          bundle.putString(ArgsBundle.FLIGHT, item.flight)
          bundle.putString(ArgsBundle.DATE, item.date_utc)
          bundle.putString(ArgsBundle.IMAGE, item.large)
          bundle.putString(ArgsBundle.STATUS, item.success.toString())
          bundle.putString(ArgsBundle.DETAILS, item.details)
          (context as FragmentActivity).supportFragmentManager.beginTransaction()
            .replace(
              R.id.container, DetailsFragment().newInstance(bundle)
            )
            .addToBackStack("MainScreen")
            .commit()
        }
      }
    }

}
