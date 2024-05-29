package com.ahmed_apps.run.presentation.run_overview

/**
 * @author Ahmed Guedmioui
 */
sealed interface RunOverviewAction {
    data object OnStartRun: RunOverviewAction
    data object OnLogoutClick: RunOverviewAction
    data object OnAnalyticsClick: RunOverviewAction
}













