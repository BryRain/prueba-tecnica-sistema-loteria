-- script de creacion de tablas y datos iniciales

-- Sorteos

INSERT INTO sorteos (id, nombre, fecha_sorteo) VALUES (1, 'loteria de medellin', '2025-11-09');
INSERT INTO sorteos (id, nombre, fecha_sorteo) VALUES (2, 'loteria de bogota', '2025-11-10');

--Clientes

INSERT INTO clientes (id, nombre, email) VALUES (1, 'Bryan Benavides', 'Bryan@gmail.com');
INSERT INTO clientes (id, nombre, email) VALUES (2, 'David Gallego', 'David@gmail.com');

--Billete 
--Billete para sorteo medellin y cliente Bryan
INSERT INTO Billetes (id, numero, precio, estado, sorteo_id)
VALUES (1, '001', 21000, 'DISPONIBLE', 1);

--Billete para sorteo bogota y cliente David
INSERT INTO Billetes (id, numero, precio, estado, sorteo_id)
VALUES (2, '002', 30000, 'DISPONIBLE', 2);

--billete vendido para el sorte de medellin a Bryan
INSERT INTO Billetes (id, numero, precio, estado, fecha_venta, sorteo_id, cliente_id)
VALUES (3, '003', 25000, 'VENDIDO', CURRENT_TIMESTAMP, 1, 1);

