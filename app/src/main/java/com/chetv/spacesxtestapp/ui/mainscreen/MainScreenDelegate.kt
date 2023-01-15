package com.chetv.spacesxtestapp.ui.mainscreen

import coil.load
import com.chetv.spacesxtestapp.data.SpaceXList
import com.chetv.spacesxtestapp.data.jsons.JsonSpaceXDataItem
import com.chetv.spacesxtestapp.databinding.FlightListItemBinding
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object MainScreenDelegate {

  fun flightListItemAdapter()=
    adapterDelegateViewBinding<JsonSpaceXDataItem, SpaceXList, FlightListItemBinding>({
      inflater, container-> FlightListItemBinding.inflate(inflater,container, false)
    }){
      bind {
        binding.tvNameItem.text = item.name
        binding.tvCoresFlight.text = item.cores[0].flight.toString()
        binding.tvDate.text = item.date_utc
        binding.tvStatus.text = item.success.toString()
        binding.ivSmallIcon.load(item.links.patch.small)
      }
    }

}