package com.ahmed_apps.wear.run.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmed_apps.wear.run.domain.ExerciseTracker
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

/**
 * @author Ahmed Guedmioui
 */
class TrackerViewModel(
    private val exerciseTracker: ExerciseTracker
) : ViewModel() {

    var state by mutableStateOf(TrackerState())
        private set

    private var hasBodySensorsPermission = MutableStateFlow(false)


    fun onAction(action: TrackerAction) {
        when (action) {
            is TrackerAction.OnBodySensorPermissionResult -> {
                hasBodySensorsPermission.value = action.isGranted
                if (action.isGranted) {
                    viewModelScope.launch {
                        val isHeartRateTrackingSupported = exerciseTracker.isHeartRateTrackingSupported()
                        state = state.copy(
                            canTrackHeartRate = isHeartRateTrackingSupported
                        )
                    }
                }
            }

            TrackerAction.OnFinishRunClick -> {

            }

            TrackerAction.OnToggleRunClick -> {

            }

        }
    }
}