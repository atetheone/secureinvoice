
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

DROP TABLE IF EXISTS user_roles;

CREATE TABLE user_roles (
    user_role_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id     BIGINT UNSIGNED NOT NULL,
    role_id     BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (role_id) REFERENCES roles (role_id) ON DELETE RESTRICT ON UPDATE CASCADE
);

DROP TABLE IF EXISTS events;

CREATE TABLE events (
    event_id    BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    type       VARCHAR(50) NOT NULL UNIQUE CHECK ( type IN (
                                                            'LOGIN_ATTEMPT',
                                                            'LOGIN_ATTEMPT_FAILURE',
                                                            'LOGIN_ATTEMPT_SUCCESS',
                                                            'PROFILE_UPDATE',
                                                            'PROFILE_PICTURE_UPDATE',
                                                            'ROLE_UPDATE',
                                                            'ACCOUNT_SETTINGS_UPDATE',
                                                            'PASSWORD_UPDATE',
                                                            'MFA_UPDATE'
    )),
    description VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS user_events;

CREATE TABLE user_events (
    user_event_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id     BIGINT UNSIGNED NOT NULL,
    event_id    BIGINT UNSIGNED NOT NULL,
    device     VARCHAR(100) DEFAULT NULL,
    ip_address  VARCHAR(50) DEFAULT NULL,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (event_id) REFERENCES events (event_id) ON DELETE RESTRICT ON UPDATE CASCADE
);