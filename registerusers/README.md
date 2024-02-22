# Servicio de Creación de Usuarios

Este servicio permite la creación de usuarios. Desarrollado como parte de una prueba de habilidades, el proyecto está en desarrollo y no se recomienda su uso en un entorno de producción.

## Documentos
En la carpeta docs se encuentra el diagrama de componente y secuencia, además del enunciado de la prueba que generó este proyecto.

## Estado del Proyecto
En desarrollo

## Instalación del Proyecto
Siga estos pasos para instalar y ejecutar el proyecto en su máquina local.

### Requisitos Previos
Asegúrese de tener instalados los siguientes elementos en su entorno de desarrollo:
- Java Development Kit (JDK) - versión 8 o superior.
- Maven - herramienta de construcción y gestión de dependencias.

### Pasos de Instalación
1. **Clonar el Repositorio:**
    ```bash
    git clone https://github.com/juniordiazr/repotest.git
    cd registerusers
    ```

2. **Configurar la Base de Datos H2 (Opcional):**
    El proyecto puede utilizar H2 como base de datos embebida. Modifique la configuración en `src/main/resources/application.properties` según sus necesidades.


3. **Compilar la Aplicación con Maven:**
    mvn clean install -U
4. **Ejecutar la Aplicación con Maven:**
    mvn spring-boot:run

## Uso de la Aplicación
1. **Acceder a la Aplicación:**
    La aplicación estará disponible en http://localhost:8081.

2. **Probar la API:**
    Utilice herramientas como Postman o curl para interactuar con la API.

3. **Crear un Usuario:**
    - Endpoint: `http://localhost:8081/user`
    - Método: `POST`
    - Cuerpo de la Solicitud:
        ```json
        {
          "name": "Nombre Apellido",
          "email": "correo@dominio.com",
          "password": "contrasena",
          "phones": [
            {
             "number": 123456789,
             "citycode": 1,
             "countrycode": "US"
            } 
          ]
        }
        ```

    - Ejemplo de Solicitud en CURL:    
        ```
        curl --location --request POST 'http://localhost:8081/user' \
        --header 'Content-Type: application/json' \
        --data-raw '{
            "name": "Junior Rodriguez",
            "email": "juniordiazr01@hotmail.com",
            "password": "Pwd12abc",
            "phones": [
                {
                    "number": 5555555,
                    "citycode": 1,
                    "countrycode": "58"
                }
            ]
        }'
        ```
    - Respuesta Exitosa, con el Token que se va a usar en el sigueinte end-pont:
        ```json
        {
            "id": "8b77b0d6-06c6-41b1-a545-f84228bda822",
            "name": "Junior Rodriguez",
            "email": "juniordiazr01@hotmail.com",
            "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqdW5pb3JkaWF6ckBob3RtYWlsLmNvbSIsImlhdCI6MTcwODQ1NzQyNywiZXhwIjoxNzA4NDYxMDI3fQ.i6CzgqrlN1Dl2YxCTkMVWAvJyeTaLwhkMy4X5KjeUwKPNbeVXxlaSGKC_692_f6p1SgEmcpYkHszy1blC3vrfw",
            "created": "2024-02-20T20:37:13.062+00:00",
            "modified": "2024-02-20T20:37:13.062+00:00",
            "lastLogin": "2024-02-20T20:37:13.062+00:00",
            "active": true
        }
        ```


    - Respuesta Fallida, validación de usuario único:
        ```json        
        {
            "error": [
                {
                    "mensaje": "El correo ya registrado"
                }
            ]
        }        
        ```

    - Respuesta Fallida, password no cumple con el formato:
        ```json
        {
            "error": [
                {
                    "mensaje": "Fallo en validación [ password: El password debe tener Sólo una letra mayuscula, dos numeros y un rango de 8 a 12 caracteres ] "
                }
            ]
        }
        ```


## Documentación de las APIs
1. **Acceder al Swagger:**
    Con un navegador web como Chrome o Firefox se puede acceder a la información de APIs en http://localhost:8091/swagger-ui



## Estructura del Proyecto

```
registerusers/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── globallogic./
│   │   │           └── registerusers/
│   │   │               ├── RegisterusersApplication.java
│   │   │               ├── config/
│   │   │               │   └── SwaggerConfig.java
│   │   │               ├── controller/
│   │   │               │   └── UserController.java
│   │   │               ├── dto/
│   │   │               │   ├── CreatedUserDto.java
│   │   │               │   ├── SignUpUserDto.java
│   │   │               │   └── SignUpUserPhoneDto.java
│   │   │               ├── entity/
│   │   │               │   ├── User.java
│   │   │               │   └── UserPhone.java
│   │   │               ├── exceptios/
│   │   │               │   ├── CustomException.java
│   │   │               │   └── GlobalExceptionHandler.java
│   │   │               ├── repository/
│   │   │               │   └── UserRepository.java
│   │   │               ├── service/
│   │   │               │   ├── JwtUtil.java
│   │   │               │   ├── UserService.java
│   │   │               │   └── UserServiceImpl.java
│   │   │               └── validators/
│   │   │                   ├── ConfigurableRegex.java
│   │   │                   └── ConfigurableRegexValidator.java
│   │   │               
│   │   ├── resources/
│   │   │   ├── application.properties
│   │   │   ├── static/
│   │   │   └── templates/
│   └── test/
│       └── java/
│           └── com/
│               └── globallogic/
│                   └── registerusers/
│                       ├── RegisterusersApplicationTests.java
│                       ├── controller/
│                       │   └── UserControllerTest.java
│                       └── service/
│                           ├── JwtUtilTest.java
│                           └── UserServiceImplTest.java
├── pom.xml
└── README.md
```


## Contribuyendo
Las contribuciones son bienvenidas. Para cambios importantes, primero abra un problema para discutir lo que le gustaría cambiar.

Asegúrese de actualizar las pruebas según sea necesario.

## Licencia
MIT
