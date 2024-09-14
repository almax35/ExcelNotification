DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    name character varying(40),
    surname character varying(40),
    email character varying(40),
    type character varying(40),
    CONSTRAINT pk1 PRIMARY KEY (id),
    CONSTRAINT uniq1 UNIQUE (email)
)