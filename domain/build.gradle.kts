plugins {
    // Pure Kotlin/JVM module — deliberately NOT an Android module.
    // This makes it a COMPILE ERROR to import android.*, Compose, or Retrofit here.
    // The domain layer must depend on nothing framework-specific.
    id("org.jetbrains.kotlin.jvm")
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
}
