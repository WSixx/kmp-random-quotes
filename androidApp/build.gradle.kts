plugins {
    id("randomquotes.android.application")
}

android {
    namespace = "br.com.lucad.randomquotes"

    defaultConfig {
        applicationId = "br.com.lucad.randomquotes"
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    implementation(project(":shared"))

    implementation(libs.androidx.activity.compose)

    implementation(libs.compose.uiToolingPreview)
    debugImplementation(libs.compose.uiTooling)
}
