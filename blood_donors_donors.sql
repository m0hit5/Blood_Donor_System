DROP TABLE IF EXISTS `donors`;

CREATE TABLE `donors` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `age` int NOT NULL,
  `weight` decimal(5,2) NOT NULL,
  `days_since_last_donation` int NOT NULL,
  `pulse` int NOT NULL,
  `systolic_pressure` int NOT NULL,
  `dystolic_pressure` int NOT NULL,
  `blood_group` varchar(5) NOT NULL,
  `temperature` decimal(4,2) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ;

DELIMITER ;;

CREATE TRIGGER `check_first_name_length` 
BEFORE INSERT ON `donors` 
FOR EACH ROW 
BEGIN
  IF LENGTH(NEW.first_name) < 2 THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'First name must be at least 2 characters long.';
  END IF;
END;;

CREATE TRIGGER `check_last_name_length` 
BEFORE INSERT ON `donors` 
FOR EACH ROW 
BEGIN
  IF LENGTH(NEW.last_name) < 2 THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Last name must be at least 2 characters long.';
  END IF;
END;;

CREATE TRIGGER `check_age` 
BEFORE INSERT ON `donors` 
FOR EACH ROW 
BEGIN
  IF NEW.age < 18 OR NEW.age > 50 THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Donor age must be between 18 and 50.';
  END IF;
END;;

CREATE TRIGGER `check_weight` 
BEFORE INSERT ON `donors` 
FOR EACH ROW 
BEGIN
  IF NEW.weight < 45 THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Donor weight must be at least 45 kilograms.';
  END IF;
END;;

CREATE TRIGGER `check_pulse` 
BEFORE INSERT ON `donors` 
FOR EACH ROW 
BEGIN
  IF NEW.pulse < 50 OR NEW.pulse > 100 THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Pulse must be between 50 and 100.';
  END IF;
END;;

CREATE TRIGGER `check_systolic_pressure` 
BEFORE INSERT ON `donors` 
FOR EACH ROW 
BEGIN
  IF NEW.systolic_pressure >= 120 THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Systolic pressure must be less than 120.';
  END IF;
END;;

CREATE TRIGGER `check_dystolic_pressure` 
BEFORE INSERT ON `donors` 
FOR EACH ROW 
BEGIN
  IF NEW.dystolic_pressure >= 80 THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Dystolic pressure must be less than 80.';
  END IF;
END;;

CREATE TRIGGER `check_blood_group` 
BEFORE INSERT ON `donors` 
FOR EACH ROW 
BEGIN
  IF NEW.blood_group NOT IN ('A+', 'A-', 'B+', 'B-', 'O+', 'O-', 'AB+', 'AB-') THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Invalid blood group.';
  END IF;
END;;

CREATE TRIGGER `check_temperature` 
BEFORE INSERT ON `donors` 
FOR EACH ROW 
BEGIN
  IF NEW.temperature >= 37.5 THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Temperature must be less than 37.5.';
  END IF;
END;;

CREATE TRIGGER `check_phone_number` 
BEFORE INSERT ON `donors` 
FOR EACH ROW 
BEGIN
  IF LENGTH(NEW.phone) != 10 THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Phone number must be 10 digits long.';
  END IF;
END;;

CREATE TRIGGER `check_email` 
BEFORE INSERT ON `donors` 
FOR EACH ROW 
BEGIN
  IF NEW.email NOT REGEXP '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$' THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Invalid email format.';
  END IF;
END;;

CREATE TRIGGER `check_not_null` 
BEFORE INSERT ON `donors` 
FOR EACH ROW 
BEGIN
  IF NEW.first_name IS NULL OR NEW.last_name IS NULL OR NEW.age IS NULL OR NEW.weight IS NULL OR
    NEW.days_since_last_donation IS NULL OR NEW.pulse IS NULL OR NEW.systolic_pressure IS NULL OR
    NEW.dystolic_pressure IS NULL OR NEW.blood_group IS NULL OR NEW.temperature IS NULL OR
    NEW.phone IS NULL OR NEW.email IS NULL THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'All entries must have a value.';
  END IF;
END;;

CREATE TRIGGER `check_days_since_last_donation` 
BEFORE INSERT ON `donors` 
FOR EACH ROW 
BEGIN
  IF NEW.days_since_last_donation <= 120 THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Days since last donation must be more than 120.';
  END IF;
END;;
