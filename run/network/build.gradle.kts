plugins {
    alias(libs.plugins.runningTrackerApp.android.library)
}

android {
    namespace = "com.ahmed_apps.run.network"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.data)
}