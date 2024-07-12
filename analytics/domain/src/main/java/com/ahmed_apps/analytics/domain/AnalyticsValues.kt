package com.ahmed_apps.analytics.domain

import kotlin.time.Duration

/**
 * @author Ahmed Guedmioui
 */
data class AnalyticsValues(
    val totalDistanceRun: Int = 0,
    val totalTimeRun: Duration = Duration.ZERO,
    val fastestEverRun: Double = 0.0,
    val avrDistancePerRun: Double = 0.0,
    val avrPacePerRun: Double = 0.0
)
