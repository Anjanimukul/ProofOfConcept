package com.example.proofofconcept.ui.base

import com.example.proofofconcept.data.DataManager
import com.example.proofofconcept.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

open class BasePresenter<V : BaseContract.View> constructor(
    val dataManager: DataManager,
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable
) : BaseContract.Presenter<V> {

    var view: V? = null

    override fun onAttach(view: V) {
        this.view = view
    }

    override fun onDetach() {
        compositeDisposable.dispose()
        view = null
    }
}