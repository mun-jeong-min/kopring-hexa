package com.example.kopringhexa.global.config

import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration

@ConfigurationPropertiesScan(basePackages = ["com.example.kopringhexa"])
@Configuration
class PropertiesConfig {
}