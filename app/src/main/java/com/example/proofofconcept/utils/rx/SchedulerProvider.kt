package com.example.proofofconcept.utils.rx

import io.reactivex.Scheduler

interface SchedulerProvider {

    fun ui(): Scheduler
    fun io(): Scheduler
}