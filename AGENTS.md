# AGENTS.md

## Cursor Cloud specific instructions

This repo is a native **Android app** (Kotlin + Jetpack Compose, `com.absynth.hostel`).
There is no server/web component — the deliverable is a debug APK that runs on an
Android device/emulator.

### Toolchain / environment

- **Use JDK 17** for Gradle. The Android Gradle Plugin (8.2.2) requires JDK 17, but the
  VM's default `java` is JDK 21. `JAVA_HOME`, `ANDROID_SDK_ROOT`/`ANDROID_HOME`, and the
  relevant `PATH` entries are exported in `~/.bashrc`. In a non-login shell, prefix
  commands with `JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64`.
- Android SDK lives at `~/android-sdk` (platform `android-34`, build-tools `34.0.0`,
  `platform-tools`, `emulator`, system image `system-images;android-34;google_apis;x86_64`).
- `local.properties` (git-ignored) points `sdk.dir` at the SDK; the `ANDROID_HOME` env var
  also covers this if the file is missing.

### Build / lint / test (run from repo root)

- Build dev APK: `./gradlew assembleDebug` → output `app/build/outputs/apk/debug/app-debug.apk`.
- Lint: `./gradlew lintDebug` (HTML report under `app/build/reports/`).
- Unit tests: `./gradlew testDebugUnitTest` (no unit tests exist yet, so this is a no-op pass).

### Running the app on the emulator (important caveats)

- **There is no KVM** in this VM, so the emulator falls back to software CPU emulation
  (TCG) and is *very* slow. Plan for it: cold boot can take ~10+ minutes and `adb install`
  can take ~2 minutes.
- Start headless:
  `emulator -avd absynth_test -no-window -no-audio -no-boot-anim -no-snapshot -gpu swiftshader_indirect -no-accel`
  (an AVD named `absynth_test` is already created).
- Because the host is overloaded, `system_server` / `SystemUI` **ANR ("isn't responding")
  dialogs are expected** during and shortly after boot. Suppress them with
  `adb shell settings put global hide_error_dialogs 1` and dismiss any that appear.
- Capture screenshots with `adb exec-out screencap -p > shot.png`. The
  `adb shell screencap /sdcard/... && adb pull` variant tends to hang under TCG.
- Install + launch: `adb install -r app/build/outputs/apk/debug/app-debug.apk` then
  `adb shell am start -n com.absynth.hostel/.MainActivity`.

### Notes on repo state

- The repository originally shipped only Kotlin sources and docs with **no Gradle build
  files**; the build setup (`settings.gradle.kts`, root + `app/build.gradle.kts`, Gradle
  wrapper) and missing resources (`themes.xml`, `colors.xml`, adaptive launcher icon) were
  added so the project can build. `releases/app-debug.apk` in the repo is a 20-byte
  placeholder, not a real APK.
- Two minimal source-level fixes were needed to compile: a missing
  `import androidx.compose.ui.graphics.Color` in `ui/screens/Screens.kt`, and a Material3
  experimental opt-in added via `kotlinOptions.freeCompilerArgs` in `app/build.gradle.kts`.
