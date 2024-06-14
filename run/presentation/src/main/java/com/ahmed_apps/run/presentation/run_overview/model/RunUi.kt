package com.ahmed_apps.run.presentation.run_overview.model

import com.ahmed_apps.core.domian.location.Location

/**
 * @author Ahmed Guedmioui
 */
data class RunUi(
    val id: String,
    val duration: String,
    val distance: String,
    val maxSpeed: String,
    val totalElevation: String,
    val avgSpeed: String,
    val pace: String,
    val mapPictureUrl: String?,
)
