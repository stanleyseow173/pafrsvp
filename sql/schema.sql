CREATE TABLE `rsvp` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `phone` VARCHAR(12) NULL,
  `confirmation_date` DATETIME NOT NULL,
  `comments` VARCHAR(20) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);


INSERT INTO rsvp (name, email, phone, confirmation_date, comments, food_type) VALUES ('Kenneth', 'k@k.com', '123456', '2023/04/20', 'test','V');
INSERT INTO rsvp (name, email, phone, confirmation_date, comments, food_type) VALUES ('Kenneth2', 'k@k2.com', '123456', '2023/04/20', 'test','V');
INSERT INTO rsvp (name, email, phone, confirmation_date, comments, food_type) VALUES ('Kenneth3', 'k@k3.com', '123456', '2023/04/20', 'test','NV');
INSERT INTO rsvp (name, email, phone, confirmation_date, comments, food_type) VALUES ('Kenneth4', 'k@k4.com', '123456', '2023/04/20', 'test','V');
INSERT INTO rsvp (name, email, phone, confirmation_date, comments, food_type) VALUES ('Kenneth5', 'k@k5.com', '123456', '2023/04/20', 'test','NV');
INSERT INTO rsvp (name, email, phone, confirmation_date, comments, food_type) VALUES ('Kenneth6', 'k@k6.com', '123456', '2023/04/20', 'test','V');

ALTER TABLE `railway`.`rsvp` 
ADD COLUMN `food_type` VARCHAR(45) NOT NULL AFTER `comments`,
CHANGE COLUMN `comments` `comments` VARCHAR(200) NULL ;


