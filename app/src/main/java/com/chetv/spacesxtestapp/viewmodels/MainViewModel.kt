package com.chetv.spacesxtestapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.chetv.spacesxtestapp.base.BaseViewModel
import com.chetv.spacesxtestapp.data.SpaceXList
import com.chetv.spacesxtestapp.data.jsons.JsonSpaceXDataItem
import com.chetv.spacesxtestapp.data.model.FlightListItem
import com.chetv.spacesxtestapp.network.SpaceXApi
import com.chetv.spacesxtestapp.utils.ResourceProvider
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
  private val resources: ResourceProvider,
  private val api: SpaceXApi
) : BaseViewModel() {

  private val _data = MutableLiveData<List<SpaceXList>>()
  val data: MutableLiveData<List<SpaceXList>> = _data

  init {
    viewModelScope.launch {
      val items = getItems()
      _data.postValue(items)
    }
  }

  private suspend fun getItems(): List<SpaceXList> {
    val data = api.getFlightList("5")
    val dataFlightList = mutableListOf<JsonSpaceXDataItem>()
    data.map {
      if (checkNullFields(it)) dataFlightList.add(it)
    }
    return dataFlightList.map {
      FlightListItem(
        id = it.id,
        name = it.name,
        flight = it.cores[0].flight.toString(),
        date_utc = it.date_utc,
        success = it.success,
        small = it.links.patch.small,
        large = it.links.patch.large,
        details = it.details
      )
    }
  }

  private fun checkNullFields(item: JsonSpaceXDataItem): Boolean {
    return item.id != null
        && item.name != null
        && item.cores[0].flight != null
        && item.date_utc != null
        && item.date_utc > "2021-01-01T00:00:00.000Z" //filter by date
        && item.success != null
        && item.links.patch.small != null
        && item.details != null
  }
}