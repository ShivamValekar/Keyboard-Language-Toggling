<div align="center">

# ⌨️ Keyboard Language Toggling

### Type naturally. Let your keyboard figure out the language.

An exploration into **automatic language switching for Android keyboards**, built on Android's Accessibility framework.

![Platform](https://img.shields.io/badge/platform-Android-3DDC84?logo=android&logoColor=white)
![Build](https://img.shields.io/badge/build-Gradle%20(Kotlin%20DSL)-02303A?logo=gradle&logoColor=white)
![Status](https://img.shields.io/badge/status-work%20in%20progress-orange)
![PRs](https://img.shields.io/badge/PRs-welcome-brightgreen)

</div>

---

## 📖 Table of Contents

- [The Problem](#-the-problem)
- [The Idea](#-the-idea)
- [How It Works](#-how-it-works)
- [Progress](#-progress)
- [Architecture](#-architecture)
- [Getting Started](#-getting-started)
- [Project Structure](#-project-structure)
- [Challenges and Open Questions](#-challenges-and-open-questions)
- [Roadmap](#-roadmap)
- [Contributing](#-contributing)
- [License](#-license)

---

## 🤔 The Problem

If you type in more than one language, you know the routine: start a sentence, realise the keyboard is on the wrong layout, delete everything, tap the globe icon, and start over.

Multilingual users do this dozens of times a day. It's small friction, but it adds up.

## 💡 The Idea

**What if the keyboard just knew?**

This project explores ways to build an **automatic language toggler** for Android keyboards: something that watches what you type, works out which language you mean, and switches for you.

It's a research and learning project. The goal is to find out what is actually possible on Android, what the platform allows, and where the walls are.

## ⚙️ How It Works

The approach is split into four stages:

```
┌──────────────┐    ┌──────────────┐    ┌──────────────┐    ┌──────────────┐
│  1. INPUT    │ →  │  2. COLLECT  │ →  │  3. ANALYZE  │ →  │  4. TOGGLE   │
│  Interpret   │    │  Grab the    │    │  Meaning,    │    │  Switch to   │
│  what the    │    │  relevant    │    │  intent and  │    │  the right   │
│  user writes │    │  info        │    │  context     │    │  language    │
└──────────────┘    └──────────────┘    └──────────────┘    └──────────────┘
```

| Stage | Goal |
|-------|------|
| **1. Understand input** | Interpret what the user is writing, as they write it |
| **2. Collect data** | Capture the relevant text and context |
| **3. Analyze data** | Work out meaning, intent, and context |
| **4. Toggle language** | Choose and switch to the correct output language |

## 🚧 Progress

Development is documented step by step, as a learning log.

- [x] **1.1** Understand how the Android Input Framework works
- [x] **1.2** Build the first of three skeleton pieces: `KeyInputAccessibilityService`
- [x] **1.3** Set up the GitHub connection and workflow
- [x] **1.4** Understand the second skeleton piece: declaring the service in the Manifest
- [x] **1.5** Declare the service in the Manifest
- [ ] Complete the third skeleton piece
- [ ] Collect and process typed text (Stages 2 and 3)
- [ ] Implement language detection
- [ ] Implement the toggle (Stage 4)

## 🏗 Architecture

Understanding user input on Android needs **three building blocks**. Two are done, and the third is next:

| # | Building block | Status |
|---|----------------|--------|
| 1 | `KeyInputAccessibilityService`: the service that receives input-related events | ✅ Done |
| 2 | **Manifest declaration**: registers the service with the system | ✅ Done |
| 3 | Remaining skeleton piece | 🔜 Next |

### Why an Accessibility Service?

Android sandboxes apps from each other, so a normal app can't see what you type in another app. An `AccessibilityService` is the platform's sanctioned way to observe UI events (such as text changes) across the system, once the user explicitly enables it in Settings.

## 🚀 Getting Started

### Prerequisites

- [Android Studio](https://developer.android.com/studio) (recent stable version)
- JDK 17 or newer (bundled with Android Studio)
- An Android device or emulator

### Run it

```bash
# 1. Clone the repository
git clone https://github.com/ShivamValekar/Keyboard-Language-Toggling.git
cd Keyboard-Language-Toggling

# 2. Open in Android Studio and let Gradle sync
#    ...or build from the command line:
./gradlew assembleDebug        # macOS / Linux
gradlew.bat assembleDebug      # Windows
```

### Enable the service

Accessibility services need explicit user consent:

1. Install the app on your device or emulator.
2. Go to **Settings → Accessibility**.
3. Find **Keyboard Language Toggling** and switch it **on**.
4. Confirm the permission prompt.

> 🔒 **Privacy note:** an accessibility service can observe on-screen text, which is powerful. This project is an experiment, so only run it on devices you control, and never with sensitive data you don't want processed.

## 📁 Project Structure

```
Keyboard-Language-Toggling/
├── app/                    # Android application module (service + manifest)
├── gradle/                 # Gradle wrapper and version catalog
├── build.gradle.kts        # Root build configuration
├── settings.gradle.kts     # Project settings
├── gradle.properties       # Gradle properties
├── gradlew / gradlew.bat   # Gradle wrapper scripts
└── README.md
```

## 🧗 Challenges and Open Questions

This is a research project, so the open questions matter as much as the code:

- **Switching the keyboard language programmatically.** Android restricts what a non-IME app can do to change the active input method or subtype. Working out the legitimate routes is a core part of the exploration.
- **Detecting language from very little text.** A few characters are often ambiguous. Deciding when there is *enough* signal to switch is tricky.
- **Script vs. language.** Detecting a different *script* (Latin, Devanagari, Arabic, and so on) is easy. Telling apart languages that share a script, or transliterated text such as Hindi typed in Latin letters, is much harder.
- **Latency and battery.** Analysis must be fast and light enough to run while typing.
- **Privacy.** Any detection should ideally run **on-device**, with nothing sent off the phone.

## 🗺 Roadmap

- [ ] Capture text-change events from the accessibility service
- [ ] Script detection using Unicode ranges as a fast first pass
- [ ] On-device language identification for shared-script languages
- [ ] Investigate supported ways to change the active keyboard or subtype
- [ ] Confidence thresholds, so the keyboard doesn't switch on ambiguous input
- [ ] A simple settings screen (choose languages, enable or disable)
- [ ] Testing across popular keyboards and Android versions

## 🤝 Contributing

Ideas, issues, and pull requests are welcome, especially if you have experience with Android input methods or language identification.

1. Fork the repo
2. Create a feature branch (`git checkout -b feature/your-idea`)
3. Commit your changes (`git commit -m "Add your idea"`)
4. Push the branch (`git push origin feature/your-idea`)
5. Open a Pull Request

## 📄 License

No license has been added yet. Until one is, all rights are reserved by the author.

---

<div align="center">

**Built by [Shivam Valekar](https://github.com/ShivamValekar) & [Sarthak Kanawadehttps://github.com/Sarthak-145]** · If this idea interests you, consider giving the repo a ⭐

</div>
