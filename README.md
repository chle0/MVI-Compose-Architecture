# MVI Compose Architecture

A simple Android project created to understand and demonstrate **MVI (Model–View–Intent) Architecture** using **Kotlin** and **Jetpack Compose**.

This project focuses on the core concepts of MVI and how user interactions, application state, and UI can work together through a **unidirectional data flow**.

## 🔗 Repository

GitHub: https://github.com/chle0/MVI-Compose-Architecture

---

## 🎯 Project Goal

The main goal of this project is to build a small and easy-to-understand example of **MVI architecture in modern Android development**.

Instead of focusing on application complexity, this project focuses on understanding how MVI works and how it can be implemented with Jetpack Compose.

### Concepts demonstrated

* MVI Architecture
* Unidirectional Data Flow
* UI State Management
* User Intents
* ViewModel
* Kotlin Coroutines
* StateFlow
* Jetpack Compose
* API integration
* Loading, Success, and Error states
* Separation of UI and business logic

---

## 🏗️ MVI Architecture

The basic flow implemented in this project can be represented as:

```text
        User Interaction
              │
              ▼
           Intent
              │
              ▼
          ViewModel
              │
              ▼
        Business Logic
              │
              ▼
          UI State
              │
              ▼
       Jetpack Compose UI
              │
              └──────────────► User Interaction
```

The UI sends an **Intent** to the ViewModel.

The ViewModel processes that intent, performs the required operation, and updates the **UI State**.

Jetpack Compose observes the state and automatically recomposes the UI when the state changes.

---

## 🧩 Main Components

### Intent

Represents an action performed by the user.

For example:

```kotlin
sealed class MainIntent {
    data object FetchData : MainIntent()
}
```

The UI communicates with the ViewModel through these intents.

---

### State

Represents the current state of the screen.

For example:

```kotlin
sealed class MainState {
    data object Idle : MainState()
    data object Loading : MainState()
    data class Success(val data: List<Any>) : MainState()
    data class Error(val message: String) : MainState()
}
```

The UI reacts to changes in this state.

---

### ViewModel

The ViewModel acts as the central point for processing intents and updating the UI state.

Conceptually:

```text
Intent
   ↓
ViewModel
   ↓
Process Action
   ↓
Update State
   ↓
Compose UI
```

This creates a predictable flow of data throughout the application.

---

## 🚀 Technologies Used

| Technology          | Purpose                             |
| ------------------- | ----------------------------------- |
| **Kotlin**          | Programming language                |
| **Jetpack Compose** | Declarative UI                      |
| **MVI**             | Application architecture            |
| **ViewModel**       | State and business logic management |
| **StateFlow**       | Reactive state management           |
| **Coroutines**      | Asynchronous operations             |
| **Retrofit**        | API/network communication           |

---

## 📱 Application Flow

The application demonstrates a simple flow:

1. The application starts in an initial state.
2. The user performs an action.
3. The UI sends an Intent.
4. The ViewModel receives the Intent.
5. The ViewModel starts the required operation.
6. The UI changes to a loading state.
7. Data is retrieved from the API.
8. The ViewModel updates the state.
9. Compose observes the new state.
10. The UI displays the result or an error.

---

## 📂 Project Structure

A simplified structure of the project:

```text
app/
└── src/
    └── main/
        └── java/
            └── ...
                ├── data/
                │   └── ...
                │
                ├── model/
                │   └── ...
                │
                ├── presentation/
                │   ├── MainIntent.kt
                │   ├── MainState.kt
                │   ├── MainViewModel.kt
                │   └── MainScreen.kt
                │
                └── MainActivity.kt
```

The exact structure may evolve as the project develops.

---

## 🧠 Why MVI?

MVI is useful when an application needs predictable and centralized state management.

Some of the key benefits include:

* **Predictable state changes**
* **Unidirectional data flow**
* **Clear separation of responsibilities**
* **Centralized UI state**
* **Easier debugging**
* **Better visibility of user actions**
* **Good fit for reactive UI frameworks such as Jetpack Compose**

However, MVI can also introduce additional boilerplate for simple screens. This project intentionally keeps things simple so that the architecture can be understood without unnecessary complexity.

---

## 📚 Learning Purpose

This repository is primarily a **learning and demonstration project**.

The purpose is to understand:

* How MVI differs from MVVM
* How Intents represent user actions
* How ViewModel processes those actions
* How state flows from the ViewModel to Compose
* How Compose reacts to state changes
* How loading, success, and error states can be represented
* How unidirectional data flow works in a real Android project

The project can also serve as a reference when implementing MVI in larger Android applications.

---

## 🔮 Possible Future Improvements

This demo can be extended with:

* Unit tests
* Compose UI tests
* Dependency Injection
* Repository pattern
* Clean Architecture
* Better error handling
* Navigation
* Pagination
* Local database/cache
* Multiple screens
* More complex state management

---

## 👨‍💻 Author

**Ahmad Raza**

Senior Android Developer | Kotlin | Jetpack Compose | Kotlin Multiplatform

GitHub: https://github.com/chle0

---

## ⭐ Support

If this repository helps you understand MVI Architecture, consider giving it a ⭐ on GitHub.
