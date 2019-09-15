create table if not exists oauth_client_details
(
    client_id               VARCHAR(256) PRIMARY KEY,
    resource_ids            VARCHAR(256),
    client_secret           VARCHAR(256),
    scope                   VARCHAR(256),
    authorized_grant_types  VARCHAR(256),
    web_server_redirect_uri VARCHAR(256),
    authorities             VARCHAR(256),
    access_token_validity   INTEGER,
    refresh_token_validity  INTEGER,
    additional_information  VARCHAR(4096),
    autoapprove             VARCHAR(256)
);

create table if not exists oauth_client_token
(
    token_id          VARCHAR(255),
    token             bytea,
    authentication_id VARCHAR(255),
    user_name         VARCHAR(255),
    client_id         VARCHAR(255)
);

create table if not exists oauth_access_token
(
    token_id          VARCHAR(255),
    token             bytea,
    authentication_id VARCHAR(255),
    user_name         VARCHAR(255),
    client_id         VARCHAR(255),
    authentication    bytea,
    refresh_token     VARCHAR(255)
);

create table if not exists oauth_refresh_token
(
    token_id       VARCHAR(255),
    token          bytea,
    authentication bytea
);

create table if not exists oauth_code
(
    code           VARCHAR(255),
    authentication bytea
);

INSERT INTO role (id, name, description) VALUES (1, 'STANDARD_USER', 'Standard User');
INSERT INTO role (id, name, description) VALUES (2, 'ADMIN_USER', 'Admin User');

-- USER
-- non-encrypted password: jwtpass
INSERT INTO account (id, first_name, last_name, password, email, phone)
VALUES (1, 'Вася', 'Пупкин', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe',
        'vasya.pupkin@mail.ru', '9377776365');
INSERT INTO account (id, first_name, last_name, password, email, phone)
VALUES (2, 'Admin', 'Admin', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe',
        'admin.admin@mail.ru', '9999999999');


INSERT INTO account_roles(account_id, role_id) VALUES(1,1);
INSERT INTO account_roles(account_id, role_id) VALUES(2,1);
INSERT INTO account_roles(account_id, role_id) VALUES(2,2);

INSERT INTO oauth_client_details
(client_id, client_secret, scope, authorized_grant_types,
 authorities, access_token_validity, refresh_token_validity)
VALUES ('testjwtclientid', 'XY7kmzoNzl100', 'read,write',
        'password,refresh_token,client_credentials,authorization_code',
        'ROLE_CLIENT,ROLE_TRUSTED_CLIENT', 900, 2592000);