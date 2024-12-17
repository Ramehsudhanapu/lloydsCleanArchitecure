import dependencies.LyodsDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
    namespace = "com.ramesh.assessment"
    compileSdk = Versions.compile_sdk

    defaultConfig {
        minSdk = Versions.min_sdk
        targetSdk = Versions.target_sdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(Modules.core))

    // TESTING
    testImplementation(LyodsDependencies.junit)
    testImplementation(libs.junit)
    androidTestImplementation(LyodsDependencies.test_ext_junit)
    androidTestImplementation(LyodsDependencies.espresso_core)
    androidTestImplementation(LyodsDependencies.junit_compose)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    debugImplementation(LyodsDependencies.ui_tooling)
    debugImplementation(LyodsDependencies.ui_test_manifest)

    // Hilt
    implementation(LyodsDependencies.hilt_android)
    kapt(LyodsDependencies.hilt_android_compiler)
    kapt(LyodsDependencies.hilt_compose_compiler)

}