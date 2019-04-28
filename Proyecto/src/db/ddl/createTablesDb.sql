DROP TABLE IF EXISTS pagos;

CREATE TABLE pagos (
	id int NOT NULL AUTO_INCREMENT,
	valorPago double NOT NULL,
	fechaPago varchar(255) NOT NULL,
   	mesAPagar varchar(255) NOT NULL,
	residente varchar(255) NOT NULL,
	PRIMARY KEY (id)
) ENGINE=INNODB;

