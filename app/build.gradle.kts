
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)

    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.ramesh.lloydscleanarchitecture"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.ramesh.lloydscleanarchitecture"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    dependencies {
        // Core Kotlin extensions for Android framework APIs
        implementation(libs.androidx.core.ktx)
        // Lifecycle-aware components for Kotlin
        implementation(libs.androidx.lifecycle.runtime.ktx)
        // Integration between Compose and Activities
        implementation(libs.androidx.activity.compose)
        // Compose Bill of Materials (BOM) for consistent versions
        implementation(platform(libs.androidx.compose.bom))
        // Foundation library for Compose UI
        implementation(libs.androidx.ui)
        // Graphics components for Compose UI
        implementation(libs.androidx.ui.graphics)
        // Tooling for previewing Compose UI
        implementation(libs.androidx.ui.tooling.preview)
        // Material Design 3 components for Compose
        implementation(libs.androidx.material3)
        // JUnit for unit testing
        testImplementation(libs.junit)
        // Android JUnit runner for instrumentation tests
        androidTestImplementation(libs.androidx.junit)
        // Espresso for UI testing
        androidTestImplementation(libs.androidx.espresso.core)
        // Compose BOM for instrumentation tests
        androidTestImplementation(platform(libs.androidx.compose.bom))
        // Compose UI testing library
        androidTestImplementation(libs.androidx.ui.test.junit4)
        // Compose UI tooling for debugging
        debugImplementation(libs.androidx.ui.tooling)
        // Compose UI test manifest for instrumentation tests
        debugImplementation(libs.androidx.ui.test.manifest)

        // Hilt for dependency injection
        implementation(libs.hilt.android)
        // Hilt annotation processor
        kapt(libs.hilt.compiler)
        // Hilt annotation processor for AndroidX
        kapt(libs.androidx.hilt.compiler)

        // Kotlin Coroutines for asynchronous programming
        implementation(libs.kotlinx.coroutines.core)
        // Coil for image loading in Compose
        implementation(libs.coil.compose)
        // Retrofit for network requests
        implementation(libs.retrofit)
        // Gson converter for Retrofit
        implementation(libs.converter.gson)
    }



}