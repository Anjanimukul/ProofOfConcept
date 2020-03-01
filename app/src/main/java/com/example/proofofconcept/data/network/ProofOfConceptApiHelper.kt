package com.example.proofofconcept.data.network

import com.example.proofofconcept.data.network.model.response.HomeResponse
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject

class ProofOfConceptApiHelper @Inject constructor(retrofit: Retrofit): ApiHelper {

    private var mApiHelper: ApiHelper = retrofit.create<ApiHelper>(ApiHelper::class.java)

    override fun getHomeResponse(): Observable<HomeResponse> {
        return mApiHelper.getHomeResponse()
    }

}