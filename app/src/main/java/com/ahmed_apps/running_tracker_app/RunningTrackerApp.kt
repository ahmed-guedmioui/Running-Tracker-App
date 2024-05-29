package com.ahmed_apps.running_tracker_app

import android.app.Application
import com.ahmed_apps.auth.data.di.authDataModule
import com.ahmed_apps.auth.di.authViewModelModule
import com.ahmed_apps.core.data.di.coreDataModule
import com.ahmed_apps.run.di.runViewModelModule
import com.ahmed_apps.running_tracker_app.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

/**
 * @author Ahmed Guedmioui
 */
class RunningTrackerApp: Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RunningTrackerApp)
            modules(
                appModule,
                authDataModule,
                authViewModelModule,
                runViewModelModule,
                coreDataModule
            )
        }
    }
}





















