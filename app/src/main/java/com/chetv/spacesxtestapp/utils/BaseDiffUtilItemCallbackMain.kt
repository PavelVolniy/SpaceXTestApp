package com.chetv.spacesxtestapp.utils

import androidx.recyclerview.widget.DiffUtil
import com.chetv.spacesxtestapp.data.SpaceXList

open class BaseDiffUtilItemCallbackMain : DiffUtil.ItemCallback<SpaceXList>(){
  override fun areItemsTheSame(oldItem: SpaceXList, newItem: SpaceXList): Boolean {
    return oldItem.itemId == newItem.itemId
  }

  override fun areContentsTheSame(oldItem: SpaceXList, newItem: SpaceXList): Boolean {
    return oldItem.equals(newItem)
  }

}