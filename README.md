# Blink Sound Widget

Native Android home-screen widget that plays the Blink sound when the widget button is pressed.

## Features

- Works completely offline — no internet or server required
- Home-screen widget with a single **Play Sound** button
- Test button inside the app for checking the sound before adding the widget
- Automatically built into an APK via GitHub Actions

## Install via GitHub Actions (easiest)

1. Go to the **Actions** tab of this repository
2. Select **Build Android APK**
3. Press **Run workflow**
4. When the run completes, download the artifact named `BlinkSoundWidget-debug-apk`
5. Transfer `app-debug.apk` to your Android device and install it
   - You may need to enable **Install from unknown sources** in Settings
6. Long-press your Android home screen → **Widgets** → add **Blink Sound Widget**

## Build locally in Android Studio

1. Open this folder in Android Studio
2. Let Gradle sync finish
3. Run **Build → Build Bundle(s) / APK(s) → Build APK(s)**
4. Install the APK on your Android device

## Requirements

- Android 5.0 (API 21) or higher
- No internet connection required after install
