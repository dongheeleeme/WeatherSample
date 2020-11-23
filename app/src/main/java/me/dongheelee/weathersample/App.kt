package me.dongheelee.weathersample

import android.app.Application
import me.dongheelee.weathersample.di.repositoryModule
import me.dongheelee.weathersample.di.useCaseModule
import me.dongheelee.weathersample.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            modules(repositoryModule)
            modules(useCaseModule)
            modules(viewModelModule)
        }
    }
}
