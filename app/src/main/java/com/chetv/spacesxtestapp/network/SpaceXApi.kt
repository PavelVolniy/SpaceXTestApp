package com.chetv.spacesxtestapp.network

import com.chetv.spacesxtestapp.data.jsons.JsonSpaceXData
import retrofit2.http.GET

interface SpaceXApi {

  @GET("/v4/crew")
  suspend fun getFlightList(): JsonSpaceXData
}