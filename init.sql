DROP TABLE IF EXISTS messages;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS user_roles;
create table messages (
	id int(11) NOT NULL AUTO_INCREMENT,
	text varchar(140)  NOT NULL,
	datetime varchar(20) NOT NULL,
	username varchar(20) NOT NULL,
    PRIMARY KEY (id)
	);
CREATE  TABLE users (
  username VARCHAR(40) NOT NULL ,
  password VARCHAR(40) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  firstname VARCHAR(40) NOT NULL,
  lastname VARCHAR(40) NOT NULL,
  email VARCHAR(40) NOT NULL,
  PRIMARY KEY (username));
  
  CREATE TABLE user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (role,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username));
  
  INSERT INTO users(username,password,enabled,firstname,lastname,email)
  VALUES ('admin','password', true, 'Dmitry','Ivanov','divanov@mail.ru');
  INSERT INTO users(username,password,enabled,firstname,lastname,email)
  VALUES ('Alex','password', true, 'Aleksandr','Kvetko','mymail@gmail.com');
  INSERT INTO users(username,password,enabled,firstname,lastname,email)
  VALUES ('John17','password', true, 'John','Doe','johndoe@gmail.com');
  

INSERT INTO user_roles (username, role)
VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role)
VALUES ('Alex', 'ROLE_USER');
INSERT INTO user_roles (username, role)
VALUES ('John17', 'ROLE_USER');

INSERT INTO messages (text, datetime, username)
VALUES ('Привет!', '16:29 10.08.2016', 'Alex');
INSERT INTO messages (text, datetime, username)
VALUES ('Alex, English please', '16:32 10.08.2016', 'admin');
INSERT INTO messages (text, datetime, username)
VALUES ('Sorry', '16:33 10.08.2016', 'Alex');
INSERT INTO messages (text, datetime, username)
VALUES ('Hello!', '16:33 10.08.2016', 'Alex');
INSERT INTO messages (text, datetime, username)
VALUES ('Does anybody want to listen my new mixtape?', '16:34 10.08.2016', 'Alex');
INSERT INTO messages (text, datetime, username)
VALUES ('I do. Send me a link to my email, you can find it in my profile', '17:29 10.08.2016', 'John17');
INSERT INTO messages (text, datetime, username)
VALUES ('John17, Done!', '17:46 10.08.2016', 'Alex');
