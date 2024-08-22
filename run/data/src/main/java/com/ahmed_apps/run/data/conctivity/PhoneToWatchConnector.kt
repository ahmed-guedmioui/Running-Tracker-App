package com.ahmed_apps.run.data.conctivity

import com.ahmed_apps.core.connectivity.domain.DeviceNode
import com.ahmed_apps.core.connectivity.domain.DeviceType
import com.ahmed_apps.core.connectivity.domain.NodeDiscovery
import com.ahmed_apps.run.domain.WatchConnector
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.shareIn

/**
 * @author Ahmed Guedmioui
 */
class PhoneToWatchConnector(
    nodeDiscovery: NodeDiscovery,
    applicationScope: CoroutineScope
): WatchConnector {

    private val _connectedNode = MutableStateFlow<DeviceNode?>(null)
    override val connectedDevices = _connectedNode.asStateFlow()

    private val isTrackable = MutableStateFlow(false)

    val messagingActions = nodeDiscovery
        .observeConnectedDevices(DeviceType.PHONE)
        .onEach { connectedDevices ->
            val node = connectedDevices.firstOrNull()
            if (node != null && node.isNearby) {
                _connectedNode.value = node
            }
        }
        .launchIn(applicationScope)

    override fun setIsTrackable(isTrackable: Boolean) {
        this.isTrackable.value = isTrackable
    }
}