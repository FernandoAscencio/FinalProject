-- Final Project Database --
CREATE DATABASE IF NOT EXISTS final_project;
-- Choose this Database --
USE final_project;
-- Table Structure for Users --
CREATE TABLE users (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  login VARCHAR(255) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL,
  email VARCHAR(255) UNIQUE NOT NULL,
  type ENUM ('COMP', 'CAND'),
  location VARCHAR(255),
  role VARCHAR(255),
  phone VARCHAR(255),
  description VARCHAR(255),
  created_at TIMESTAMP
)ENGINE=InnoDB auto_increment=1 default charset=latin1;
-- Table for User Skills --
CREATE TABLE main_skills (
  id INT PRIMARY KEY auto_increment,
  user_id INT,
  skills TEXT,
  CONSTRAINT ms_user_fk FOREIGN KEY (user_id) REFERENCES users(id)
)ENGINE=InnoDB auto_increment=1 default charset=latin1;
-- Table for Work Experience --
CREATE TABLE work_experience (
  id INT PRIMARY KEY auto_increment,
  user_id INT,
  title VARCHAR(255),
  start_date DATE,
  end_date VARCHAR(255),
  description TEXT,
  CONSTRAINT we_user_fk FOREIGN KEY (user_id) REFERENCES users(id)
)ENGINE=InnoDB auto_increment=1 default charset=latin1;
-- Table for Education --
CREATE TABLE education (
  id INT PRIMARY KEY auto_increment,
  user_id INT,
  program VARCHAR(255),
  institute VARCHAR(255),
  start_date DATE,
  end_date VARCHAR(255),
  description TEXT,
  CONSTRAINT ed_user_fk FOREIGN KEY (user_id) REFERENCES users(id)
)ENGINE=InnoDB auto_increment=1 default charset=latin1;
-- Table for Jobs -- 
CREATE TABLE job (
  id INT PRIMARY KEY auto_increment,
  title VARCHAR(255),
  description TEXT,
  salary DECIMAL(13,2),
  type ENUM ('PERM', 'CONT', 'INTE', 'FREE'),
  req_skills TEXT,
  comp_id INT,
  city VARCHAR(255),
  created_at TIMESTAMP,
  end_date DATE,
  CONSTRAINT job_user_fk FOREIGN KEY (comp_id) REFERENCES users(id)
)ENGINE=InnoDB auto_increment=1 default charset=latin1;
-- Table for Applicants to a Job --
CREATE TABLE application (
	id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    job_id INT,
    CONSTRAINT app_user_fk FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT app_job_fk FOREIGN KEY (job_id) REFERENCES job(id)
)ENGINE=InnoDB auto_increment=1 default charset=latin1;

-- Drop Tables --
DROP TABLE users;
DROP TABLE main_skills;
DROP TABLE work_experience;
DROP TABLE education;
DROP TABLE job;
DROP TABLE application;
-- Reset Tables --
TRUNCATE TABLE users;
TRUNCATE TABLE main_skills;
TRUNCATE TABLE work_experience;
TRUNCATE TABLE education;
TRUNCATE TABLE job;
TRUNCATE TABLE application;
-- View Tables --
Select * from users;
Select * from main_skills;
Select * from work_experience;
Select * from education;
Select * from job;
Select * from application;
-- Deelting Entries --
delete from users where id = 3;