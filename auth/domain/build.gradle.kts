plugins {
    alias(libs.plugins.runningTrackerApp.jvm.library)
}

dependencies {
    implementation(projects.core.domain)
}