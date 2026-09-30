# X Clone - Android App

A native Android application built with Java that replicates the core functionality of X (formerly Twitter).

## Features

- 📱 Native Android UI with Material Design
- ✍️ Post/Tweet composition with 280 character limit
- ❤️ Like posts with real-time counter updates
- 🗑️ Delete posts
- 📊 View engagement metrics (replies, retweets, likes)
- 🎨 Dark theme matching X's design

## Project Structure

```
app/
├── src/main/java/com/example/xclone/
│   ├── MainActivity.java          # Main activity and app entry point
│   ├── Post.java                  # Post data model
│   └── PostAdapter.java           # RecyclerView adapter for posts
├── src/main/res/
│   ├── layout/
│   │   ├── activity_main.xml      # Main layout
│   │   └── item_post.xml          # Individual post layout
│   └── values/
│       ├── colors.xml             # Color definitions
│       ├── strings.xml            # String resources
│       └── themes.xml             # Theme styles
└── AndroidManifest.xml            # App manifest
```

## Tech Stack

- **Language:** Java
- **Target SDK:** Android 34
- **Minimum SDK:** Android 24
- **UI Framework:** Android AppCompat & Material Design
- **Layout:** RecyclerView for efficient post display
- **Build System:** Gradle

## Getting Started

### Prerequisites

- Android Studio (latest version)
- JDK 11+
- Android SDK 34+

### Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/allhacking549-bot/XCloneAndroid.git
   cd XCloneAndroid
   ```

2. Open in Android Studio:
   - File → Open → Select the project folder
   - Android Studio will sync Gradle automatically

3. Configure emulator or connect a device:
   - Tools → Device Manager → Create a new emulator (or use existing)
   - Or connect a physical Android device via USB (Enable Developer Mode)

## Building the APK

### Debug APK (for testing)

1. In Android Studio, go to: **Build → Build Bundle(s)/APK(s) → Build APK(s)**
2. Or via command line:
   ```bash
   ./gradlew assembleDebug
   ```
3. The APK will be generated at: `app/build/outputs/apk/debug/app-debug.apk`

### Release APK (for distribution)

1. **Create a signing key:**
   ```bash
   keytool -genkey -v -keystore release.keystore -keyalg RSA -keysize 2048 -validity 10000 -alias release
   ```

2. In Android Studio:
   - Build → Generate Signed Bundle/APK
   - Select "APK"
   - Choose your keystore file and enter credentials
   - Select "release" build type
   - Click "Finish"

3. Or via command line:
   ```bash
   ./gradlew assembleRelease
   ```

4. The APK will be at: `app/build/outputs/apk/release/app-release.apk`

## Installation

### Install via Android Studio

1. Connect your device or open an emulator
2. Click **Run** (▶ button) in Android Studio
3. Select your device and click OK

### Install via Command Line

```bash
adb install app/build/outputs/apk/debug/app-debug.apk
```

### Install on Physical Device

1. Build the APK
2. Transfer the APK file to your device
3. Open the file manager on your device
4. Locate and tap the APK file
5. Follow the on-screen prompts to install

## Usage

1. Launch the app
2. See the feed with sample posts
3. Type a new post in the text field (max 280 characters)
4. Click **Post** to add it to the feed
5. Click the heart icon to like/unlike posts
6. Click the X button to delete a post

## Future Enhancements

- 📸 Add image support
- 🌐 Backend API integration
- 👤 User authentication
- 💬 Real-time notifications
- 🔍 Search and trending
- 📱 Push notifications
- 🎥 Video support

## License

MIT License - Feel free to use this project for learning and development.

## Contributing

Feel free to fork this repository and submit pull requests with improvements.
