plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("org.jetbrains.kotlin.kapt")
    id ("com.google.dagger.hilt.android")
}

android {
    namespace = "com.rajabi.fakestoreapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.rajabi.fakestoreapplication"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField ("String","BASE_URL","\"https://fakestoreapi.com/\"")


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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        buildConfig = true

    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {


    val lifecycle_version = "2.5.1"
    val arch_version = "2.1.0"
    val room_version = "2.4.3"
    val coroutine_version = "1.3.9"
    val retrofit_version = "2.9.0"
    val interceptor_version = "4.7.2"
    val glide_version = "4.14.2"

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3:1.1.2")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    implementation ("androidx.compose.runtime:runtime-livedata:1.5.4")
    // Saved state module for ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version")
    // Annotation processor
    kapt("androidx.lifecycle:lifecycle-compiler:$lifecycle_version")
    // room
    implementation("androidx.room:room-runtime:$room_version")
    kapt("androidx.room:room-compiler:$room_version")
    //Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$room_version")
    // coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutine_version")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutine_version")
    // hilt
    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")
    // retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit_version")
    implementation("com.squareup.okhttp3:logging-interceptor:$interceptor_version")
    implementation("com.squareup.retrofit2:converter-scalars:$retrofit_version")
    // glide
    implementation("com.github.bumptech.glide:glide:$glide_version")
    kapt( "com.github.bumptech.glide:compiler:$glide_version")
    //navigation
    implementation("androidx.navigation:navigation-compose:2.7.5")
    //test
    testImplementation ("junit:junit:4.13.2")
    testImplementation ("androidx.arch.core:core-testing:$arch_version")
    testImplementation ("androidx.test.ext:junit:1.1.4")
    testImplementation ("androidx.test.espresso:espresso-core:3.5.0")
    testImplementation ("androidx.arch.core:core-testing:2.1.0")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.2.1")
    testImplementation ("com.google.truth:truth:1.0.1")
    testImplementation ("androidx.arch.core:core-testing:$arch_version")
    testImplementation ("org.robolectric:robolectric:+")

    implementation("org.jsoup:jsoup:1.11.1")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.9.0")
    testImplementation ("org.mockito:mockito-core:3.10.0")
    androidTestImplementation ("org.mockito:mockito-android:3.10.0")

    //room
    implementation("androidx.room:room-runtime:2.2.4")
    implementation("androidx.room:room-ktx:2.2.4")
    kapt ("androidx.room:room-compiler:2.2.4")

    implementation("io.coil-kt:coil-compose:2.0.0-rc01")
}
