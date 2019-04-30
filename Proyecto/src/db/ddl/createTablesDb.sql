DROP TABLE IF EXISTS pagos;
DROP TABLE IF EXISTS empresas;
DROP TABLE IF EXISTS parqueaderos;

CREATE TABLE pagos (
	id int NOT NULL AUTO_INCREMENT,
	valorPago double NOT NULL,
	fechaPago varchar(255) NOT NULL,
   	mesAPagar varchar(255) NOT NULL,
	residente varchar(255) NOT NULL,
	PRIMARY KEY (id)
) ENGINE=INNODB;

CREATE TABLE empresas (
	nombre varchar(255) NOT NULL,
    tipoEmpresa varchar(255) NOT NULL,
    numeroContrato varchar(255) NOT NULL,
    telefono int NOT NULL,
    fechaInicio varchar(255) NOT NULL,
    fechaTerminacion varchar(255) NOT NULL,
    valorContrato double NOT NULL,
	PRIMARY KEY (numeroContrato)
) ENGINE=INNODB;

CREATE TABLE parqueaderos (
	numero int NOT NULL,
    numeroPiso int NULL,
    ocupante varchar(255) NOT NULL,
    visitante varchar(266) NULL,
    placa varchar(6) NOT NULL,
	PRIMARY KEY (numero)
) ENGINE=INNODB;