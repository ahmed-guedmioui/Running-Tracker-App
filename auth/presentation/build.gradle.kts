plugins {
    alias(libs.plugins.runningTrackerApp.android.feature.ui)
}

android {
    namespace = "com.ahmed_apps.auth.presentation"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.auth.domain)
}