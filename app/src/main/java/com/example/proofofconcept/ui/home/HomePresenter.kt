package com.example.proofofconcept.ui.home

import com.example.proofofconcept.data.DataManager
import com.example.proofofconcept.data.network.model.response.HomeResponse
import com.example.proofofconcept.ui.base.BasePresenter
import com.example.proofofconcept.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


class HomePresenter<V : HomeContract.View> @Inject constructor(
    dataManager: DataManager,
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable
) : BasePresenter<V>(dataManager, schedulerProvider, compositeDisposable),
    HomeContract.Presenter<V> {

    private lateinit var mResponse: HomeResponse

    override fun onAttach(view: V) {
        super.onAttach(view)
        getHomeData()
    }

    override fun getHomeData() {
        view?.showProgressBar()
        compositeDisposable.add(
            dataManager.getHomeResponse()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe({ response ->
                    mResponse = response
                    mResponse.title?.let { view?.initToolBar(it) }
                    if (!mResponse.rows.isNullOrEmpty())
                        view?.setUpRecyclerView()
                    else
                        view?.showEmptyView()
                    view?.hideProgressBar()

                }, {
                    view?.hideProgressBar()
                    it.message?.let { message -> view?.showToast(message) }
                })
        )
    }

    override fun getHomeResponse(): HomeResponse {
        return mResponse
    }
}