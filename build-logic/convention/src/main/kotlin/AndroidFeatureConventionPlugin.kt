
import com.android.build.gradle.LibraryExtension
import dev.bwaim.kustomalarm.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.plugin.serialization")
                apply("com.google.devtools.ksp")
            }
            extensions.configure<LibraryExtension> {

                defaultConfig {
                    testInstrumentationRunner =
                        "dev.bwaim.kustomalarm.test.android.KustomAlarmTestRunner"
                }
            }

            dependencies {
                add("implementation", project(":common:compose"))
                add("implementation", project(":common:core:core"))
                add("implementation", project(":common:navigation"))
                add("implementation", project(":common:localisation"))
                add("implementation", project(":common:ui-resources"))

                add("implementation", libs.findLibrary("androidx.navigation.compose").get())
                add("implementation", libs.findLibrary("androidx.hilt.navigation.compose").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.runtime.compose").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.viewModelCompose").get())

                add("implementation", libs.findLibrary("compose.material3").get())

                add("implementation", libs.findLibrary("kotlin.coroutines.android").get())
                add("implementation", libs.findLibrary("kotlinx.collections.immutable").get())
                add("implementation", libs.findLibrary("kotlinx.serialization").get())

                add("implementation", libs.findLibrary("hilt.library").get())
                add("ksp", libs.findLibrary("hilt.compiler").get())

//                add("androidTestImplementation", project(":common:test:android"))
            }
        }
    }
}
