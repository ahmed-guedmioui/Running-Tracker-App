package com.ahmed_apps.core.data.di

import com.ahmed_apps.core.data.auth.EncryptedSessionStorage
import com.ahmed_apps.core.data.networking.HttpClientFactory
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * @author Ahmed Guedmioui
 */
val coreDataModule = module {
    single {
        HttpClientFactory().build()
    }
    singleOf(::EncryptedSessionStorage).bind()
}