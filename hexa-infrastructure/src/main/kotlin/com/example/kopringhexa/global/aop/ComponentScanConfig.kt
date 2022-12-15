package com.example.kopringhexa.global.aop

import com.example.kopringhexa.annotation.Aggregate
import com.example.kopringhexa.annotation.Spi
import com.example.kopringhexa.annotation.UseCase
import org.mapstruct.Mapper
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.ComponentScan.Filter
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

@Configuration
@ComponentScan(
    basePackages = ["com.example.kopringhexa"],
    includeFilters = [
        Filter(
            type = FilterType.ANNOTATION,
            classes = [
                UseCase::class,
                Spi::class
            ]
        )
    ]
)
class ComponentScanConfig {
}