# GiftApp Public Release 

**GiftApp** is an interactive Android application designed to deliver personalized birthday experiences. This public release version is streamlined for wide distribution, providing a combination of multimedia content, mini-games, and personalized messages. The app is built using **Java**, **Android Studio**, and **Jetpack components** for modern, maintainable architecture.

---

## Features

1. **Splash Video**  
   - Fullscreen birthday video introduction.
   - Skip button allows users to jump directly to the main content.

2. **Tabbed Navigation**  
   - **Notes Tab:** A RecyclerView displaying public-friendly notes or messages.  
   - **Mini-Game Tab:** Interactive "Catch the Object" game with adjustable difficulty (Easy, Medium, Hard).  
   - **Letter Tab:** Scrollable personalized letter with styled text and spacing for readability.

3. **Responsive UI**  
   - Designed with **ConstraintLayout**, **NestedScrollView**, and **GridLayout** for responsive layout across devices.  
   - Supports portrait, landscape, and large screen dimensions.  

4. **Custom Styles and Themes**  
   - Material3-based themes for dark/light modes.  
   - Customized buttons, text styles, and game cell layouts.  

5. **Local Multimedia**  
   - Includes a **birthday.mp4** video and animated image gallery with captions.  

---

## Technology Stack

- **Language:** Java  
- **IDE:** Android Studio  
- **UI:** Material3, ConstraintLayout, GridLayout, NestedScrollView  
- **Navigation:** Jetpack Navigation Component  
- **Multimedia:** VideoView, ImageView  
- **Build Tools:** Gradle, Android Gradle Plugin  

---

## Project Structure

```

GiftApp\_public/
├─ app/
│  ├─ src/main/java/com/example/giftapp\_public/
│  │  ├─ MainActivity.java
│  │  ├─ ViewPagerAdapter.java
│  │  ├─ SplashActivity.java
│  │  ├─ fragments/
│  │  │  ├─ FirstFragment.java
│  │  │  ├─ SecondFragment.java
│  │  │  ├─ GameFragment.java
│  │  │  ├─ PhotosFragment.java
│  │  │  └─ BirthdayTextFragment.java
│  ├─ res/
│  │  ├─ layout/
│  │  │  ├─ activity\_main.xml
│  │  │  ├─ activity\_splash.xml
│  │  │  ├─ fragment\_first.xml
│  │  │  ├─ fragment\_second.xml
│  │  │  ├─ fragment\_game.xml
│  │  │  ├─ fragment\_photos.xml
│  │  │  └─ fragment\_birthday\_text.xml
│  │  ├─ drawable/ (custom backgrounds, buttons, borders)
│  │  ├─ mipmap/ (launcher icons)
│  │  ├─ raw/ (birthday video)
│  │  ├─ values/ (colors, dimens, strings, styles, themes)
│  │  └─ navigation/nav\_graph.xml
└─ build.gradle, settings.gradle, gradle wrapper files

````

---

## How to Use

1. Clone the repository:  
   ```bash
   git clone https://github.com/mfawiann/GiftApp_Public.git
````

2. Open the project in **Android Studio**.

3. Build and run the app on an emulator or physical device.

4. Enjoy the birthday video, mini-game, and personalized letters!

---

## Contribution

This is a public release; contributions are welcome as **issues** or **pull requests**. Please follow Android best practices if submitting code changes.

---

## License

This project is released under the **MIT License** – see `LICENSE` for details.

---

Made with ❤️ for interactive birthday experiences.
