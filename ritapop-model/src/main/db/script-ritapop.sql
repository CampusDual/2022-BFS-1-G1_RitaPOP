-- Aquí iremos pegando las modificaciones que hagamos en la base de datos creando dos comentarios para acotar los cambios realizados para una nueva historia

-- INICIO Cambios para FG4-28 FECHA: 01-07-2022 13:40
-- creacion de tablas

CREATE TABLE CLIENT (
	ID INTEGER NOT NULL,
	NAME VARCHAR(30) NOT NULL,
	SURNAME VARCHAR(150) NOT NULL,
	NIF CHAR(9) NOT NULL,
	BIRTH_DATE DATE,
	CONSTRAINT CLI_PK PRIMARY KEY (ID),
	CONSTRAINT CLI_CH CHECK (BIRTH_DATE > '1800-01-01')
);

CREATE TABLE TRANSACTIONS (
	ID INTEGER NOT NULL,
	SELLER_CLI INTEGER,
	BUYER_CLI INTEGER,
	START_DATE DATE NOT NULL,
	END_DATE DATE,
	PRICE FLOAT NOT NULL,
	PRODUCT_NAME VARCHAR(80) NOT NULL,
	PRODUCT_CATEGORY VARCHAR(80) NOT NULL,
	CONSTRAINT TRA_PK PRIMARY KEY (ID),
	CONSTRAINT TRA_CLI1 FOREIGN KEY (SELLER_CLI) REFERENCES CLIENT(ID),
	CONSTRAINT TRA_CLI2 FOREIGN KEY (BUYER_CLI) REFERENCES CLIENT(ID)
);

-- insercion de datos

INSERT INTO PUBLIC.CLIENT VALUES (1, 'DONATO', 'RAMOS MARTINEZ', '92444802M', '1973-01-16');
INSERT INTO PUBLIC.CLIENT VALUES (2, 'JAVIER', 'FANDINO CASAL', '01275066S', '1989-09-16');

-- FIN cambios para FG4-28 FECHA: 01-07-2022 15:00


-- INICIO Cambios para FG4-28 FECHA: 04-07-2022 13:40
-- insercion de datos
INSERT INTO PUBLIC.CLIENT VALUES (3, 'CINTA', 'TAFUR', '03144239R', '1979-01-16');
INSERT INTO PUBLIC.CLIENT VALUES (4, 'TOMAS', 'CARRALERO', '28832909V', '1981-09-16');
INSERT INTO PUBLIC.TRANSACTIONS VALUES (1, 1, 2, '2022-07-04', NULL, 120.50, 'RATON', 'PC');
INSERT INTO PUBLIC.TRANSACTIONS VALUES (2, 3, 4, '2022-06-30', '2022-07-04', 1000, 'PORTATIL', 'PC');

-- FIN cambios para FG4-28 FECHA: 04-07-2022 15:00
  
-- INICIO Cambios para FG4-2 FECHA: 07-07-2022 10:40

-- CREAR COLUMNAS DE TABLA CLIENT
ALTER TABLE PUBLIC.CLIENT ADD PURCHASES INTEGER;
ALTER TABLE PUBLIC.CLIENT ADD SALES INTEGER;
ALTER TABLE PUBLIC.CLIENT ADD VIP BOOLEAN;
-- actualizar datos de tabla client
UPDATE PUBLIC.CLIENT SET PURCHASES = 10, SALES = 50, VIP = TRUE WHERE ID = 1;
UPDATE PUBLIC.CLIENT SET PURCHASES = 15, SALES = 100, VIP = TRUE WHERE ID = 2;
UPDATE PUBLIC.CLIENT SET PURCHASES = 16, SALES = 6, VIP = FALSE WHERE ID = 3;
UPDATE PUBLIC.CLIENT SET PURCHASES = 25, SALES = 8, VIP = FALSE WHERE ID = 4;

-- FIN cambios para FG4-2 FECHA: 07-07-2022 15:00
-- INICIO Cambios para FG4-26 FECHA: 08-07-2022 14:34
INSERT INTO PUBLIC.TRANSACTIONS VALUES (3, 3, 4, '2021-06-30', '2021-07-04', 800, 'TELEFONO', 'TELEFONO');

-- Crea la columna de permisos por defecto
ALTER TABLE PUBLIC.TROLE ADD PERMISSIONS VARCHAR(16777216) DEFAULT '{"menu": [{"attr": "home","visible": false,"enabled": false},{"attr": "client","visible": false,"enabled": false},{"attr": "transaction","visible": false,"enabled": false},{"attr": "logout","visible": false,"enabled": false}]}' NOT NULL;
-- Modifica los permisos de administrador
UPDATE PUBLIC.TROLE
SET PERMISSIONS = ('{"menu": [{"attr": "home","visible": true,"enabled": true},{"attr": "client","visible": true,"enabled": true},{"attr": "transaction","visible": true,"enabled": true},{"attr": "logout","visible": true,"enabled": true}]}')
WHERE ROLENAME = 'admin';
-- Crea el rol de gestor
INSERT INTO PUBLIC.TROLE (ROLENAME, XMLCLIENTPERMISSION)
VALUES ('gestor', '<?xml version="1.0" encoding="UTF-8"?><security></security>');
-- Modifica los permisos de gestor
UPDATE PUBLIC.TROLE
SET PERMISSIONS = ('{"menu": [{"attr": "home","visible": true,"enabled": true},{"attr": "client","visible": true,"enabled": true},{"attr": "transaction","visible": true,"enabled": true},{"attr": "logout","visible": true,"enabled": true}]}')
WHERE ROLENAME = 'gestor';

-- FIN Cambios para FG4-26 FECHA: 08-07-2022 15:00
    