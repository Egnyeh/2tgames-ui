# LoginKMP - Kotlin Multiplataforma con Login

Aplicación de login multiplataforma desarrollada con Kotlin Multiplatform y Compose Multiplatform.

## 🎨 Características

- ✨ UI moderna con colores negro y morado
- 🔐 Sistema de login completo
- 🌐 Soporta Android, Desktop (Windows/Mac/Linux) y Web
- 🚀 Integración con API REST usando Ktor
- 💜 Diseño Material Design 3

## ⚡ Primer uso - Configurar Gradle Wrapper

**IMPORTANTE**: Antes de compilar, necesitas generar el Gradle Wrapper.

### Opción 1: Usando Android Studio (MÁS FÁCIL)

1. Abre Android Studio
2. File → Open → Selecciona la carpeta `LoginKMP`
3. Android Studio configurará todo automáticamente
4. ¡Listo para compilar! 🎉

### Opción 2: Desde línea de comandos

Si tienes Gradle instalado:

```bash
cd LoginKMP
gradle wrapper --gradle-version 8.5
```

Ver más opciones en: [CONFIGURAR_WRAPPER.md](CONFIGURAR_WRAPPER.md)

## 🛠️ Configuración de tu API

### Configurar la URL del backend

Edita el archivo `composeApp/src/commonMain/kotlin/com/cristina/loginkmp/App.kt`:

```kotlin
val apiClient = ApiClient(baseUrl = "http://TU_IP:TU_PUERTO/api")
```

### Estructura esperada de la API

**Endpoint de login:** `POST /api/auth/login`

**Request:**
```json
{
  "username": "usuario",
  "password": "contraseña"
}
```

**Response exitoso:**
```json
{
  "success": true,
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "message": "Login exitoso",
  "user": {
    "id": "123",
    "username": "usuario",
    "email": "usuario@ejemplo.com"
  }
}
```

**Response error:**
```json
{
  "success": false,
  "message": "Credenciales incorrectas"
}
```

## 🚀 Compilar y ejecutar

### Android

```bash
./gradlew :composeApp:assembleDebug
```

O abre el proyecto en Android Studio y ejecuta normalmente.

### Desktop

```bash
./gradlew :composeApp:run
```

Para crear un instalador:
```bash
./gradlew :composeApp:packageDistributionForCurrentOS
```

### Web

```bash
./gradlew :composeApp:jsBrowserDevelopmentRun
```

Para compilar en producción:
```bash
./gradlew :composeApp:jsBrowserDistribution
```

Los archivos compilados estarán en `composeApp/build/dist/js/productionExecutable/`

## 📁 Estructura del proyecto

```
LoginKMP/
├── composeApp/
│   ├── src/
│   │   ├── commonMain/           # Código compartido
│   │   │   └── kotlin/
│   │   │       └── com/cristina/loginkmp/
│   │   │           ├── data/     # Modelos y ApiClient
│   │   │           ├── ui/       # Pantallas y ViewModels
│   │   │           ├── theme/    # Colores y tema
│   │   │           └── App.kt    # Punto de entrada común
│   │   ├── androidMain/          # Código específico Android
│   │   ├── desktopMain/          # Código específico Desktop
│   │   └── jsMain/               # Código específico Web
│   └── build.gradle.kts
├── build.gradle.kts
└── settings.gradle.kts
```

## 🎨 Personalización

### Cambiar colores

Edita `composeApp/src/commonMain/kotlin/com/cristina/loginkmp/theme/Color.kt`:

```kotlin
val PrimaryPurple = Color(0xFF9C27B0)  // Color principal
val SecondaryPurple = Color(0xFFBA68C8)  // Color secundario
val DarkPurple = Color(0xFF7B1FA2)  // Color oscuro
```

### Modificar textos

Edita `composeApp/src/commonMain/kotlin/com/cristina/loginkmp/ui/LoginScreen.kt`

## 🔧 Requisitos

- JDK 17 o superior
- Android Studio (para compilar Android)
- Gradle 8.0+

## 📝 Notas importantes

### Para Android en desarrollo local:

Si tu API está en `localhost` o `127.0.0.1`, desde el emulador de Android usa:
- `10.0.2.2` en lugar de `localhost`
- O usa tu IP local (192.168.x.x)

### Para Web:

Si tienes problemas de CORS, asegúrate de que tu API permita peticiones desde el origen de tu aplicación web.

### Cleartext Traffic (HTTP):

El proyecto está configurado para permitir HTTP no seguro (útil para desarrollo). En producción, usa HTTPS y elimina `android:usesCleartextTraffic="true"` del AndroidManifest.

## 🐛 Solución de problemas

### Error de conexión:
- Verifica que la URL de tu API sea correcta
- Asegúrate de que tu API esté corriendo
- Revisa los permisos de Internet (ya incluidos)

### Errores de compilación:
```bash
./gradlew clean
./gradlew build
```

## 📱 Screenshots

La aplicación muestra:
- Campo de usuario
- Campo de contraseña con opción de mostrar/ocultar
- Botón de login con loading spinner
- Mensajes de error claros
- Confirmación de login exitoso con datos del usuario

## 🎯 Próximos pasos sugeridos

- [ ] Añadir pantalla de registro
- [ ] Implementar "Recordar sesión"
- [ ] Añadir recuperación de contraseña
- [ ] Guardar el token en almacenamiento local
- [ ] Añadir navegación a pantalla principal tras login exitoso
- [ ] Implementar refresh token

## 👩‍💻 Autora

Cristina - Proyecto LoginKMP

¡Buena suerte con tu proyecto! 🚀
