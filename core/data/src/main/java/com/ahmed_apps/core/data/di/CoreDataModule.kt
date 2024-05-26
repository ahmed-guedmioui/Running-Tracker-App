package com.ahmed_apps.core.data.di

import com.ahmed_apps.core.data.auth.EncryptedSessionStorage
import com.ahmed_apps.core.data.networking.HttpClientFactory
import com.ahmed_apps.core.domian.util.SessionStorage
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * @author Ahmed Guedmioui
 */
val coreDataModule = module {
    single {
        HttpClientFactory(get()).build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()
}