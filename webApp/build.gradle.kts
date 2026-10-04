import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    id("randomquotes.kotlin.multiplatform")
    id("randomquotes.compose.multiplatform")
}

kotlin {
    js {
        browser()
        binaries.executable()
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }

    sourceSets {
        commonMain.dependencies {
            implementation(project(":shared"))

            implementation(libs.compose.ui)
        }
    }
}
