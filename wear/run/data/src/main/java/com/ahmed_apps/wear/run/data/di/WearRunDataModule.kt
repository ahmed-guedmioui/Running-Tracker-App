package com.ahmed_apps.wear.run.data.di

import com.ahmed_apps.wear.run.data.HealthServicesExerciseTracker
import com.ahmed_apps.wear.run.domain.ExerciseTracker
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * @author Ahmed Guedmioui
 */

val wearRunDataModule = module {
    singleOf(::HealthServicesExerciseTracker).bind<ExerciseTracker>()
}