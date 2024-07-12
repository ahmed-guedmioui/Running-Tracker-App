package com.ahmed_apps.analytics.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

/**
 * @author Ahmed Guedmioui
 */
class AnalyticsDashboardViewModel : ViewModel() {
    var state by mutableStateOf<AnalyticsDashboardState?>(null)
        private set
}