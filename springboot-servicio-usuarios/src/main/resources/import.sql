INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('andres', '$2a$10$n989rDinFObxGK6fEu9kY.WiIkIMHZ.dUMhmt30XDcjNVzmQZ3pbu', 1, 'andres', 'Guzman', 'profesor@bolsaideas.com');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('admin',  '$2a$10$5OvFAzaE1fMIH5SoiahzmeeGp7rzAKGu1Gy1YIXqAX7790ze8Occe', 1, 'admin', 'Serrano', 'chema.serrano@bolsaideas.com');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1,1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2,2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2,1);