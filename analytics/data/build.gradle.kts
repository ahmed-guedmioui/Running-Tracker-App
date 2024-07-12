plugins {
    alias(libs.plugins.runningTrackerApp.android.library)
}

android {
    namespace = "com.ahmed_apps.analytics.data"
}

dependencies {

    implementation(libs.kotlinx.coroutines.core)

    implementation(projects.core.database)
    implementation(projects.core.domain)
    implementation(projects.analytics.domain)
}