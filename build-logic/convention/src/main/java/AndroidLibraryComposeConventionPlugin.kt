import com.ahmed_apps.convention.ExtensionType
import com.ahmed_apps.convention.configureAndroidCompose
import com.ahmed_apps.convention.configureBuildTypes
import com.ahmed_apps.convention.configureKotlinAndroid
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.kotlin

/**
 * @author Ahmed Guedmioui
 */
class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("running_tracker_app.android.library")
            }

            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extension)

        }
    }

}

















