package com.digitalsamurai.hedgehogtest

import android.app.Application
import com.digitalsamurai.hedgehogtest.dagger2.AppComponent
import com.digitalsamurai.hedgehogtest.dagger2.DaggerAppComponent
import com.digitalsamurai.hedgehogtest.dagger2.MainModule

class ApplicationM : Application() {
    override fun onCreate() {
        daggerApp = buildDaggers();
        super.onCreate()
    }
    fun buildDaggers() : AppComponent{
        return DaggerAppComponent.builder().mainModule(MainModule()).build();
    }
    companion object{
        private lateinit var daggerApp : AppComponent;
        fun getAppComponent() : AppComponent{
            return daggerApp
        }
    }
}