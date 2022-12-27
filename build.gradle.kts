plugins {
    kotlin("jvm") version PluginVersions.JVM_VERSION
}

subprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
        version = PluginVersions.JVM_VERSION
    }

    apply {
        plugin("org.jetbrains.kotlin.kapt")
           version = PluginVersions.KAPT_VERSION
    }

    dependencies {
        implementation(Dependencies.SPRING_WEB)
        implementation(Dependencies.JACKSON)
        implementation(Dependencies.KOTLIN_REFLECT)
        implementation(Dependencies.KOTLIN_JDK)
        testImplementation(Dependencies.SPRING_TEST)
        testImplementation(Dependencies.ASSERTJ)
    }
}

allprojects {
    group = "com.example"
    version = "0.0.1-SNAPSHOT"
    
    tasks {
        compileKotlin {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xjsr305=strict")
                jvmTarget = "11"
            }
        }

        compileJava {
            sourceCompatibility = JavaVersion.VERSION_11.majorVersion
        }

        test {
            useJUnitPlatform()
        }
    }

    repositories {
        mavenCentral()
    }
}

tasks.getByName<Jar>("jar") {
    enabled = false
}
