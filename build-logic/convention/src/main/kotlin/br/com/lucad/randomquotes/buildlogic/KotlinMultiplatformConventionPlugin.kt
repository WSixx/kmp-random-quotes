package br.com.lucad.randomquotes.buildlogic

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompilerOptions
import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask

class KotlinMultiplatformConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.multiplatform")
            }

            tasks.withType<KotlinCompilationTask<*>>().configureEach {
                compilerOptions {
                    if (this is KotlinJvmCompilerOptions) {
                        jvmTarget.set(JvmTarget.JVM_21)
                    }
                }
            }
        }
    }
}
