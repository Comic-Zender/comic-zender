package org.zender.comic.container.config.id.generator;

import org.zender.comic.domain.category.id.generator.CategoryIdGenerator;
import org.zender.common.domain.valueobjects.category.CategoryId;
import org.zender.common.utils.snowflake.Snowflake;

public class CategoryIdGeneratorImpl implements CategoryIdGenerator {
    private final Snowflake snowflake;

    public CategoryIdGeneratorImpl() {
        this.snowflake = new Snowflake();
    }

    @Override
    public CategoryId invoke() {
        return new CategoryId(snowflake.nextId());
    }
}
