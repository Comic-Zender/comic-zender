package org.zender.comic.container.config.id.generator;

import org.zender.comic.domain.author.id.generator.AuthorIdGenerator;
import org.zender.common.domain.valueobjects.author.AuthorId;
import org.zender.common.utils.snowflake.Snowflake;

public class AuthorIdGeneratorImpl implements AuthorIdGenerator {
    private final Snowflake snowflake;

    public AuthorIdGeneratorImpl() {
        this.snowflake = new Snowflake();
    }

    @Override
    public AuthorId invoke() {
        return new AuthorId(snowflake.nextId());
    }
}
