-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema competicionfiadb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema competicionfiadb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `competicionfiadb` DEFAULT CHARACTER SET utf8;
USE `competicionfiadb` ;

-- -----------------------------------------------------
-- Table `competicionfiadb`.`campeonato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `competicionfiadb`.`campeonato` (
  `idCampeonato` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCampeonato`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `competicionfiadb`.`escuderias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `competicionfiadb`.`escuderias` (
  `idEscuderias` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `FundadaAno` INT NULL DEFAULT NULL,
  `imagen` MEDIUMBLOB NULL DEFAULT NULL,
  `idCampeonato` INT NOT NULL,
  `Pais` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEscuderias`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE,
  INDEX `fk_Escuderias_campeonato_idx` (`idCampeonato` ASC) VISIBLE,
  CONSTRAINT `fk_Escuderias_campeonato`
    FOREIGN KEY (`idCampeonato`)
    REFERENCES `competicionfiadb`.`campeonato` (`idCampeonato`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
