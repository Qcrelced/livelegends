USE livelegends_dev;

INSERT IGNORE INTO admins (id, email, role)
VALUES (1, 'test@livelegends.fr', 'ADMIN'),
       (2, 'support@livelegends.fr', 'SUPPORT'),
       (3, 'user@livelegends.fr', 'USER')
;


INSERT IGNORE INTO rosters VALUES
    (1, 'Natus Vincere'),   -- ID 1
    (2, 'G2 Esports'),      -- ID 2
    (3, 'Team Vitality'),   -- ID 3
    (4, 'FaZe Clan');

-- NAVI
INSERT IGNORE INTO players (id, pseudo, roster_id) VALUES
    (1, 's1mple', 1),
    (2, 'electroNic', 1),
    (3, 'b1t', 1),
    (4, 'Perfecto', 1),
    (5, 'npl', 1);


-- G2
INSERT IGNORE INTO players (id, pseudo, roster_id) VALUES
    (6, 'NiKo', 2),
    (7, 'huNter-', 2),
    (8, 'm0NESY', 2),
    (9, 'jks', 2),
    (10, 'HooXi', 2);


-- Vitality
INSERT IGNORE INTO players (id, pseudo, roster_id) VALUES
    (11, 'ZywOo', 3),
    (12, 'apEX', 3),
    (13, 'Spinx', 3),
    (14, 'flameZ', 3),
    (15, 'Misutaaa', 3);


-- Faze Clan
INSERT IGNORE INTO players (id, pseudo, roster_id) VALUES
    (16, 'Twistzz', 4),
    (17, 'rain', 4),
    (18, 'ropz', 4),
    (19, 'broky', 4),
    (20, 'karrigan', 4);



INSERT IGNORE INTO matchs (id, roster_1_id, roster_2_id, winner, duration, score) VALUES
 (1, 1, 2, 'Natus Vincere', '38:12', '16-11'),
 (2, 2, 3, 'Team Vitality', '40:00', '14-16');