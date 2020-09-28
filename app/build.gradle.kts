plugins {
    id("com.android.library")
    id("kotlin-multiplatform")
}

android {
    compileSdkVersion(30)
    sourceSets {
        named("main") {
            this.java.srcDir(file("src/androidMain/kotlin"))
        }
    }
}

kotlin {
    android()
    jvm("desktop")

    sourceSets {
        named("commonMain") {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9")
                implementation("androidx.appcompat:appcompat:1.2.0")
            }
        }

        named("commonTest") {
            dependencies {
                implementation("junit:junit:4.13")
            }
        }
    }



    sourceSets {
        val jvmMain = create("jvmMain") {
            dependsOn(getByName("commonMain"))
        }

        getByName("desktopMain") {
            dependsOn(jvmMain)
        }

        getByName("androidMain") {
            dependsOn(jvmMain)
        }
    }
}

tasks.register("printSourceSetDependencies") {
    doLast {
        val desktopMain = kotlin.sourceSets.getByName("desktopMain")
        val androidMain = kotlin.sourceSets.getByName("androidMain")
        val androidDebug = kotlin.sourceSets.getByName("androidDebug")
        val androidTest = kotlin.sourceSets.getByName("androidTest")
        logger.quiet("desktopMain=${desktopMain.dependsOn.map { it.name }}")
        logger.quiet("androidMain=${androidMain.dependsOn.map { it.name }}")
        logger.quiet("androidDebug=${androidDebug.dependsOn.map { it.name }}")
        logger.quiet("androidTest=${androidTest.dependsOn.map { it.name }}")
    }
}

/*plugins {
    id 'com.android.application'
    id 'kotlin-android'
}

android {
    compileSdkVersion 30
    buildToolsVersion "30.0.2"

    defaultConfig {
        applicationId "com.example.mpp_compose_0"
        minSdkVersion 21
        targetSdkVersion 30
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }

    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = '1.8'
    }

}

dependencies {

    implementation "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
    implementation 'androidx.core:core-ktx:1.3.1'
    implementation 'androidx.appcompat:appcompat:1.2.0'
    implementation 'com.google.android.material:material:1.2.0'
    testImplementation 'junit:junit:4.+'
    androidTestImplementation 'androidx.test.ext:junit:1.1.1'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'
}

 */
