# Weather App

Una aplicación de clima moderna construida con Jetpack Compose que muestra información meteorológica detallada basada en tu ubicación actual.

## 📸 Capturas de pantalla

<div align="center">
  <img src="https://i.ibb.co/0pnzfCk5/Whats-App-Image-2026-04-18-at-13-13-55.jpg" width="300" alt="Main Screen">
</div>

## ✨ Características

- 📍 **Ubicación en tiempo real:** Obtiene el clima basado en tu ubicación GPS actual de forma automática.
- 🌡️ **Estado actual:** Muestra la temperatura actual, descripción del clima e iconos dinámicos.
- 📅 **Pronóstico por horas:** Visualiza la evolución del tiempo para las próximas 24 horas.
- 📊 **Detalles meteorológicos:** Información adicional como humedad, presión atmosférica y velocidad del viento.
- 🔄 **Actualización fluida:** Implementación de "Pull to Refresh" para actualizar los datos al instante.
- 🎨 **Interfaz Moderna:** Diseño limpio y minimalista utilizando Material 3 y Jetpack Compose.

## 🛠️ Stack Tecnológico

- **Lenguaje:** [Kotlin](https://kotlinlang.org/)
- **UI:** [Jetpack Compose](https://developer.android.com/jetpack/compose)
- **Arquitectura:** MVVM (Model-View-ViewModel) + Clean Architecture
- **Inyección de Dependencias:** [Dagger Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- **Red:** [Retrofit](https://square.github.io/retrofit/) & OkHttp
- **Localización:** Google Play Services Location & Geocoder
- **Asincronía:** Coroutines & Flow

## 📂 Estructura del Proyecto

- `data`: Implementación de repositorios, fuentes de datos remotas (Retrofit) y mapeadores.
- `domain`: Modelos de negocio, interfaces de repositorios y lógica central.
- `presentation`: Componentes de UI (Composables), ViewModels y manejo de estados.
- `di`: Módulos de inyección de dependencias con Hilt.

## 🚀 Cómo empezar

1. Clona este repositorio:
   ```bash
   git clone https://github.com/tu-usuario/weather.git
   ```
2. Abre el proyecto en **Android Studio Jellyfish** o superior.
3. Sincroniza el proyecto con los archivos de Gradle.
4. Ejecuta la aplicación en un dispositivo físico o emulador con servicios de Google Play.

> **Nota:** La aplicación requiere permisos de ubicación (`ACCESS_FINE_LOCATION`) para funcionar correctamente.

---
Hecho con ❤️ por [Juan Manuel Fernández](https://github.com/tu-usuario)
