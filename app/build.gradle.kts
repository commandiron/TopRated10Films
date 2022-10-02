plugins {
    id("com.android.application")
    kotlin("android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        applicationId = ProjectConfig.appId
        minSdk = ProjectConfig.minSdk
        targetSdk = ProjectConfig.targetSdk
        versionCode = ProjectConfig.versionCode
        versionName = ProjectConfig.versionName

        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = freeCompilerArgs + listOf()
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Compose.compilerVersion
    }
    packagingOptions {
        resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }
}

dependencies {
    implementation(AndroidX.coreKtx)
    implementation(AndroidX.appCompat)
    implementation(AndroidX.activityCompose)
    implementation(AndroidX.materialIconsCore)
    implementation(AndroidX.materialIconsExtended)
    implementation(AndroidX.coreSplashScreen)

    implementation(Compose.ui)
    implementation(Compose.uiUtil)
    implementation(Compose.uiToolingPreview)
    implementation(Compose.navigation)
    implementation(Compose.material3)
    implementation(Compose.hiltNavigation)
    debugImplementation(Compose.uiTooling)
    debugImplementation(Compose.uiTestManifest)

    implementation(Accompanist.navigationAnimation)
    implementation(Accompanist.pager)
    implementation(Accompanist.systemUi)

    implementation(Coil.coilCompose)

    implementation(Retrofit.retrofit)
    implementation(Retrofit.moshiConverter)

    implementation(Room.runtime)
    kapt(Room.compiler)
    implementation(Room.ktx)
    implementation(Room.paging)

    implementation(Paging.compose)

    kapt(DaggerHilt.hiltCompiler)
    implementation(DaggerHilt.hiltAndroid)
}