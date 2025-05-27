USE livelegends_dev;

INSERT IGNORE INTO admins (id, email, role)
VALUES (1, 'test@livelegends.fr', 'ADMIN'),
       (2, 'support@livelegends.fr', 'SUPPORT'),
       (3, 'user@livelegends.fr', 'USER')
;