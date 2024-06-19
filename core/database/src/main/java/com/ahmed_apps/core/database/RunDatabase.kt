package com.ahmed_apps.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ahmed_apps.core.database.dao.RunDao
import com.ahmed_apps.core.database.entity.RunEntity

/**
 * @author Ahmed Guedmioui
 */
@Database(
    entities = [RunEntity::class],
    version = 1
)
abstract class RunDatabase: RoomDatabase() {
    abstract val runDao: RunDao
}
















