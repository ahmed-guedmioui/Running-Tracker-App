package com.ahmed_apps.core.domian.location

import kotlin.time.Duration

/**
 * @author Ahmed Guedmioui
 */
data class LocationTimestamp(
    val location: LocationWithAltitude,
    val durationTimestamp: Duration,
)
