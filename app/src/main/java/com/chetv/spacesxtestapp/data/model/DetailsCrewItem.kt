package com.chetv.spacesxtestapp.data.model

import com.chetv.spacesxtestapp.data.DetailsList

data class DetailsCrewItem(
  val name: String,
  val agency: String,
  val status: String,
): DetailsList {
  override val itemId: Long
    get() = this.hashCode().toLong()
}