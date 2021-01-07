package com.gamerole.login

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class HiltApplication : Application() {
    @Inject
    lateinit var testFun: TestFun
    override fun onCreate() {
        super.onCreate()
        testFun.do1()
    }
}