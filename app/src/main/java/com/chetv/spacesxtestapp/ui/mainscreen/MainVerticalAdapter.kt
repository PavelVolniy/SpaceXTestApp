package com.chetv.spacesxtestapp.ui.mainscreen

import com.chetv.spacesxtestapp.data.SpaceXList
import com.chetv.spacesxtestapp.utils.BaseDiffUtilItemCallbackMain
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class MainVerticalAdapter:
    AsyncListDifferDelegationAdapter<SpaceXList>(BaseDiffUtilItemCallbackMain()){
      init {
        delegatesManager.addDelegate(MainScreenDelegate.flightListItemAdapter())
      }
    }