package com.chetv.spacesxtestapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.chetv.spacesxtestapp.base.BaseViewModel
import com.chetv.spacesxtestapp.data.DetailsList
import com.chetv.spacesxtestapp.data.model.DetailsCrewItem
import com.chetv.spacesxtestapp.network.SpaceXApi
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
  private val api: SpaceXApi
) : BaseViewModel() {

  private val _data = MutableLiveData<List<DetailsList>>()
  val data: MutableLiveData<List<DetailsList>> = _data

  init {
    viewModelScope.launch {
      val items = getItems()
      _data.postValue(items)
    }
  }

  private suspend fun getItems(): List<DetailsList> {
    val dataCrewFromServer = api.getCrewTeam()
    dataCrewFromServer.map { println(it) }
    return dataCrewFromServer.map {
      DetailsCrewItem(
        name = it.name,
        agency = it.agency,
        status = it.status
      )
    }
  }
}
