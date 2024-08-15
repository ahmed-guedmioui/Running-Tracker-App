package com.ahmed_apps.wear.app

import android.app.Application
import com.ahmed_apps.wear.run.presentation.di.runPresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * @author Ahmed Guedmioui
 */
class RunningTrackerApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RunningTrackerApp)
            modules(runPresentationModule)
        }
    }
}