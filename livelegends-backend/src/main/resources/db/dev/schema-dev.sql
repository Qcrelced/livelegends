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
);

CREATE TABLE IF NOT EXISTS rosters(
  id INT AUTO_INCREMENT PRIMARY KEY,
  team_name VARCHAR(255)
);


CREATE TABLE IF NOT EXISTS matchs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    roster_1_id INT,
    roster_2_id INT,
    winner VARCHAR(255),
    duration VARCHAR(255),
    score VARCHAR(255),
    status VARCHAR(255),
    CONSTRAINT fk_roster_1 FOREIGN KEY (roster_1_id) REFERENCES rosters(id),
    CONSTRAINT fk_roster_2 FOREIGN KEY (roster_2_id) REFERENCES rosters(id)
);

CREATE TABLE IF NOT EXISTS players(
    id INT AUTO_INCREMENT PRIMARY KEY,
    pseudo VARCHAR(255),
    roster_id INT,
    CONSTRAINT fk_roster FOREIGN KEY (roster_id) REFERENCES rosters(id)
);

