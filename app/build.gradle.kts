plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.mio.plugin.renderer"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mio.plugin.renderer"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            // FCL 启动器要求可安装的已签名 APK；沿用模板 debug 签名，免去额外 keystore。
            signingConfig = signingConfigs.getByName("debug")
        }
        configureEach {
            //应用名
            //app name
            resValue("string","app_name","PanVK G925 1.4")
            //包名后缀
            //package name Suffix
            applicationIdSuffix = ".panvk_g925_14"
            //驱动在启动器内显示的名称
            //The name displayed by the driver in the launcher
            manifestPlaceholders["driver"] = "PanVK G925 1.4.363"
            //驱动库文件名（须存在于 src/main/jniLibs/<abi>/ 下）
            //Driver library file name (must exist under src/main/jniLibs/<abi>/)
            manifestPlaceholders["driverLib"] = "libvulkan_panfrost.so"
            //驱动适配的 GPU 家族：adreno / mali / any
            //The GPU family the driver targets: adreno / mali / any
            manifestPlaceholders["driverGpu"] = "mali"
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
}