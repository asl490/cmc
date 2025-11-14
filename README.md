# Centro Médico API

API REST para la gestión de un centro médico, construida con Spring Boot.

## Características Principales

*   Gestión de Citas
*   Atenciones Médicas
*   Órdenes y Resultados de Laboratorio
*   Historia Clínica Electrónica
*   Registros de Enfermería
*   Autenticación y Autorización de usuarios con Keycloak.
*   Mantenimiento de maestros (Doctores, Pacientes, etc.).
*   Generación de reportes.

## Tecnologías Utilizadas

*   **Lenguaje:** Java 21
*   **Framework:** Spring Boot 3.5.6
*   **Base de Datos:** Microsoft SQL Server
*   **Autenticación:** Spring Security con OAuth2 / Keycloak
*   **Documentación API:** SpringDoc (Swagger UI)
*   **Mapeo de Objetos:** MapStruct
*   **Build Tool:** Maven

## Prerrequisitos

*   JDK 21 o superior.
*   Apache Maven.
*   Una instancia de Microsoft SQL Server.
*   Una instancia de Keycloak para la autenticación.

## Configuración

La aplicación se configura a través de variables de entorno. Cree un archivo `.env` en la raíz del proyecto o configure las variables directamente en su sistema.

| Variable            | Descripción                                         |
| ------------------- | --------------------------------------------------- |
| `DATABASE_URL`      | URL de conexión a la base de datos SQL Server.      |
| `DATABASE_USERNAME` | Usuario de la base de datos.                        |
| `DATABASE_PASSWORD` | Contraseña de la base de datos.                     |
| `AUTH_SERVER`       | URL base del servidor de autenticación Keycloak.    |
| `AUTH_SERVER_CERT`  | URI del JWK Set del servidor Keycloak.              |
| `CLIENT_ID`         | ID del cliente configurado en Keycloak.             |
| `CLIENT_SECRET`     | Secreto del cliente configurado en Keycloak.        |
| `AUTH_SERVER_TOKEN` | URI para obtener tokens de Keycloak.                |
| `PIDE_URL`          | URL del servicio PIDE para consulta de datos.       |
| `PIDE_TOKEN`        | Token de autorización para el servicio PIDE.        |

## Cómo Ejecutar

1.  **Clonar el repositorio:**
    ```bash
    git clone <URL-DEL-REPOSITORIO>
    cd centro-medico-prod/backend
    ```

2.  **Configurar las variables de entorno** (ver sección de Configuración).

3.  **Ejecutar la aplicación con Maven:**
    ```bash
    ./mvnw spring-boot:run
    ```

La API estará disponible en `http://localhost:8181/api/v1`.

## Documentación de la API

Una vez que la aplicación está en ejecución, la documentación de la API (Swagger UI) se encuentra disponible en:

[http://localhost:8181/api/v1/docs](http://localhost:8181/api/v1/docs)

El JSON de la especificación OpenAPI se encuentra en `/api/v1/api-docs`.

## Estructura del Proyecto

El proyecto sigue una estructura organizada por funcionalidades principales:

```
src/main/java/pe/gob/cusco/centro_medico
├── attention       # Lógica de negocio para atenciones, citas, etc.
├── auth            # Endpoints y servicios de autenticación.
├── config          # Clases de configuración de Spring, Swagger, etc.
├── exception       # Manejo de excepciones globales y personalizadas.
├── maintenance     # CRUDs para entidades maestras (pacientes, doctores).
├── reports         # Lógica para la generación de reportes.
├── security        # Configuración de Spring Security y Keycloak.
└── shared          # Clases base, utilitarios y DTOs compartidos.
```
