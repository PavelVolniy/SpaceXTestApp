package com.chetv.spacesxtestapp.network

import com.chetv.spacesxtestapp.data.jsons.JsonSpaceXData
import com.chetv.spacesxtestapp.data.jsons.spaceteam.JsonCrewTeamList
import retrofit2.http.GET
import retrofit2.http.Query

interface SpaceXApi {

  @GET("/v4/launches")
  suspend fun getFlightList(@Query("limit") limit: String): JsonSpaceXData

  @GET("/v4/crew")
  suspend fun getCrewTeam(): JsonCrewTeamList
}