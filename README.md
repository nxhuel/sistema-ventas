 # Sistema de Ventas
Para este proyecto se siguió el **Proceso Unificado**  [+Info](https://es.wikipedia.org/wiki/Proceso_unificado)


# Inicio

## Requerimientos funcionales

- Gestionar usuarios/clientes, productos, categorías y ventas
- Reportes por día/mes
- Productos mas vendidos
- Control de Stock

## Requerimientos técnicos

**Front-End** Html5, SCSS, TypeScript + Angular, Bootstrap v5

**Back-End** Java 17 + Spring Boot, Spring Security + JWT, JUnit + Mockito

**Base de Datos** MySQL

**Despliegue** Jar + Docker

## Casos de Uso general 
<img width="675" height="1956" alt="image" src="https://github.com/user-attachments/assets/40b0541f-c8b3-45c7-8ea2-52011f5e9e76" />

# Elaboración

## Diagrama de clases
<img width="616" height="575" alt="image" src="https://github.com/user-attachments/assets/e5853491-2b32-4d3b-bbd3-8dc99ac85f12" />

## Diagrama Entidad-Relación
<img width="1510" height="756" alt="image" src="https://github.com/user-attachments/assets/86bf43e0-9f59-45c6-b50c-86778ad741de" />

## Arquitectura

Hexagonal + Vertical Slicing

# Construcción

## Endpoints
### Users
```
POST /user/v1/api HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 139

{
    "firstName": "",
    "lastName": "",
    "email": "",
    "password": ""
}
---
GET /user/v1/api HTTP/1.1
Host: localhost:8080
[
    {
        "id": 0,
        "firstName": "",
        "lastName": "",
        "email": "",
        "role": ""
    }
]
---
GET /user/v1/api/0 HTTP/1.1
Host: localhost:8080
{
    "id": 0,
    "firstName": "",
    "lastName": "",
    "email": "",
    "role": ""
}
---
PUT /user/v1/api/12 HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 139

{
    "firstName": "",
    "lastName": "",
    "email": "",
    "password": ""
}
---
PATCH /user/v1/api/12 HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 61
{
    "firstName": "",
    "lastName": ""
}
---
DELETE /user/v1/api/11 HTTP/1.1
Host: localhost:8080
```

### Category

### Products


# Transición

## Despliegue y como hacer uso del sistema

