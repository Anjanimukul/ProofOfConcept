package com.example.proofofconcept.di.modules

import androidx.appcompat.app.AppCompatActivity
import com.example.proofofconcept.data.network.ApiHelper
import com.example.proofofconcept.data.network.ProofOfConceptApiHelper
import com.example.proofofconcept.di.ActivityScope
import com.example.proofofconcept.ui.home.HomeContract
import com.example.proofofconcept.ui.home.HomePresenter
import com.example.proofofconcept.ui.home.adapter.HomeAdapter
import com.example.proofofconcept.utils.rx.ProofOfConceptSchedulerProvider
import com.example.proofofconcept.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule(private val mActivity: AppCompatActivity) {

    @Provides
    @ActivityScope
    fun provideActivity(): AppCompatActivity {
        return mActivity
    }

    @Provides
    fun getSchedulerProvider(schedulerProvider: ProofOfConceptSchedulerProvider): SchedulerProvider {
        return schedulerProvider
    }

    @Provides
    fun getCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    fun getApiHelper(apiHelper: ProofOfConceptApiHelper): ApiHelper {
        return apiHelper
    }

    @Provides
    @ActivityScope
    fun getHomePresenter(homePresenter: HomePresenter<HomeContract.View>): HomeContract.Presenter<HomeContract.View> {
        return homePresenter
    }

    @Provides
    @ActivityScope
    fun getHomeAdapter(presenter: HomeContract.Presenter<HomeContract.View>): HomeAdapter {
        return HomeAdapter(presenter)
    }
}
