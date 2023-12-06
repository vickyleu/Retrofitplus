plugins {
    id("com.android.library")
    id("maven-publish")
}
group = "com.github.vickyleu"
version = "1.0.0"

android {
    compileSdk = 30
    namespace = "github.library"
    defaultConfig {
        minSdk = 16
        manifestPlaceholders += arrayOf("qq_id" to "")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    lint {
        abortOnError = false
    }
}

dependencies {
    compileOnly("com.squareup.retrofit2:retrofit:2.9.0")
    compileOnly("com.squareup.retrofit2:converter-gson:2.9.0")
    compileOnly("io.reactivex.rxjava3:rxjava:3.1.5")
}
configurations.configureEach {
    exclude(group = "org.jetbrains.kotlin", module = "kotlin-stdlib-jdk7")
    exclude(group = "io.reactivex.rxjava2")
    exclude(group = "log4j", module = "log4j")
}

afterEvaluate {
    if (System.getenv("JITPACK") != null) {
        publishing {
            publications {
                // Creates a Maven publication called "release".
                register("release", MavenPublication::class) {
                    // Library Package Name (Example : "com.frogobox.androidfirstlib")
                    // NOTE : Different GroupId For Each Library / Module, So That Each Library Is Not Overwritten
                    groupId = "com.github.vickyleu"
                    // Library Name / Module Name (Example : "androidfirstlib")
                    // NOTE : Different ArtifactId For Each Library / Module, So That Each Library Is Not Overwritten
                    artifactId = "retrofitplus"
                    // Version Library Name (Example : "1.0.0")
                    version = "1.0.1"
                    from(components["release"])
                }
            }
        }
    }
}