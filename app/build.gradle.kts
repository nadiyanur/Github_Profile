import java.io.FileInputStream
import java.util.Properties


plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}



        android {
            namespace = "id.ac.polbeng.nadiya.githubprofile"
            compileSdk = 35

            defaultConfig {
                applicationId = "id.ac.polbeng.nadiya.githubprofile"
                minSdk = 24
                targetSdk = 34
                versionCode = 1
                versionName = "1.0"

                // Muat ACCESS_TOKEN dari file apikey.properties
                val apikeyPropertiesFile = rootProject.file("apikey.properties")
                val apikeyProperties = Properties()
                if (apikeyPropertiesFile.exists()) {
                    apikeyProperties.load(FileInputStream(apikeyPropertiesFile))
                } else {
                    throw GradleException("File apikey.properties tidak ditemukan.")
                }
                buildConfigField("String", "ACCESS_TOKEN", "\"${apikeyProperties["ACCESS_TOKEN"]}\"")
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
                viewBinding = true
            }
        }

dependencies {
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.github.bumptech.glide:glide:4.15.1")
    kapt("com.github.bumptech.glide:compiler:4.15.1")

    // AndroidX dependencies
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.activity:activity-ktx:1.7.2")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation(libs.androidx.activity)

    // Testing dependencies
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Additional libraries
    // Library untuk menampilkan gambar bergerak (splash screen)
    implementation("com.airbnb.android:lottie:5.2.0")

    // Library untuk menampilkan gambar bulat (circle image)
    implementation("de.hdodenhof:circleimageview:3.1.0")

    // Library untuk menampilkan gambar melalui URL
    implementation("com.github.bumptech.glide:glide:4.15.1")
    kapt("com.github.bumptech.glide:compiler:4.15.1")

    // Library untuk request API
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Library untuk logging hasil request API
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.9")

    implementation ("androidx.appcompat:appcompat:1.6.1")
}
