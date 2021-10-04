package com.domovedov.ru.app

import android.app.Application
import com.domovedov.ru.data.serviceModule
import com.domovedov.ru.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class DomovedovApp: Application() {

    private val appModules = listOf(
        serviceModule,
        viewModelModule
    )

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@DomovedovApp)
            modules(appModules)
        }
    }
}