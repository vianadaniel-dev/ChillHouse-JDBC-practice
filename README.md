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
