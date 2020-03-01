package com.example.proofofconcept.di.modules

import android.app.Application
import android.content.Context
import androidx.databinding.library.BuildConfig
import com.example.proofofconcept.ProofOfConceptApplication
import com.example.proofofconcept.data.DataManager
import com.example.proofofconcept.data.ProofOfConceptDataManager
import com.example.proofofconcept.data.network.ApiHelper
import com.example.proofofconcept.data.network.ProofOfConceptApiHelper
import com.example.proofofconcept.di.ApplicationContext
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class ApplicationModule(private val application: ProofOfConceptApplication) {
    @Provides
    @ApplicationContext
    fun providesContext(): Context {
        return application
    }

    @Provides
    fun provideApplication(): Application {
        return application
    }

    @Provides
    @Singleton
    fun getOKHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                chain.proceed(
                    chain.request()
                        .newBuilder()
                        .build()
                )
            }
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun getRetrofit(defaultHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dl.dropboxusercontent.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(defaultHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun getApiHelper(apiHelper: ProofOfConceptApiHelper): ApiHelper {
        return apiHelper
    }

    @Provides
    @Singleton
    fun getDataManager(dataManager: ProofOfConceptDataManager): DataManager {
        return dataManager
    }
}