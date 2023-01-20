package com.chetv.spacesxtestapp.data.model

import com.chetv.spacesxtestapp.data.SpaceXList

data class FlightListItem(
  val id: String,
  val name: String,
  val flight: String,
  val date_utc: String,
  val success: Boolean,
  val small: String,
  val large: String,
  val details: String
): SpaceXList {
  override val itemId: Long
    get() = id.toLong()

  override fun toString(): String {
    return "$id $name \n$small"
  }
}