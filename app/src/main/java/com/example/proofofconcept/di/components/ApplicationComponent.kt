package com.example.proofofconcept.di.components

import android.app.Application
import android.content.Context
import com.example.proofofconcept.ProofOfConceptApplication
import com.example.proofofconcept.data.DataManager
import com.example.proofofconcept.di.ApplicationContext
import com.example.proofofconcept.di.modules.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: ProofOfConceptApplication)

    @ApplicationContext
    fun context(): Context

    fun application(): Application

    fun dataManager(): DataManager
}
