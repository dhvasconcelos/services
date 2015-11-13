/*DROP DATABASE IF EXISTS academia;
CREATE database academia;*/
USE academia;

CREATE TABLE bootcamp(
  bootcamp_id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(64) UNIQUE,
  start_date DATE,
  end_date DATE
);

CREATE TABLE user(
  user_id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(64) UNIQUE NOT NULL,
  password VARCHAR(64) NOT NULL,
  email VARCHAR(255) NOT NULL,
  bootcamp_id INT,
  FOREIGN KEY user(bootcamp_id) REFERENCES bootcamp(bootcamp_id)
);

CREATE TABLE role(
  role_id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(64) NOT NULL UNIQUE,
  description VARCHAR(255) NOT NULL
);

CREATE TABLE user_role(
  user_role_id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT NOT NULL,
  role_id INT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES user(user_id),
  FOREIGN KEY (role_id) REFERENCES role(role_id),
  UNIQUE (user_id,role_id)
);

CREATE TABLE permission(
  permission_id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(64) NOT NULL UNIQUE,
  description VARCHAR(255)
);

CREATE TABLE resource(
  resource_id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(64) NOT NULL UNIQUE,
  description VARCHAR(255)
);

CREATE TABLE user_resource_permission(
  user_resource_permission_id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT NOT NULL,
  resource_id INT NOT NULL,
  permission_id INT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES user(user_id),
  FOREIGN KEY (resource_id) REFERENCES resource(resource_id),
  FOREIGN KEY (permission_id) REFERENCES permission(permission_id),
  UNIQUE (user_id,resource_id,permission_id)
);

CREATE TABLE role_resource_permission(
  role_resource_permission_id INT PRIMARY KEY AUTO_INCREMENT,
  role_id INT NOT NULL,
  resource_id INT NOT NULL,
  permission_id INT NOT NULL,
  FOREIGN KEY (resource_id) REFERENCES resource(resource_id),
  FOREIGN KEY (role_id) REFERENCES role(role_id),
  FOREIGN KEY (permission_id) REFERENCES permission(permission_id),
  UNIQUE (resource_id,role_id,permission_id)
);

CREATE TABLE assignment_type(
  assignment_type_id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(64) NOT NULL UNIQUE,
  description VARCHAR(255)
);

CREATE TABLE assignment(
  assignment_id INT PRIMARY KEY AUTO_INCREMENT,
  assignment_type_id INT,
  bootcamp_id INT,
  creation_date DATE,
  title VARCHAR(255),
  FOREIGN KEY (assignment_type_id) REFERENCES assignment_type(assignment_type_id),
  FOREIGN KEY (bootcamp_id) REFERENCES bootcamp(bootcamp_id)
);

CREATE TABLE deliverable(
  deliverable_id INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(64),
  user_id INT,
  assign_date DATE,
  delivery_date DATE,
  url VARCHAR(255),
  approved BOOLEAN DEFAULT 0 NOT NULL,
  FOREIGN KEY (user_id) REFERENCES user(user_id)
);

CREATE TABLE tag(
  tag_id INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE deliverable_tag(
  deliverable_tag_id INT PRIMARY KEY AUTO_INCREMENT,
  deliverable_id INT,
  tag_id INT,
  FOREIGN KEY (deliverable_id) REFERENCES deliverable(deliverable_id),
  FOREIGN KEY (tag_id) REFERENCES tag(tag_id),
  UNIQUE (deliverable_id, tag_id)
);

CREATE TABLE assignment_deliverable(
  assignment_deliverable_id INT PRIMARY KEY AUTO_INCREMENT,
  assignment_id INT NOT NULL,
  deliverable_id INT NOT NULL,
  FOREIGN KEY (assignment_id) REFERENCES assignment(assignment_id),
  FOREIGN KEY (deliverable_id) REFERENCES deliverable(deliverable_id),
  UNIQUE (assignment_id, deliverable_id)
);