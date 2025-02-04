# Flag Quiz - Modernized Version

## Overview
This project is a modernized and improved version of the **Flag Quiz App** originally presented in *Android™ 6 for Programmers: An App-Driven Approach*. The application tests users' knowledge of country flags by presenting a multiple-choice quiz. Unlike the original implementation, this version leverages contemporary Android development techniques and best practices to enhance performance, maintainability, and user experience.

## Features
- **Modern UI Design**: Implements the latest Material Design components and animations.
- **Jetpack Components**: Uses ViewModel, LiveData, and Data Binding to improve state management.
- **Improved Fragment Management**: Utilizes the latest Fragment APIs for seamless navigation.
- **Optimized Performance**: Uses efficient data structures and lazy loading techniques.
- **Adaptive Layouts**: Supports multiple screen sizes and orientations with ConstraintLayout and Jetpack Compose.
- **Enhanced User Preferences**: Implements SharedPreferences and DataStore for persistent settings.
- **Animations and Transitions**: Integrates MotionLayout and modern animation libraries for smooth UI interactions.

## Technologies Used
- **Programming Languages**: Kotlin (primary), Java (for compatibility)
- **UI Framework**: Jetpack Compose & XML-based layouts
- **State Management**: ViewModel & LiveData
- **Navigation**: Jetpack Navigation Component
- **Dependency Injection**: Hilt
- **Asynchronous Processing**: Coroutines & Flow
- **Data Persistence**: Room Database & DataStore
- **Testing Frameworks**: JUnit, Espresso, MockK

## Installation
1. Clone this repository:
   ```bash
   git clone https://github.com/your-repo/flag-quiz-modern.git
   ```
2. Open the project in **Android Studio (latest version recommended)**.
3. Build and run the project using an emulator or physical device.

## How to Play
1. Select the number of answer choices (2, 4, 6, or 8).
2. Choose the world regions for flag selection.
3. Identify the correct country name based on the displayed flag.
4. Get instant feedback with animations for correct and incorrect answers.
5. View your total score and percentage at the end of the quiz.

## Project Structure
```
/app
  |-- src/main
      |-- java/com/example/flagquiz
          |-- ui/               # UI Components (Activities, Fragments, Composables)
          |-- data/             # Data layer (Repositories, Room, DataStore)
          |-- viewmodel/        # ViewModels for UI state management
      |-- res/
          |-- drawable/         # Images and vector assets
          |-- layout/           # XML-based UI layouts
          |-- values/           # Strings, colors, themes
```

## Future Improvements
- Integrate Firebase for analytics and user insights.
- Add a global leaderboard with real-time ranking.
- Implement voice-assisted flag identification.
- Expand question database with additional information about countries.

## Contribution
Feel free to fork this repository, open issues, and submit pull requests. Any improvements or bug fixes are welcome!

## License
This project is licensed under the **MIT License**.

---
> *Inspired by "Android™ 6 for Programmers", but completely restructured and modernized.*

