-- script de creacion de tablas y datos iniciales

-- limpair las tablas
DELETE FROM billetes;
DELETE FROM clientes;
DELETE FROM sorteos;

-- Reiniciar auto-increment en H2
ALTER TABLE sorteos ALTER COLUMN id RESTART WITH 1;
ALTER TABLE clientes ALTER COLUMN id RESTART WITH 1;
ALTER TABLE billetes ALTER COLUMN id RESTART WITH 1;

-- Sorteos
INSERT INTO sorteos (nombre_sorteo, fecha_sorteo) 
VALUES ('Lotería de Medellín', '2025-11-09');

INSERT INTO sorteos (nombre_sorteo, fecha_sorteo) 
VALUES ('Lotería de Bogotá', '2025-11-10');

-- Clientes
INSERT INTO clientes (nombre_cliente, correo_cliente) 
VALUES ('Bryan Benavides', 'Bryan@gmail.com');

INSERT INTO clientes (nombre_cliente, correo_cliente) 
VALUES ('David Gallego', 'David@gmail.com');

-- Billetes disponibles
INSERT INTO billetes (numero, precio, estado, sorteo_id) 
VALUES ('001', 21000, 'DISPONIBLE', 1);

INSERT INTO billetes (numero, precio, estado, sorteo_id) 
VALUES ('002', 30000, 'DISPONIBLE', 2);

-- Billetes vendidos (para historial)
INSERT INTO billetes (numero, precio, estado, fecha_venta, sorteo_id, cliente_id) 
VALUES ('003', 25000, 'VENDIDO', '2025-11-09T10:00:00', 1, 1);

INSERT INTO billetes (numero, precio, estado, fecha_venta, sorteo_id, cliente_id) 
VALUES ('004', 22000, 'VENDIDO', '2025-11-10T15:30:00', 2, 2);
