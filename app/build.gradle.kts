plugins {
    id("kotlin-kapt")
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.hilt)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.test.app"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.test.app"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
//    composeOptions {
//        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
//    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
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
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(project(":data"))
    debugImplementation(libs.compose.ui.tooling)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.hilt)
    implementation(libs.hiltNavigationCompose)
    kapt(libs.hilt.compiler)
    implementation(libs.retrofit)
    implementation(libs.gson)
    implementation(libs.gsonConverter)
    implementation(libs.okhttp)
    kapt(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)

    // local dependencies
    implementation(project(":datasources"))
    implementation(project(":api"))
    implementation(project(":repositories"))
    implementation(project(":repositories_impl"))
    implementation(project(":usecases"))
    implementation(project(":usecases_impl"))
    implementation(project(":test_feature"))
    implementation(project(":storage"))
}

kapt {
    correctErrorTypes = true
}