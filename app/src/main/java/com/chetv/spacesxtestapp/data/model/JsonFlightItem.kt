package com.chetv.spacesxtestapp.data.model

import com.chetv.spacesxtestapp.data.SpaceXList

class JsonFlightItem(
  val id: Long,
  val name: String,
  val flight: Int,
  val date_utc: String,
  val success: Boolean,
  val small: String
): SpaceXList {
  override val itemId: Long
    get() = id.toLong()
}