package com.example.proofofconcept.data.network

import com.example.proofofconcept.data.network.model.response.HomeResponse
import io.reactivex.Observable
import retrofit2.http.*

interface ApiHelper {

    @GET("s/2iodh4vg0eortkl/facts")
    fun getHomeResponse(): Observable<HomeResponse>


}