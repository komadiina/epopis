-- MySQL Script generated by MySQL Workbench
-- Fri May  3 15:40:58 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`MJESTO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`MJESTO` (
  `posta` VARCHAR(8) NOT NULL,
  `naziv` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`posta`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`POTROSAC`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`POTROSAC` (
  `PIB` VARCHAR(20) NOT NULL,
  `naziv` VARCHAR(45) NOT NULL,
  `MJESTO_posta` VARCHAR(8) NOT NULL,
  `telefon` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`PIB`),
  INDEX `fk_POTROSAC_MJESTO1_idx` (`MJESTO_posta` ASC) VISIBLE,
  CONSTRAINT `fk_POTROSAC_MJESTO1`
    FOREIGN KEY (`MJESTO_posta`)
    REFERENCES `mydb`.`MJESTO` (`posta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ORMAR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ORMAR` (
  `prikljucak` TINYINT NOT NULL,
  `brojilo` DECIMAL(8,2) NOT NULL,
  `iskljucen` TINYINT NOT NULL,
  `POTROSAC_PIB` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`POTROSAC_PIB`),
  CONSTRAINT `fk_ORMAR_POTROSAC1`
    FOREIGN KEY (`POTROSAC_PIB`)
    REFERENCES `mydb`.`POTROSAC` (`PIB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`SNABDJEVAC`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`SNABDJEVAC` (
  `idSnabdjevac` INT NOT NULL AUTO_INCREMENT,
  `naziv` VARCHAR(45) NOT NULL,
  `napon` DECIMAL(10,4) NOT NULL,
  `MJESTO_posta` VARCHAR(8) NOT NULL,
  `telefon` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`idSnabdjevac`),
  INDEX `fk_SNABDJEVAC_MJESTO1_idx` (`MJESTO_posta` ASC) VISIBLE,
  CONSTRAINT `fk_SNABDJEVAC_MJESTO1`
    FOREIGN KEY (`MJESTO_posta`)
    REFERENCES `mydb`.`MJESTO` (`posta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DISTRIBUTER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DISTRIBUTER` (
  `idDistributer` INT NOT NULL AUTO_INCREMENT,
  `naziv` VARCHAR(45) NOT NULL,
  `napon` DECIMAL(10,4) NOT NULL,
  `SNABDJEVAC_idSnabdjevac` INT NOT NULL,
  `MJESTO_posta` VARCHAR(8) NOT NULL,
  `telefon` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`idDistributer`),
  INDEX `fk_DISTRIBUTER_SNABDJEVAC1_idx` (`SNABDJEVAC_idSnabdjevac` ASC) VISIBLE,
  INDEX `fk_DISTRIBUTER_MJESTO1_idx` (`MJESTO_posta` ASC) VISIBLE,
  CONSTRAINT `fk_DISTRIBUTER_SNABDJEVAC1`
    FOREIGN KEY (`SNABDJEVAC_idSnabdjevac`)
    REFERENCES `mydb`.`SNABDJEVAC` (`idSnabdjevac`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DISTRIBUTER_MJESTO1`
    FOREIGN KEY (`MJESTO_posta`)
    REFERENCES `mydb`.`MJESTO` (`posta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ELEKTRICAR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ELEKTRICAR` (
  `JMBG` VARCHAR(15) NOT NULL,
  `ime` VARCHAR(16) NOT NULL,
  `prezime` VARCHAR(32) NOT NULL,
  `DISTRIBUTER_idDistributer` INT NOT NULL,
  PRIMARY KEY (`JMBG`),
  INDEX `fk_ELEKTRICAR_DISTRIBUTER_idx` (`DISTRIBUTER_idDistributer` ASC) VISIBLE,
  CONSTRAINT `fk_ELEKTRICAR_DISTRIBUTER`
    FOREIGN KEY (`DISTRIBUTER_idDistributer`)
    REFERENCES `mydb`.`DISTRIBUTER` (`idDistributer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`KNJIGOVODJA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`KNJIGOVODJA` (
  `JMBG` VARCHAR(15) NOT NULL,
  `PIB` VARCHAR(20) NOT NULL,
  `ime` VARCHAR(16) NOT NULL,
  `prezime` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`JMBG`),
  UNIQUE INDEX `PIB_UNIQUE` (`PIB` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DOKUMENT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DOKUMENT` (
  `idDokument` INT NOT NULL AUTO_INCREMENT,
  `poziv` VARCHAR(16) NOT NULL,
  `datumIzdavanja` DATE NOT NULL,
  `KNJIGOVODJA_JMBG` VARCHAR(15) NOT NULL,
  `POTROSAC_PIB` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idDokument`),
  INDEX `fk_DOKUMENT_KNJIGOVODJA1_idx` (`KNJIGOVODJA_JMBG` ASC) VISIBLE,
  INDEX `fk_DOKUMENT_POTROSAC1_idx` (`POTROSAC_PIB` ASC) VISIBLE,
  CONSTRAINT `fk_DOKUMENT_KNJIGOVODJA1`
    FOREIGN KEY (`KNJIGOVODJA_JMBG`)
    REFERENCES `mydb`.`KNJIGOVODJA` (`JMBG`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DOKUMENT_POTROSAC1`
    FOREIGN KEY (`POTROSAC_PIB`)
    REFERENCES `mydb`.`POTROSAC` (`PIB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`RACUN`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`RACUN` (
  `potroseno` DECIMAL(10,4) NOT NULL,
  `DOKUMENT_idDokument` INT NOT NULL,
  PRIMARY KEY (`DOKUMENT_idDokument`),
  INDEX `fk_RACUN_DOKUMENT1_idx` (`DOKUMENT_idDokument` ASC) VISIBLE,
  CONSTRAINT `fk_RACUN_DOKUMENT1`
    FOREIGN KEY (`DOKUMENT_idDokument`)
    REFERENCES `mydb`.`DOKUMENT` (`idDokument`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`OPOMENA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`OPOMENA` (
  `dugovanje` DECIMAL(6,3) NOT NULL,
  `rok` DATE NOT NULL,
  `DOKUMENT_idDokument` INT NOT NULL,
  PRIMARY KEY (`DOKUMENT_idDokument`),
  CONSTRAINT `fk_OPOMENA_DOKUMENT1`
    FOREIGN KEY (`DOKUMENT_idDokument`)
    REFERENCES `mydb`.`DOKUMENT` (`idDokument`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PREDRACUN`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PREDRACUN` (
  `potroseno` DECIMAL(6,2) NOT NULL,
  `idPredracun` INT NOT NULL AUTO_INCREMENT,
  `ELEKTRICAR_JMBG` VARCHAR(15) NOT NULL,
  `KNJIGOVODJA_JMBG` VARCHAR(15) NOT NULL,
  `POTROSAC_PIB` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idPredracun`),
  INDEX `fk_PREDRACUN_ELEKTRICAR1_idx` (`ELEKTRICAR_JMBG` ASC) VISIBLE,
  INDEX `fk_PREDRACUN_KNJIGOVODJA1_idx` (`KNJIGOVODJA_JMBG` ASC) VISIBLE,
  INDEX `fk_PREDRACUN_POTROSAC1_idx` (`POTROSAC_PIB` ASC) VISIBLE,
  CONSTRAINT `fk_PREDRACUN_ELEKTRICAR1`
    FOREIGN KEY (`ELEKTRICAR_JMBG`)
    REFERENCES `mydb`.`ELEKTRICAR` (`JMBG`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PREDRACUN_KNJIGOVODJA1`
    FOREIGN KEY (`KNJIGOVODJA_JMBG`)
    REFERENCES `mydb`.`KNJIGOVODJA` (`JMBG`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PREDRACUN_POTROSAC1`
    FOREIGN KEY (`POTROSAC_PIB`)
    REFERENCES `mydb`.`POTROSAC` (`PIB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ZAHTJEV`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ZAHTJEV` (
  `idZahtjev` INT NOT NULL AUTO_INCREMENT,
  `datum` DATE NOT NULL,
  `odobren` TINYINT NULL,
  `DISTRIBUTER_idDistributer` INT NOT NULL,
  `POTROSAC_PIB` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idZahtjev`),
  INDEX `fk_ZAHTJEV_DISTRIBUTER1_idx` (`DISTRIBUTER_idDistributer` ASC) VISIBLE,
  INDEX `fk_ZAHTJEV_POTROSAC1_idx` (`POTROSAC_PIB` ASC) VISIBLE,
  CONSTRAINT `fk_ZAHTJEV_DISTRIBUTER1`
    FOREIGN KEY (`DISTRIBUTER_idDistributer`)
    REFERENCES `mydb`.`DISTRIBUTER` (`idDistributer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ZAHTJEV_POTROSAC1`
    FOREIGN KEY (`POTROSAC_PIB`)
    REFERENCES `mydb`.`POTROSAC` (`PIB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ISKLJUCENJE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ISKLJUCENJE` (
  `ZAHTJEV_idZahtjev` INT NOT NULL,
  PRIMARY KEY (`ZAHTJEV_idZahtjev`),
  CONSTRAINT `fk_ISKLJUCENJE_ZAHTJEV1`
    FOREIGN KEY (`ZAHTJEV_idZahtjev`)
    REFERENCES `mydb`.`ZAHTJEV` (`idZahtjev`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PRIKLJUCENJE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PRIKLJUCENJE` (
  `ZAHTJEV_idZahtjev` INT NOT NULL,
  PRIMARY KEY (`ZAHTJEV_idZahtjev`),
  CONSTRAINT `fk_PRIKLJUCENJE_ZAHTJEV1`
    FOREIGN KEY (`ZAHTJEV_idZahtjev`)
    REFERENCES `mydb`.`ZAHTJEV` (`idZahtjev`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
