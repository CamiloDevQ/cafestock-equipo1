# cafestock-equipo1
CaféStock, Equipo 1, Escenario A

# CaféStock · Equipo 1 (Escenario A)

Aplicación de escritorio en Java para que Rosa, dueña de una cafetería, controle su inventario y registre sus ventas.

## Equipo

| Integrante | Rol |
|---|---|
| Jhayr Alexander Pazmiño Mena | Scrum Master |
| Abigail Rocio Becerra Bolaños | Product Owner |
| Deysi Abigail Guachamin Guauna | Desarrollador |
| Jasson Camilo Quirola Chicaiza | Desarrollador |

## Enlaces

- Tablero de Trello: https://trello.com/b/qjU7HtJc/equipo-1-caf%C3%A9stock-escenario-a
- Repositorio: https://github.com/JhayrAlex/cafestock-equipo1/tree/main                                                                          

## Historias de usuario del Sprint 1

- **HU-A1** Registrar productos
- **HU-A2** Consultar y editar productos
- **HU-A3** Registrar ventas

## Cómo ejecutar

1. Abrir la carpeta `dist`.
2. Ejecutar: `java -jar cafestock.jar` (Java 17 o superior).
3. Mantener la carpeta `datos/` junto al `.jar`: ahí se guardan `productos.csv` y `ventas.csv`.

## Estructura del proyecto

- `modelo`: clases del negocio (Producto, Venta)
- `datos`: lectura y escritura de los archivos CSV
- `servicio`: validaciones y cálculos
- `ui`: pantallas (Swing)

## Convenciones del equipo

- Cada commit empieza con el código de la historia: `HU-A1: validar código repetido`.
- Formato de los CSV: separador `;`, punto decimal, fechas `yyyy-MM-dd`.
- Una tarjeta pasa a "Hecho" solo si la probó otro integrante.
