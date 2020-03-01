package com.example.proofofconcept.ui.home

import com.example.proofofconcept.data.network.model.response.HomeResponse
import com.example.proofofconcept.ui.base.BaseContract

interface HomeContract {

    interface View: BaseContract.View{

        fun initToolBar(title: String)

        fun setUpRecyclerView()

        fun hideProgressBar()

        fun showProgressBar()

        fun showEmptyView()

    }

    interface Presenter<V: View>: BaseContract.Presenter<V>{

        fun getHomeData()

        fun getHomeResponse(): HomeResponse

    }
}