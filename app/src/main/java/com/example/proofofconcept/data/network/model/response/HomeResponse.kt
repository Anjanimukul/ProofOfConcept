package com.example.proofofconcept.data.network.model.response

import com.google.gson.annotations.SerializedName

class HomeResponse {

    @SerializedName("title")
    var title: String? = null
    @SerializedName("rows")
    var rows: List<Row>? = null

    class Row{
        @SerializedName("title")
        var title: String? = null
        @SerializedName("description")
        var description: String? = null
        @SerializedName("imageHref")
        var imageHref: String? = null
    }

}