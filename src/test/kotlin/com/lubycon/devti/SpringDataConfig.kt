package com.lubycon.devti

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.extensions.Extension
import io.kotest.spring.SpringAutowireConstructorExtension
import io.kotest.spring.SpringListener
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@DataJpaTest
@Import(TestQueryDslConfig::class)
@EntityScan(basePackages = ["com.lubycon.devti.domain"])
@EnableJpaRepositories(basePackages = ["com.lubycon.devti.domain"])
class SpringDataConfig : AbstractProjectConfig() {
    override fun listeners() = listOf(SpringListener)

    override fun extensions(): List<Extension> = listOf(SpringAutowireConstructorExtension)
}

