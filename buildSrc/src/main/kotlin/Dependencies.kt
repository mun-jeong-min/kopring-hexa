object Dependencies {
    const val SPRING_WEB = "org.springframework.boot:spring-boot-starter-web"
    const val JACKSON = "com.fasterxml.jackson.module:jackson-module-kotlin"
    const val KOTLIN_REFLECT = "org.jetbrains.kotlin:kotlin-reflect"
    const val KOTLIN_JDK = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
    const val SPRING_TEST = "org.springframework.boot:spring-boot-starter-test"
    const val ASSERTJ = "org.assertj:assertj-core:${DependencyVersions.ASSERTJ}"

    const val SPRING_VALIDATION = "org.springframework.boot:spring-boot-starter-validation"

    // transaction
    const val SPRING_TRANSACTION = "org.springframework:spring-tx:${DependencyVersions.SPRING_TRANSACTION}"

    // querydsl
    const val QUERYDSL = "com.querydsl:querydsl-jpa:${DependencyVersions.QUERYDSL}"
    const val QUERYDSL_PROCESSOR = "com.querydsl:querydsl-apt:${DependencyVersions.QUERYDSL}:jpa"

    // configuration
    const val CONFIGURATION_PROCESSOR = "org.springframework.boot:spring-boot-configuration-processor"

    // database
    const val SPRING_DATA_JPA = "org.springframework.boot:spring-boot-starter-data-jpa"
    const val MYSQL_CONNECTOR = "mysql:mysql-connector-java"

    const val MAPSTRUCT = "org.mapstruct:mapstruct:1.4.2.Final"
    const val MAPSTRUCT_PROCESSOR = "org.mapstruct:mapstruct-processor:1.4.2.Final"

    // security
    const val SPRING_SECURITY = "org.springframework.boot:spring-boot-starter-security"

    // jwt
    const val JWT = "io.jsonwebtoken:jjwt:${DependencyVersions.JWT_VERSION}"

    const val redis = "org.springframework.boot:spring-boot-starter-data-redis"
}