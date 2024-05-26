package com.ahmed_apps.auth.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.ahmed_apps.auth.domain.AuthRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

/**
 * @author Ahmed Guedmioui
 */
class LoginViewModel(
    private val authRepository: AuthRepository
) : ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    private val eventChannel = Channel<LoginEvent>()
    val events = eventChannel.receiveAsFlow()

    fun onAction(action: LoginAction) {
        when (action) {
            LoginAction.ObRegisterClick -> {
            }

            LoginAction.OnLoginClick -> {
            }

            LoginAction.OnTogglePasswordVisibilityClick -> {
            }
        }
    }

}

















