package com.example.proofofconcept.data

import com.example.proofofconcept.data.network.ApiHelper
import com.example.proofofconcept.data.network.model.response.HomeResponse
import io.reactivex.Observable
import javax.inject.Inject

class ProofOfConceptDataManager @Inject constructor(apiHelper: ApiHelper) : DataManager {

    private var mApiHelper = apiHelper

    override fun getHomeResponse(): Observable<HomeResponse> {
        return mApiHelper.getHomeResponse()
    }
}
