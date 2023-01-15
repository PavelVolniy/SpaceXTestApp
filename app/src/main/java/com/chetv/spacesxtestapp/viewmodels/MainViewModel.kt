package com.chetv.spacesxtestapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.chetv.spacesxtestapp.base.BaseViewModel
import com.chetv.spacesxtestapp.data.model.JsonFlightItem
import com.chetv.spacesxtestapp.network.SpaceXApi
import com.chetv.spacesxtestapp.utils.ParserDate
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
  val api: SpaceXApi
) : BaseViewModel() {

  private val _data = MutableLiveData<List<JsonFlightItem>>()
  val data: MutableLiveData<List<JsonFlightItem>> = _data

  init {
    viewModelScope.launch {
      val items = getItems()
      _data.postValue(items)
    }
  }

  private suspend fun getItems(): List<JsonFlightItem> {
    val data = api.getFlightList()
    return data.map {
      JsonFlightItem(
        id = it.id.toLong(),
        name = it.name,
        flight = it.cores[0].flight,
        date_utc = ParserDate.getDate(it.date_utc),
        success = it.success,
        small = it.links.patch.small
      )
    }
  }

}