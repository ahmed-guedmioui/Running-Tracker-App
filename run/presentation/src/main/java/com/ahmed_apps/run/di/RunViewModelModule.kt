package com.ahmed_apps.run.di

import com.ahmed_apps.run.presentation.active_run.ActiveRunViewModel
import com.ahmed_apps.run.presentation.run_overview.RunOverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

/**
 * @author Ahmed Guedmioui
 */

val runViewModelModule = module {
    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
}



