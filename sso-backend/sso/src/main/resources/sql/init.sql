DROP DATABASE IF EXISTS user;
CREATE DATABASE demo_permission;
USE demo_permission;

DROP TABLE IF EXISTS user;

CREATE TABLE user(
  user_id INT(11) PRIMARY KEY AUTO_INCREMENT,
  user_name VARCHAR(255),
  password VARCHAR(255)
);

INSERT INTO user(user_name, password) VALUES
('eugene', 'abc123_'),
('zhangsan', 'qweqwe'),
('lisi', 'asdasd');