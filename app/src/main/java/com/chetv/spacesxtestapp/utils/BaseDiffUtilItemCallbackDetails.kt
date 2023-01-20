package com.chetv.spacesxtestapp.utils

import androidx.recyclerview.widget.DiffUtil
import com.chetv.spacesxtestapp.data.DetailsList

open class BaseDiffUtilItemCallbackDetails : DiffUtil.ItemCallback<DetailsList>(){
  override fun areItemsTheSame(oldItem: DetailsList, newItem: DetailsList): Boolean {
    return oldItem.itemId == newItem.itemId
  }

  override fun areContentsTheSame(oldItem: DetailsList, newItem: DetailsList): Boolean {
    return oldItem.equals(newItem)
  }

}