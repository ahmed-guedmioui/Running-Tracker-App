package com.ahmed_apps.run.domain

import com.ahmed_apps.core.domian.location.LocationTimestamp
import kotlin.math.roundToInt

/**
 * @author Ahmed Guedmioui
 */
object LocationDataCalculator {

    fun getTotalDistanceMeters(locations: List<List<LocationTimestamp>>): Int {
        return locations
            .sumOf { timestampsPerLine ->
                timestampsPerLine.zipWithNext { location1, location2 ->
                    location1.location.location.distanceTo(location2.location.location)
                }.sum().roundToInt()
            }
    }

}



















