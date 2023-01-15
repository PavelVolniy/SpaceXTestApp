package com.chetv.spacesxtestapp.data.jsons.spaceteam

data class JsonSpaceTeamDataItem(
    val agency: String,
    val id: String,
    val image: String,
    val launches: List<String>,
    val name: String,
    val status: String,
    val wikipedia: String
)