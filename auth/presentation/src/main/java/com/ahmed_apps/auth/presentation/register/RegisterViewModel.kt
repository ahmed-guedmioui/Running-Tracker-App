package com.ahmed_apps.auth.presentation.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

/**
 * @author Ahmed Guedmioui
 */
class RegisterViewModel : ViewModel() {
    var state by mutableStateOf(RegisterState())
        private set

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




















