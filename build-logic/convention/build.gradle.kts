import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

plugins {
    `kotlin-dsl`
}

group = "br.com.lucad.randomquotes.buildlogic"

val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

dependencies {
    compileOnly("com.android.tools.build:gradle:${libs.findVersion("agp").get().requiredVersion}")
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:${libs.findVersion("kotlin").get().requiredVersion}")
    compileOnly("org.jetbrains.compose:compose-gradle-plugin:${libs.findVersion("composeMultiplatform").get().requiredVersion}")
    compileOnly("org.jetbrains.kotlin:compose-compiler-gradle-plugin:${libs.findVersion("kotlin").get().requiredVersion}")
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "randomquotes.android.application"
            implementationClass = "br.com.lucad.randomquotes.buildlogic.AndroidApplicationConventionPlugin"
        }
        register("kotlinMultiplatform") {
            id = "randomquotes.kotlin.multiplatform"
            implementationClass = "br.com.lucad.randomquotes.buildlogic.KotlinMultiplatformConventionPlugin"
        }
        register("composeMultiplatform") {
            id = "randomquotes.compose.multiplatform"
            implementationClass = "br.com.lucad.randomquotes.buildlogic.ComposeMultiplatformConventionPlugin"
        }
    }
}
