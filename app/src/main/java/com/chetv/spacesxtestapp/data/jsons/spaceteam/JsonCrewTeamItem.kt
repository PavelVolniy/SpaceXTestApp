package com.chetv.spacesxtestapp.data.jsons.spaceteam

import com.chetv.spacesxtestapp.data.DetailsList

data class JsonCrewTeamItem(
    val agency: String,
    val id: String,
    val image: String,
    val launches: List<String>,
    val name: String,
    val status: String,
    val wikipedia: String
) : DetailsList {
    override val itemId: Long
        get() = id.hashCode().toLong()
}