USE livelegends_dev;

CREATE TABLE IF NOT EXISTS admins
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    email    VARCHAR(64) NOT NULL UNIQUE,
    password VARCHAR(255),
    role     VARCHAR(16)
);

CREATE TABLE IF NOT EXISTS users
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    email      VARCHAR(64) NOT NULL UNIQUE,
    first_name VARCHAR(64),
    last_name  VARCHAR(64),
    password   VARCHAR(255),
    role       VARCHAR(16)
)