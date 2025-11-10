# prueba-tecnica-sistema-loteria
Sistema de ventas de loteria desarrollado en spring boot y angular para la prueba tecnica

## Backend
- Java + Spring Boot, base H2
- Endpoints principales:
  /sorteos [GET, POST]
  /billetes [GET, POST]
  /clientes [GET, POST]
  /venta [POST]

  ### Base de datos
- La base de datos H2 se carga automaticamente al iniciar la aplicacion.
- Los datos de ejemplo estan en `src/main/resources/data.sql` y se ejecutan automaticamente al levantar la aplicacion.


## Frontend
- Angular
- Funcionalidades:
  - Listado de sorteos y billetes
  - Registrar clientes
  - Vender billetes
  - Historial de ventas por cliente

## Cómo ejecutar
### 1. Backend
1. Abrir terminal en la carpeta `backend`.
2. Ejecutar:mvn spring-boot:run
3. verificar en http://localhost:8080


### 2. Frontend:
1. Abrir terminal en la carpeta `frontend/sistemas-ventas-frontend`.
2. npm install
3. ng serve --open
4. verificar en http://localhost:4200

