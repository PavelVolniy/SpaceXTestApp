package com.chetv.spacesxtestapp.ui.detailsscreen

import com.chetv.spacesxtestapp.data.DetailsList
import com.chetv.spacesxtestapp.data.model.DetailsCrewItem
import com.chetv.spacesxtestapp.databinding.CrewListItemBinding
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object DetailsDelegate {

  fun detailsCrewTeamAdapterDelegate() =
    adapterDelegateViewBinding<DetailsCrewItem, DetailsList, CrewListItemBinding>({ inflater, container ->
      CrewListItemBinding.inflate(inflater, container, false)
    }) {
      bind {
        binding.tvNameCrewItem.text = item.name
        binding.tvAgencyCrewItem.text = item.agency
        binding.tvStatusCrewItem.text = item.status
      }
    }

}