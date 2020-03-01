package com.example.proofofconcept

import android.app.Application
import com.example.proofofconcept.di.components.ApplicationComponent
import com.example.proofofconcept.di.components.DaggerApplicationComponent
import com.example.proofofconcept.di.modules.ApplicationModule

class ProofOfConceptApplication: Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
    }
}