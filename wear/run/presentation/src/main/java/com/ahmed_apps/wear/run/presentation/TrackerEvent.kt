package com.ahmed_apps.wear.run.presentation

/**
 * @author Ahmed Guedmioui
 */
sealed interface TrackerEvent {
    data object RunFinished: TrackerEvent
}