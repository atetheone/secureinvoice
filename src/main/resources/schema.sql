
CREATE SCHEMA IF NOT EXISTS secureinvoice;

SET NAMES 'UTF8MB4';
SET TIME_ZONE = 'UTC';

USE secureinvoice;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
    user_id     BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name  VARCHAR(50) NOT NULL,
    last_name   VARCHAR(50) NOT NULL,
    password    VARCHAR(255) NOT NULL,
    email       VARCHAR(100) NOT NULL UNIQUE,
    address     VARCHAR(255) NOT NULL,
    phone       VARCHAR(20) NOT NULL,
    title       VARCHAR(50) NOT NULL,
    bio         VARCHAR(255) NOT NULL,
    enabled     BOOLEAN DEFAULT FALSE,
    non_locked  BOOLEAN DEFAULT TRUE,
    using_mfa   BOOLEAN DEFAULT FALSE,
    image_url   VARCHAR(255) DEFAULT 'https://img.icons8.com/?size=100&id=23264&format=png&color=000000',
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


DROP TABLE IF EXISTS roles;

CREATE TABLE roles (
    role_id     BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(50) NOT NULL UNIQUE,
    permission  VARCHAR(255) NOT NULL -- user:read, user:write, user:delete
);

DROP TABLE IF EXISTS users_roles;

CREATE TABLE users_roles (
    user_id     BIGINT UNSIGNED NOT NULL,
    role_id     BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (role_id) REFERENCES roles (role_id) ON DELETE RESTRICT ON UPDATE CASCADE
);