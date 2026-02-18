import org.jetbrains.compose.desktop.application.dsl.TargetFormat
plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.application")
    id("org.jetbrains.compose")
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }
    
    jvm("desktop")
    
    js(IR) {
        moduleName = "loginApp"
        browser {
            commonWebpackConfig {
                outputFileName = "loginApp.js"
            }
        }
        binaries.executable()
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.materialIconsExtended)
                implementation(compose.ui)
                
                // Ktor para API calls
                implementation("io.ktor:ktor-client-core:2.3.7")
                implementation("io.ktor:ktor-client-content-negotiation:2.3.7")
                implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.7")
                implementation("io.ktor:ktor-client-logging:2.3.7")
                
                // Coroutines
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
                
                // Serialization
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")
            }
        }
        
        val androidMain by getting {
            dependencies {
                implementation("androidx.activity:activity-compose:1.8.2")
                implementation("io.ktor:ktor-client-okhttp:2.3.7")
            }
        }
        
        val desktopMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
                implementation("io.ktor:ktor-client-okhttp:2.3.7")
            }
        }
        
        val jsMain by getting {
            dependencies {
                implementation(compose.ui)
                implementation("io.ktor:ktor-client-js:2.3.7")
            }
        }
    }
}

android {
    namespace = "com.cristina.loginkmp"
    compileSdk = 34
    
    defaultConfig {
        applicationId = "com.cristina.loginkmp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    
    buildFeatures {
        compose = true
    }
    
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }
    
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "LoginKMP"
            packageVersion = "1.0.0"
            
            windows {
                iconFile.set(project.file("src/desktopMain/resources/icon.ico"))
            }
            linux {
                iconFile.set(project.file("src/desktopMain/resources/icon.png"))
            }
            macOS {
                iconFile.set(project.file("src/desktopMain/resources/icon.icns"))
            }
        }
    }
}

compose.experimental {
    web.application {}
}
