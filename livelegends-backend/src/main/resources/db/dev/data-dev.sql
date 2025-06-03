USE livelegends_dev;

INSERT IGNORE INTO admins (id, email, password, role)
VALUES (1, 'test@livelegends.fr', 'root', 'ADMIN'),
       (2, 'support@livelegends.fr', 'root','SUPPORT'),
       (3, 'user@livelegends.fr', 'root','USER')
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



INSERT IGNORE INTO matchs (id, roster_1_id, roster_2_id, winner, duration, score, status, date_match, heure) VALUES
            (1, 1, 2, 'Natus Vincere', '38:12', '16-11', 'Fini', '2025-05-10', '15:00'),
            (2, 2, 3, 'Team Vitality', '40:00', '14-16', 'En cours', '2025-06-03', '16:30'),
            (3, 3, 4, 'FaZe Clan', '36:45', '13-16', 'En cours', '2025-06-03', '18:00'),
            (4, 1, 4, 'Natus Vincere', '33:15', '16-10', 'Pas commencé', '2025-06-01', '14:00'),
            (5, 2, 4, 'FaZe Clan', '45:25', '17-19', 'Fini', '2025-05-25', '17:45'),
            (6, 1, 3, 'Team Vitality', '41:10', '12-16', 'Fini', '2025-06-02', '19:15');