package com.chetv.spacesxtestapp.ui.detailsscreen

import com.chetv.spacesxtestapp.data.DetailsList
import com.chetv.spacesxtestapp.utils.BaseDiffUtilItemCallbackDetails
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class DetailsVerticalAdapter : AsyncListDifferDelegationAdapter<DetailsList>(
  BaseDiffUtilItemCallbackDetails()
) {
  init {
    delegatesManager.addDelegate(DetailsDelegate.detailsCrewTeamAdapterDelegate())

  }
}