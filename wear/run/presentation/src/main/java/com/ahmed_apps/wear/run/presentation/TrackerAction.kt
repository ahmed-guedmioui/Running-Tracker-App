package com.ahmed_apps.wear.run.presentation

/**
 * @author Ahmed Guedmioui
 */
sealed interface TrackerAction {
    data object OnToggleRunClick: TrackerAction
    data object OnFinishRunClick: TrackerAction
}