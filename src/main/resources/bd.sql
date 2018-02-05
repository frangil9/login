-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema login
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema login
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `login` DEFAULT CHARACTER SET utf8 ;
USE `login` ;

-- -----------------------------------------------------
-- Table `login`.`profile`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `login`.`profile` (
  `profile_id` INT(11) NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`profile_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `login`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `login`.`user` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `last_name` VARCHAR(100) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `username` VARCHAR(50) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `active` TINYINT(1) NULL DEFAULT '1',
  `created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `login`.`user_profile`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `login`.`user_profile` (
  `user_id` INT(11) NOT NULL,
  `profile_id` INT(11) NOT NULL,
  PRIMARY KEY (`user_id`, `profile_id`),
  INDEX `fk_user_profile_user1_idx` (`user_id` ASC),
  INDEX `fk_user_profile_profile1_idx` (`profile_id` ASC),
  CONSTRAINT `fk_user_profile_profile1`
    FOREIGN KEY (`profile_id`)
    REFERENCES `login`.`profile` (`profile_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_profile_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `login`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
