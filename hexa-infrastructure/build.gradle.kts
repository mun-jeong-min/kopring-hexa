plugins {
    id("org.springframework.boot") version PluginVersions.SPRING_BOOT_VERSION
    id("io.spring.dependency-management") version PluginVersions.DEPENDENCY_MANAGER_VERSION
    kotlin("plugin.spring") version PluginVersions.SPRING_PLUGIN_VERSION
    kotlin("plugin.jpa") version PluginVersions.JPA_PLUGIN_VERSION
}

dependencies {

    implementation(Dependencies.SPRING_WEB)

    implementation(Dependencies.SPRING_DATA_JPA)
    implementation(Dependencies.MYSQL_CONNECTOR)

    implementation(Dependencies.JACKSON)
    implementation(Dependencies.SPRING_VALIDATION)

    implementation(Dependencies.MAPSTRUCT)
    kapt(Dependencies.MAPSTRUCT_PROCESSOR)

    implementation(Dependencies.CONFIGURATION_PROCESSOR)

    implementation(Dependencies.JWT)
    implementation(Dependencies.SPRING_SECURITY)

    implementation(Dependencies.redis)

    implementation(Dependencies.QUERYDSL)
    kapt(Dependencies.QUERYDSL_PROCESSOR)

    implementation(Dependencies.ACTUATP)
    implementation(Dependencies.CORE)
    implementation(Dependencies.PROMETEUS)

    implementation(project(":hexa-domain"))
}

noArg {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

tasks.getByName<Jar>("bootJar") {
    enabled = false
}