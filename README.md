# 🧑‍💻 Gestión de Usuarios con Java, JDBC y PostgreSQL

Aplicación de escritorio desarrollada en **Java** utilizando:

- ☕ Java
- 🐘 PostgreSQL
- 🔌 JDBC
- 🖥️ `JOptionPane`
- 🏗️ Arquitectura por capas
- 🎯 Patrón MVC simplificado
- 📦 Maven

La aplicación permite registrar, listar, buscar y eliminar usuarios almacenados en una base de datos PostgreSQL.

---

## 📌 Tabla de contenidos

- [Características](#-características)
- [Arquitectura del proyecto](#-arquitectura-del-proyecto)
- [Requisitos](#-requisitos)
- [Configuración de PostgreSQL](#-configuración-de-postgresql)
- [Configuración del proyecto](#-configuración-del-proyecto)
- [Estructura de paquetes](#-estructura-de-paquetes)
- [Implementación](#-implementación)
- [Ejecución](#-ejecución)
- [Solución de errores comunes](#-solución-de-errores-comunes)
- [Flujo de la aplicación](#-flujo-de-la-aplicación)
- [Buenas prácticas](#-buenas-prácticas)
- [Mejoras futuras](#-mejoras-futuras)

---

## ✨ Características

La aplicación permite:

- ✅ Registrar usuarios
- ✅ Listar todos los usuarios
- ✅ Buscar un usuario por ID
- ✅ Eliminar usuarios
- ✅ Validar datos básicos
- ✅ Mostrar mensajes mediante `JOptionPane`
- ✅ Separar la aplicación en capas
- ✅ Utilizar JDBC para conectarse a PostgreSQL
- ✅ Gestionar errores básicos de la aplicación

---

## 🏗️ Arquitectura del proyecto

El proyecto utiliza una arquitectura por capas junto con un MVC simplificado.

```text
┌────────────────────┐
│       View         │
│    JOptionPane     │
└─────────┬──────────┘
          │
          ▼
┌────────────────────┐
│    Controller      │
│ Coordina acciones  │
└─────────┬──────────┘
          │
          ▼
┌────────────────────┐
│      Service       │
│ Reglas de negocio  │
└─────────┬──────────┘
          │
          ▼
┌────────────────────┐
│    Repository      │
│ Consultas SQL      │
└─────────┬──────────┘
          │
          ▼
┌────────────────────┐
│ DatabaseConnection │
│ Conexión mediante  │
│       JDBC         │
└─────────┬──────────┘
          │
          ▼
┌────────────────────┐
│    PostgreSQL      │
└────────────────────┘

```
## 🛠️ Requisitos

Antes de ejecutar el proyecto, instala:

* ☕ **JDK 17** o superior
* 🐘 **PostgreSQL**
* 🧰 **pgAdmin 4**
* 📦 **Maven**
* 💻 **IntelliJ IDEA**, **Eclipse**, **NetBeans** o **VS Code**

Puedes comprobar las versiones instaladas en tu terminal con:

```bash
java -version
```
## 📦 Configuración del proyecto

Si utilizas Maven, agrega el driver de PostgreSQL en tu archivo `pom.xml`:

```xml
<project xmlns="[http://maven.apache.org/POM/4.0.0](http://maven.apache.org/POM/4.0.0)"
         xmlns:xsi="[http://www.w3.org/2001/XMLSchema-instance](http://www.w3.org/2001/XMLSchema-instance)"
         xsi:schemaLocation="
         [http://maven.apache.org/POM/4.0.0](http://maven.apache.org/POM/4.0.0)
         [https://maven.apache.org/xsd/maven-4.0.0.xsd](https://maven.apache.org/xsd/maven-4.0.0.xsd)">

    <modelVersion>4.0.0</modelVersion>

    <groupId>com.ejemplo</groupId>
    <artifactId>gestion-usuarios</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.7.6</version>
        </dependency>
    </dependencies>

</project>
```

## 🔗 Formato de la URL de conexión JDBC
La URL de conexión utiliza el siguiente formato:
```
jdbc:postgresql://HOST:PUERTO/BASE_DE_DATOS
```

## 📁 Estructura de paquetes
```
src/
└── main/
    └── java/
        └── com/
            └── ejemplo/
                ├── Main.java
                │
                ├── config/
                │   └── DatabaseConnection.java
                │
                ├── model/
                │   └── Usuario.java
                │
                ├── repository/
                │   ├── UsuarioRepository.java
                │   └── UsuarioRepositoryImpl.java
                │
                ├── service/
                │   └── UsuarioService.java
                │
                ├── controller/
                │   └── UsuarioController.java
                │
                └── view/
                    └── UsuarioView.java
```

## ▶️ Ejecución

### Desde un IDE

1. Abre el proyecto en tu IDE preferido (*IntelliJ IDEA*, *NetBeans*, *Eclipse* o *VS Code*).
2. Verifica que el servicio de **PostgreSQL** esté iniciado en tu sistema.
3. Comprueba que las credenciales (`URL`, `usuario` y `contraseña`) en la clase `DatabaseConnection` sean correctas.
4. Asegúrate de que la base de datos y la tabla correspondiente ya hayan sido creadas.
5. Ejecuta la clase `Main.java`.

## ✅ Buenas prácticas

* 🔐 **Seguridad:** No guardar contraseñas directamente en el código fuente en proyectos reales.
* 🧩 **Prevención de inyección SQL:** Usar siempre `PreparedStatement`.
* 🧹 **Gestión de recursos:** Utilizar `try-with-resources` para cerrar conexiones, *statements* y *result sets* automáticamente.
* 🎯 **Capa Service:** Mantener la lógica de negocio dentro de `Service`.
* 🗄️ **Capa Repository:** Mantener la persistencia y consultas SQL dentro de `Repository`.
* 🖥️ **Separación de responsabilidades:** Evitar colocar consultas SQL en la vista.
* 🎨 **Desacoplamiento UI:** Evitar colocar reglas de negocio dentro de componentes de interfaz (como `JOptionPane`).
* 🧪 **Pruebas:** Crear pruebas unitarias para la capa `Service`.
* 📦 **Diseño modular:** Utilizar interfaces para desacoplar las implementaciones.
* 🔌 **Escalabilidad:** Considerar un pool de conexiones en aplicaciones de mayor escala.

---

## 🚧 Mejoras futuras

Algunas mejoras que se pueden incorporar posteriormente:

- [ ] Actualizar usuarios
- [ ] Buscar usuarios por nombre o email
- [ ] Validar el formato completo del email
- [ ] Añadir paginación
- [ ] Implementar una interfaz gráfica con `JFrame`
- [ ] Utilizar formularios visuales
- [ ] Agregar pruebas unitarias
- [ ] Implementar sistema de *logs*
- [ ] Manejar excepciones personalizadas
- [ ] Utilizar un pool de conexiones con **HikariCP**
- [ ] Crear una clase `AppException`
- [ ] Añadir autenticación de usuarios
- [ ] Utilizar archivos de configuración (`.properties` o `.env`)
- [ ] Migrar la interfaz a **JavaFX**
- [ ] Convertir el proyecto en una **API REST**

## 📄 Licencia

Este proyecto puede utilizarse con fines educativos y puede modificarse libremente para adaptarse a las necesidades de cada aplicación.

---

## 👨‍💻 Autor

Desarrollado con ☕ **Java**, 💙 esfuerzo y 🐘 **PostgreSQL** por **Daniel Viaña**.
