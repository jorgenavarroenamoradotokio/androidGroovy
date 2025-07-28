# androidGroovy
Este es un proyecto base de Android con soporte para Java 11, diseñado para servir como punto de partida para futuras aplicaciones. Utiliza el sistema tradicional de vistas XML y está configurado con las dependencias esenciales de Android.

## Tecnologías utilizadas
- **Lenguaje**: Java 11
- **Sistema de vistas**: XML (Android View System)
- **Android SDK**: 
  - `compileSdk`: 36  
  - `minSdk`: 24  
  - `targetSdk`: 36
- **Build System**: Gradle con versiones catalogadas (Toml)
- **Dependencias clave**:
  - `androidx.appcompat`
  - `com.google.android.material`
  - `androidx.activity`
  - `androidx.constraintlayout`
  - `junit` y `espresso` para testing

## Instalación

1. Clona este repositorio:
```bash
git clone https://github.com/jorgenavarroenamoradotokio/androidGroovy.git
```
2. Ábrelo en Android Studio (Giraffe o superior).
3. Espera a que finalice la sincronización de Gradle.
4. Ejecuta el proyecto en un emulador o dispositivo físico con Android 7.0 (API 24) o superior.

## Testing
- ```./gradlew test # Pruebas unitarias```
- ```./gradlew connectedAndroidTest  # Pruebas de UI```

## Licencia
Este proyecto está bajo la licencia MIT. Puedes usarlo, modificarlo y distribuirlo libremente
