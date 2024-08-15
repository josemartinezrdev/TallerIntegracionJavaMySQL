-- GENERAL

DROP DATABASE IF EXISTS farmaciaDos;

CREATE DATABASE farmaciaDos;

USE farmaciaDos;

-- P1

CREATE TABLE country(
    codecountry VARCHAR(5),
    namecountry VARCHAR(50),

    CONSTRAINT pk_codecountry PRIMARY KEY (codecountry)
);

CREATE TABLE region(
    codereg VARCHAR(5),
    namereg VARCHAR(50),
    codecountry VARCHAR(5),

    CONSTRAINT pk_codereg PRIMARY KEY (codereg),
    CONSTRAINT fk_region_country FOREIGN KEY (codecountry) REFERENCES country (codecountry)
);


CREATE TABLE city(
    codecity VARCHAR(5),
    namecity VARCHAR(50),
    codereg VARCHAR(5),

    CONSTRAINT pk_codecity PRIMARY KEY (codecity),
    CONSTRAINT fk_city_region FOREIGN KEY (codereg) REFERENCES region (codereg)
);

CREATE TABLE customer(
    idcustomer VARCHAR(20),
    namecustomer VARCHAR(50),
    lastnamecustomer VARCHAR(50),
    emailcustomer VARCHAR(100),
    birthdate DATE,
    longitud DECIMAL(10, 2),
    latitud DECIMAL(10, 2),
    codecitycustomer VARCHAR(5),

    CONSTRAINT pk_idcustomer PRIMARY KEY (idcustomer),
    CONSTRAINT fk_customer_city FOREIGN KEY (codecitycustomer) REFERENCES city (codecity)
);

-- P2

CREATE TABLE modeadministration(
    id INT(4) AUTO_INCREMENT,
    descriptionmode VARCHAR(60),

    CONSTRAINT pk_id PRIMARY KEY (id)
);

CREATE TABLE laboratory(
    id INT(3) AUTO_INCREMENT,
    namelab VARCHAR(50),
    codecityreg VARCHAR(5),

    CONSTRAINT pk_id PRIMARY KEY (id),
    CONSTRAINT fk_laboratory_city FOREIGN KEY (codecityreg) REFERENCES city (codecity)
);

CREATE TABLE activeprinciple(
    idap INT(4) AUTO_INCREMENT,
    nameap VARCHAR(60),

    CONSTRAINT pk_idap PRIMARY KEY (idap)
);

CREATE TABLE unitmeasurement(
    idum INT(4) AUTO_INCREMENT,
    nameum VARCHAR(60),

    CONSTRAINT pk_idum PRIMARY KEY (idum)
);


CREATE TABLE medicine(
    id INT(4) AUTO_INCREMENT,
    proceedings VARCHAR(10),
    namemedicine VARCHAR(100),
    healthregister VARCHAR(50),
    description TEXT,
    descriptionshort VARCHAR(60),
    namerol VARCHAR(100),
    
    codemodeadmin INT(4),
    codeap INT(4),
    idum INT(4),
    codelab INT(4),

    CONSTRAINT pk_id PRIMARY KEY (id),
    CONSTRAINT fk_medicine_modeadministration FOREIGN KEY (codemodeadmin) REFERENCES modeadministration (id),
    CONSTRAINT fk_medicine_activeprinciple FOREIGN KEY (codeap) REFERENCES activeprinciple (idap),
    CONSTRAINT fk_medicine_unitmeasurement FOREIGN KEY (idum) REFERENCES unitmeasurement (idum),
    CONSTRAINT fk_medicine_laboratory FOREIGN KEY (codelab) REFERENCES laboratory (id)
);

CREATE TABLE farmacy(
    idfarmacy INT(4) AUTO_INCREMENT,
    namefarmacy VARCHAR(60),
    addresfarmacy VARCHAR(100),
    longitud DECIMAL(10, 2),
    latitud DECIMAL(10, 2),
    logofarmacy VARCHAR(100),
    codecityfarmacy VARCHAR(5),

    CONSTRAINT pk_idfarmacy PRIMARY KEY (idfarmacy),
    CONSTRAINT fk_farmacy_city FOREIGN KEY (codecityfarmacy) REFERENCES city (codecity)
);

CREATE TABLE farmacymedicine(
    idfarmacy INT(4),
    idmedicine INT(4),
    price DECIMAL(10, 2),

    CONSTRAINT fk_farmacymedicine_farmacy FOREIGN KEY (idfarmacy) REFERENCES farmacy (idfarmacy),
    CONSTRAINT fk_farmacymedicine_medicine FOREIGN KEY (idmedicine) REFERENCES medicine (id)
);