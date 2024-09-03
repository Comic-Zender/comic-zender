CREATE TABLE IF NOT EXISTS authors (
    id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL ,
    date_of_birth DATE NOT NULL,
    created_at TIMESTAMP(6) WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP(6) WITH TIME ZONE,
    deleted_at TIMESTAMP(6) WITH TIME ZONE,
    CONSTRAINT pk_authors PRIMARY KEY (id)
)