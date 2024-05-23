plugins {
    alias(libs.plugins.runningTrackerApp.android.library)
}

android {
    namespace = "com.ahmed_apps.core.database"
}

dependencies {
    implementation(libs.org.mongodb.bson)

    implementation(projects.core.domain)
}