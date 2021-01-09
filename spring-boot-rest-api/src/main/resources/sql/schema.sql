CREATE TABLE oauth_client_details (
  client_id varchar(200) NOT NULL PRIMARY KEY,
  resource_ids varchar(200) DEFAULT NULL,
  client_secret varchar(200) DEFAULT NULL,
  scope varchar(200) DEFAULT NULL,
  authorized_grant_types varchar(200) DEFAULT NULL,
  web_server_redirect_uri varchar(200) DEFAULT NULL,
  authorities varchar(200) DEFAULT NULL,
  access_token_validity int(11) DEFAULT NULL,
  refresh_token_validity int(11) DEFAULT NULL,
  additional_information varchar(4096) DEFAULT NULL,
  autoapprove varchar(200) DEFAULT NULL
);

