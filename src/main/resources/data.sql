DROP TABLE IF EXISTS utilisateur;
CREATE TABLE utilisateur (
                             id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                             first_name VARCHAR(50) NOT NULL,
                             last_name VARCHAR(50) NOT NULL,
                             mail VARCHAR(50) NOT NULL,
                             password VARCHAR(255) NOT NULL
);

INSERT INTO utilisateur (first_name, last_name, mail, password) VALUES
                                                                    ('Mathieu', 'Mithridate', 'mathieumith@test.com', '1234'),
                                                                    ('Jean', 'Albert', 'jeanalbert@test.fr', '1234'),
                                                                    ('Marie', 'Durand', 'mariedurand@mail.com', '1234');