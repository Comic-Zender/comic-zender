package org.zender.comic.container.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zender.comic.container.config.id.generator.AuthorIdGeneratorImpl;
import org.zender.comic.container.config.id.generator.CategoryIdGeneratorImpl;
import org.zender.comic.domain.author.id.generator.AuthorIdGenerator;
import org.zender.comic.domain.category.id.generator.CategoryIdGenerator;

@Configuration
public class BeanConfiguration {
    @Bean
    public CategoryIdGenerator categoryIdGenerator() {
        return new CategoryIdGeneratorImpl();
    }

    @Bean
    public AuthorIdGenerator authorIdGenerator() {
        return new AuthorIdGeneratorImpl();
    }
}
