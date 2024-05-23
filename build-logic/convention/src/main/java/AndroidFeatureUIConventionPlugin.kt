import com.ahmed_apps.convention.addUILayerDependencies
import com.ahmed_apps.convention.configureAndroidCompose
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

/**
 * @author Ahmed Guedmioui
 */
class AndroidFeatureUIConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("running_tracker_app.android.library.compose")
            }

            dependencies {
                addUILayerDependencies(target)
            }

        }
    }

}

















