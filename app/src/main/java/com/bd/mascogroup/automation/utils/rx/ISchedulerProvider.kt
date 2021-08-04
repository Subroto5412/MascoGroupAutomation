package com.bd.mascogroup.automation.utils.rx

import io.reactivex.Scheduler

interface ISchedulerProvider {

    fun computation(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler

}