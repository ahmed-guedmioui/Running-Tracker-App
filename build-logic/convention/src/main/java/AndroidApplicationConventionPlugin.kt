import com.ahmed_apps.convention.ExtensionType
import com.ahmed_apps.convention.configureBuildTypes
import com.ahmed_apps.convention.configureKotlinAndroid
import com.ahmed_apps.convention.libs
import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

/**
 * @author Ahmed Guedmioui
 */
class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                defaultConfig {
                    applicationId = libs.findVersion("projectApplicationId").get().toString()
                    targetSdk = libs.findVersion("projectTargetSdkVersion").get().toString().toInt()

                    versionCode = libs.findVersion("projectVersionCode").get().toString().toInt()
                    versionName = libs.findVersion("projectVersionName").get().toString()
                }

                configureKotlinAndroid(this)

                configureBuildTypes(
                    commonExtension = this,
                    extensionType = ExtensionType.APPLICATION
                )
            }
        }
    }

}










