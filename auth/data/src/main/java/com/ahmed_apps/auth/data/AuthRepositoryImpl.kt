package com.ahmed_apps.auth.data

import com.ahmed_apps.auth.domain.AuthRepository
import com.ahmed_apps.core.data.networking.post
import com.ahmed_apps.core.domian.util.DataError
import com.ahmed_apps.core.domian.util.EmptyResult
import io.ktor.client.HttpClient

/**
 * @author Ahmed Guedmioui
 */
class AuthRepositoryImpl(
    private val httpClient: HttpClient
) : AuthRepository {
    override suspend fun register(
        email: String, password: String
    ): EmptyResult<DataError.Network> {

        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )

    }
}
















