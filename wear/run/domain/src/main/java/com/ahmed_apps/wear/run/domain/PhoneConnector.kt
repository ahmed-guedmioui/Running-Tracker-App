package com.ahmed_apps.wear.run.domain

import com.ahmed_apps.core.connectivity.domain.DeviceNode
import kotlinx.coroutines.flow.StateFlow

/**
 * @author Ahmed Guedmioui
 */
interface PhoneConnector {
    val connectedNode: StateFlow<DeviceNode?>
}