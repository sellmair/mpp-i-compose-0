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
                api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9")
                api("androidx.appcompat:appcompat:1.2.0")
            }
        }

        named("commonTest") {
            dependencies {
                implementation("junit:junit:4.13")
            }
        }
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
