# TeamApp - Ejercicio de GitHub con Android y Compose

## Descripción del Proyecto

TeamApp es una aplicación Android nativa desarrollada con **Kotlin y Jetpack Compose** que muestra información sobre los miembros de un equipo. La aplicación permite navegar entre una lista de miembros y ver los detalles individuales de cada uno.

## Características Principales

- **Lista de Miembros**: Pantalla principal que muestra todos los miembros del equipo en tarjetas interactivas
- **Detalles del Miembro**: Pantalla de detalle que muestra información específica de cada miembro
- **Navegación Fluida**: Transición suave entre pantallas con botón de regreso
- **Diseño Material Design**: Interfaz moderna usando Material Design 3
- **Arquitectura Limpia**: Separación clara entre UI, modelo y datos

## Tecnologías Utilizadas

- **Kotlin**: Lenguaje principal de desarrollo
- **Jetpack Compose**: Framework moderno para UI declarativa
- **Material Design 3**: Sistema de diseño para Android
- **Navigation Compose**: Manejo de navegación entre pantallas
- **Android Architecture Components**: Componentes de arquitectura recomendados

## Estructura del Proyecto

```
app/
├── src/main/java/com/uvg/teamapp/
│   ├── MainActivity.kt                 # Actividad principal
│   ├── model/
│   │   ├── TeamMember.kt              # Modelo de datos del miembro
│   │   └── FakeTeamRepository.kt      # Repositorio de datos simulados
│   └── ui/
│       ├── detail/
│       │   └── TeamDetailScreen.kt    # Pantalla de detalles
│       ├── list/
│       │   └── TeamListScreen.kt      # Pantalla de lista (alternativa)
│       └── theme/
│           ├── Color.kt               # Colores del tema
│           ├── Theme.kt               # Configuración del tema
│           └── Type.kt                # Tipografía
```

## Capturas de Pantalla

### Pantalla Principal
[![principal-page.jpg](https://i.postimg.cc/XvHNxSKK/principal-page.jpg)](https://postimg.cc/SX9pNPvj)

### Pantalla de Detalles
[![details-page.jpg](https://i.postimg.cc/yNYYFYRY/details-page.jpg)](https://postimg.cc/VJp8ww43)

## Miembros del Equipo

- **Ángel Sanabria**: Estudiante de Ingeniería en Ciencias de la Computación, apasionado por la IA y el desarrollo de software
- **Juan Montenegro**: Especialista en desarrollo móvil con Kotlin y Jetpack Compose
- **Vernel Hernández**: Interesado en diseño de interfaces y experiencia de usuario

## Instalación y Configuración

### Prerrequisitos

- Android Studio Arctic Fox o superior
- JDK 11 o superior
- SDK de Android 26 (Android 8.0) o superior

### Pasos para ejecutar el proyecto

1. **Clonar el repositorio**:
   ```bash
   git clone [URL_DEL_REPOSITORIO]
   cd TeamApp
   ```

2. **Abrir en Android Studio**:
   - Abre Android Studio
   - Selecciona "Open an existing project"
   - Navega hasta la carpeta del proyecto y selecciónala

3. **Sincronizar dependencias**:
   - Android Studio debería sincronizar automáticamente
   - Si no, usa "Sync Now" en la barra de notificación

4. **Ejecutar la aplicación**:
   - Conecta un dispositivo Android o inicia un emulador
   - Presiona el botón "Run" o usa `Shift + F10`

## Flujo de Trabajo con Git

Este proyecto fue desarrollado siguiendo las mejores prácticas de colaboración con Git:

### Estructura de Ramas

- **`main`**: Rama principal con código estable
- **`develop`**: Rama de desarrollo para integración de features
- **`feature/*`**: Ramas individuales para cada funcionalidad

### Proceso de Desarrollo

1. **Fork y Clone**: Cada desarrollador creó un fork del repositorio principal
2. **Ramas de Feature**: Se crearon ramas específicas para cada funcionalidad
3. **Pull Requests**: Todas las contribuciones pasaron por revisión de código
4. **Revisiones**: Otro miembro del equipo revisó cada PR antes del merge
5. **Integración**: Las features se integraron primero en `develop`, luego en `main`

### Resolución de Conflictos

Durante el desarrollo surgieron algunos conflictos de merge que se resolvieron mediante:
- Comunicación constante entre miembros del equipo
- Revisión colaborativa del código conflictivo
- Uso de herramientas de merge de Android Studio
- Pruebas posteriores para asegurar funcionalidad

## Reflexión del Equipo

### Lo que Aprendimos

1. **Colaboración Efectiva**: La importancia de la comunicación constante en proyectos colaborativos
2. **Git Workflows**: Manejo profesional de ramas, PRs y revisiones de código
3. **Jetpack Compose**: Implementación práctica de UI moderna en Android
4. **Resolución de Conflictos**: Estrategias para manejar conflictos de código de manera constructiva

### Desafíos Enfrentados

- **Sincronización de Código**: Mantener coherencia entre diferentes contribuciones
- **Estándares de Código**: Asegurar un estilo consistente entre todos los desarrolladores
- **Integración de UI**: Coordinar el diseño visual entre diferentes pantallas

### Mejoras Futuras

- Implementación de persistencia de datos local
- Navegación más compleja con múltiples pantallas
- Pruebas unitarias e instrumentales
- Integración con APIs reales

## Configuración de Dependencias

El proyecto utiliza las siguientes dependencias principales:

```kotlin
// Compose BOM - controla las versiones de todas las librerías de Compose
implementation(platform("androidx.compose:compose-bom:2024.09.00"))

// Core Compose libraries
implementation("androidx.compose.ui:ui")
implementation("androidx.compose.material3:material3")
implementation("androidx.activity:activity-compose:1.10.1")

// Navigation
implementation("androidx.navigation:navigation-compose:2.8.3")

// Extended Icons
implementation("androidx.compose.material:material-icons-extended")
```

## Licencia

Este proyecto fue desarrollado con fines educativos como parte del curso de Ingeniería en Ciencias de la Computación de la Universidad del Valle de Guatemala.

---

**Desarrollado con ❤️ por el equipo de TeamApp**
