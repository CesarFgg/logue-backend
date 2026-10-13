# Logue - Backend API

## Descripción
**Logue** es una plataforma de aprendizaje interactiva diseñada para niños con dislexia. Este repositorio contiene el servicio **Backend** desarrollado en Kotlin con el framework Ktor, encargado de gestionar la autenticación de usuarios mediante roles utilizando un almacenamiento en memoria basado en un archivo JSON sin necesidad de base de datos externa.

---

## Tecnologías Utilizadas
* **Lenguaje:** Kotlin
* **Framework:** Ktor 3.6.0
* **Motor HTTP:** Netty
* **Serialización:** `kotlinx.serialization` (JSON)
* **Gestor de dependencias:** Gradle con Kotlin DSL (`build.gradle.kts`)

---

## Estructura Real del Proyecto

```
logue-backend/
├── .gitignore
├── README.md
├── build.gradle.kts
├── gradle.properties
├── gradlew
├── gradlew.bat
├── login.http
├── settings.gradle.kts
├── gradle/
│   ├── gradle-daemon-jvm.properties
│   ├── libs.versions.toml
│   └── wrapper/
│       └── gradle-wrapper.properties
└── src/
    ├── main/
    │   ├── kotlin/
    │   │   ├── Http.kt
    │   │   ├── main.kt
    │   │   ├── Models.kt
    │   │   ├── Routing.kt
    │   │   ├── Serialization.kt
    │   │   └── UsuarioRepository.kt
    │   └── resources/
    │       ├── application.yaml
    │       ├── logback.xml
    │       └── usuarios.json
    └── test/
        └── kotlin/
            └── ServerTest.kt
```

---

## Cómo Ejecutar el Servidor

### En Windows (PowerShell / CMD)
```cmd
.\gradlew.bat run
```

### En Linux / macOS
```bash
./gradlew run
```

El servidor iniciará en el puerto **8080** y responderá en `http://localhost:8080`.

Para verificar la compilación y ejecutar las pruebas automáticas:
```cmd
.\gradlew.bat build
```

---

## Usuarios de Prueba Registrados

| ID | Usuario | Contraseña | Rol | Nombre Completo |
|---|---|---|---|---|
| 1 | `nino` | `1234` | `NINO` | Mateo |
| 2 | `tutor` | `tutor123` | `TUTOR` | Ana López |
| 3 | `especialista` | `espe123` | `ESPECIALISTA` | Dra. Ruiz |
| 4 | `admin` | `admin123` | `ADMINISTRADOR` | Administrador Logue |

---

## Documentación de la API

### 1. Endpoint Raíz
* **URL:** `GET /`
* **Respuesta:**
  ```text
  Logue API
  ```

---

### 2. Autenticación de Usuarios
* **URL:** `POST /login`
* **Headers:** `Content-Type: application/json`

#### Ejemplo de Petición (Request Body)
```json
{
  "usuario": "nino",
  "password": "1234"
}
```

#### Respuestas Posibles

##### 200 OK (Credenciales válidas)
```json
{
  "exito": true,
  "mensaje": "Bienvenido",
  "usuario": {
    "id": 1,
    "nombre": "Mateo",
    "rol": "NINO"
  }
}
```

##### 401 Unauthorized (Usuario o contraseña incorrectos)
```json
{
  "exito": false,
  "mensaje": "Usuario o contraseña incorrectos",
  "usuario": null
}
```

##### 400 Bad Request (JSON mal formado o campos faltantes)
```json
{
  "exito": false,
  "mensaje": "Petición inválida",
  "usuario": null
}
```

---

## Integrantes
* [NOMBRE INTEGRANTE 1]
* [NOMBRE INTEGRANTE 2]
