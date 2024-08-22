package com.ahmed_apps.run.domain

import com.ahmed_apps.core.connectivity.domain.DeviceNode
import kotlinx.coroutines.flow.StateFlow

/**
 * @author Ahmed Guedmioui
 */
interface WatchConnector {
    val connectedDevices: StateFlow<DeviceNode?>

    fun setIsTrackable(isTrackable: Boolean)
}