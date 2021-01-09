INSERT INTO user (username,nick_name, password, enabled) VALUES ('admin', 'Zakir', '$2a$10$i0o4WYaExzKQN3Ojh46qB.EGd/SwBWqHZIo1xF.3K3xapeeXQado6', true); -- password is 123
INSERT INTO user (username,nick_name, password, enabled) VALUES ('user', 'User 1', '$2a$10$i0o4WYaExzKQN3Ojh46qB.EGd/SwBWqHZIo1xF.3K3xapeeXQado6', true); -- password is 123

INSERT INTO role (role_name) VALUES ('ROLE_USER');
INSERT INTO role (role_name) VALUES ('ROLE_ADMIN');

INSERT INTO user_role (user_id,role_id) VALUES (1, 1);
INSERT INTO user_role  (user_id,role_id) VALUES (2, 2);

INSERT INTO oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, authorities, access_token_validity, refresh_token_validity, autoapprove) VALUES ('spring-boot-rest-read-write-client', 'spring-boot-rest-api', '$2a$04$cxpFWusuwHxDwFHn8DC2DeyYk4YJd49jB9WcZhiacDybUx123G/aa', 'read,write', 'password,authorization_code,refresh_token,implicit', 'USER', '108000', '200000', 1);
