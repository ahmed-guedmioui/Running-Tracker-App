package com.ahmed_apps.core.connectivity.data.di

import com.ahmed_apps.core.connectivity.data.WearNodeDiscovery
import com.ahmed_apps.core.connectivity.domain.NodeDiscovery
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * @author Ahmed Guedmioui
 */
val coreConnectivityDataModule = module {
    singleOf(::WearNodeDiscovery).bind<NodeDiscovery>()
}