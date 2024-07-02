package com.ahmed_apps.run.data.di

import com.ahmed_apps.run.data.CreateRunWorker
import com.ahmed_apps.run.data.FetchRunWorker
import com.ahmed_apps.run.data.DeleteRunWorker
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

/**
 * @author Ahmed Guedmioui
 */

val runDataModule = module {
    singleOf(::CreateRunWorker)
    singleOf(::FetchRunWorker)
    singleOf(::DeleteRunWorker)
}