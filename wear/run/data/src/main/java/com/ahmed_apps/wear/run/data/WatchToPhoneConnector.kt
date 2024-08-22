package com.ahmed_apps.wear.run.data

import com.ahmed_apps.core.connectivity.domain.DeviceNode
import com.ahmed_apps.core.connectivity.domain.DeviceType
import com.ahmed_apps.core.connectivity.domain.NodeDiscovery
import com.ahmed_apps.wear.run.domain.PhoneConnector
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * @author Ahmed Guedmioui
 */
class WatchToPhoneConnector(
    nodeDiscovery: NodeDiscovery,
    applicationScope: CoroutineScope
) : PhoneConnector {

    private val _connectedNode = MutableStateFlow<DeviceNode?>(null)
    override val connectedNode = _connectedNode.asStateFlow()

    val messagingActions = nodeDiscovery
        .observeConnectedDevices(DeviceType.WATCH)
        .onEach { connectedDevices ->
            val node = connectedDevices.firstOrNull()
            if (node != null && node.isNearby) {
                _connectedNode.value = node
            }
        }
        .launchIn(applicationScope)
}