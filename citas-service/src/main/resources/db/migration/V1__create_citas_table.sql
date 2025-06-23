CREATE TABLE citas (
                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       fecha DATE NOT NULL,
                       paciente VARCHAR(255) NOT NULL,
                       doctor_id BIGINT NOT NULL,
                       estado VARCHAR(50) NOT NULL,
                       notas TEXT,
                       hora TIME NOT NULL
);