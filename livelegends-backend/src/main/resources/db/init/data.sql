USE live_legends;

USE livelegends_dev;

INSERT IGNORE INTO admins (id, email, role)
VALUES (1, 'test@livelegends.fr', 'ADMIN'),
       (2, 'support@livelegends.fr', 'SUPPORT'),
       (3, 'user@livelegends.fr', 'USER')
;


INSERT IGNORE INTO rosters (teamName) VALUES
    ('Natus Vincere'),   -- ID 1
    ('G2 Esports'),      -- ID 2
    ('Team Vitality'),   -- ID 3
    ('FaZe Clan');

-- NAVI
INSERT IGNORE INTO players (pseudo, roster_id) VALUES
    ('s1mple', 1), ('electroNic', 1), ('b1t', 1), ('Perfecto', 1), ('npl', 1);

-- G2
INSERT IGNORE INTO players (pseudo, roster_id) VALUES
    ('NiKo', 2), ('huNter-', 2), ('m0NESY', 2), ('jks', 2), ('HooXi', 2);

-- Vitality
INSERT IGNORE INTO players (pseudo, roster_id) VALUES
    ('ZywOo', 3), ('apEX', 3), ('Spinx', 3), ('flameZ', 3), ('Misutaaa', 3);

-- Faze Clan
INSERT IGNORE INTO players (pseudo, roster_id) VALUES
    ('Twistzz', 4), ('rain', 4), ('ropz', 4), ('broky', 4), ('karrigan', 4);


INSERT IGNORE INTO matchs (id, roster_1_id, roster_2_id, winner, duration, score, status, datematch, heure) VALUES
            (1, 1, 2, 'Natus Vincere', '38:12', '16-11', 'Fini', '2025-05-10', '15:00'),
            (2, 2, 3, 'Team Vitality', '40:00', '14-16', 'En cours', '2025-06-03', '16:30'),
            (3, 3, 4, 'FaZe Clan', '36:45', '13-16', 'En cours', '2025-06-03', '18:00'),
            (4, 1, 4, 'Natus Vincere', '33:15', '16-10', 'Pas commencé', '2025-06-01', '14:00'),
            (5, 2, 4, 'FaZe Clan', '45:25', '17-19', 'Fini', '2025-05-25', '17:45'),
            (6, 1, 3, 'Team Vitality', '41:10', '12-16', 'Fini', '2025-06-02', '19:15');