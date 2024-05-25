package com.ahmed_apps.auth.presentation.register

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text2.input.textAsFlow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmed_apps.auth.domain.UserDataValidator
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * @author Ahmed Guedmioui
 */
@OptIn(ExperimentalFoundationApi::class)
class RegisterViewModel(
    private val userDataValidator: UserDataValidator
) : ViewModel() {
    var state by mutableStateOf(RegisterState())
        private set

    init {
        state.email.textAsFlow()
            .onEach { email ->
                state = state.copy(
                    isEmailValid = userDataValidator.isValidEmail(email.toString())
                )
            }
            .launchIn(viewModelScope)

        state.password.textAsFlow()
            .onEach { password ->
                state = state.copy(
                    passwordValidationState = userDataValidator.isValidPassword(password.toString())
                )
            }
            .launchIn(viewModelScope)
    }

    fun onAction(action: RegisterAction) {
        when (action) {
            RegisterAction.ObRegisterClick -> {
                TODO()
            }

            RegisterAction.OnLoginClick -> {
                TODO()
            }

            RegisterAction.OnTogglePasswordVisibilityClick -> {
                TODO()
            }
        }
    }
}




















