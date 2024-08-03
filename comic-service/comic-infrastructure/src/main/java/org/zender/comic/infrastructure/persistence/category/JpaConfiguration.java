package org.zender.comic.infrastructure.persistence.category;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@EnableJpaAuditing
@EntityScan(basePackages = "org.zender")
@EnableJpaRepositories(basePackages = "org.zender")
public class JpaConfiguration {
}
