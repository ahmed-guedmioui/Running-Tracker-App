package com.ahmed_apps.convention

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

/**
 * @author Ahmed Guedmioui
 */
val Project.libs
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")