package com.ahmed_apps.analytics.presentation

import com.ahmed_apps.analytics.domain.AnalyticsValues
import com.ahmed_apps.core.presentation.ui.formatted
import com.ahmed_apps.core.presentation.ui.toFormattedKm
import com.ahmed_apps.core.presentation.ui.toFormattedKmh
import com.ahmed_apps.core.presentation.ui.toFormattedPace
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds
import kotlin.time.DurationUnit

/**
 * @author Ahmed Guedmioui
 */

fun Duration.toFormattedTotalTime(): String {
    val days = toLong(DurationUnit.DAYS)
    val hours = toLong(DurationUnit.HOURS) % 24
    val minutes = toLong(DurationUnit.MINUTES) % 60

    return "${days}d ${hours}h ${minutes}m"
}

fun AnalyticsValues.toAnalyticsDashboardState(): AnalyticsDashboardState {
    return AnalyticsDashboardState(
        totalDistanceRun = (totalDistanceRun / 1000.0).toFormattedKm(),
        totalTimeRun = totalTimeRun.toFormattedTotalTime(),
        fastestEverRun = fastestEverRun.toFormattedKmh(),
        avrDistance = (avrDistancePerRun / 1000.0).toFormattedKm(),
        avrPace = avrPacePerRun.seconds.formatted()
    )
}
















