package com.example.proofofconcept.di.components

import com.example.proofofconcept.di.ActivityScope
import com.example.proofofconcept.di.modules.ActivityModule
import com.example.proofofconcept.ui.home.HomeActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(homeActivity: HomeActivity)

}
