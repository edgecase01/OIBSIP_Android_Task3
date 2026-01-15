# Android MDAS Calculator

A robust, logic-driven calculator application developed as part of my **Android Development Internship**. This app goes beyond basic sequential calculation by implementing **Operator Precedence (MDAS)**, ensuring that multiplication and division are prioritized over addition and subtraction.

https://github.com/user-attachments/assets/f4d6c29d-ef2d-4bec-8266-116b4347c7b5

## 🚀 Features
- **MDAS Logic:** Correctly evaluates expressions like `2 + 3 x 4` as `14` (not `20`).
- **Clean UI:** Built with a `GridLayout` for a responsive, professional look and feel.
- **Decimal Support:** Handles floating-point arithmetic for precise calculations.
- **State Management:** Efficiently handles multi-digit inputs and complex expression building.
- **One-Touch Reset:** Quick "C" (Clear) functionality to reset the calculation engine.

## 🧠 The Calculation Engine (Two-Pass Logic)
The core of this project is the custom calculation algorithm. Instead of calculating results as the user types, the app stores the expression in a list and processes it in two distinct phases:

1.  **Pass 1 (High Priority):** The app iterates through the expression and performs all **Multiplication (x)** and **Division (/)** operations first, collapsing those parts of the expression.
2.  **Pass 2 (Low Priority):** The app then performs all **Addition (+)** and **Subtraction (-)** operations on the remaining values to reach the final result.

This approach mimics how scientific calculators work and demonstrates a strong understanding of data structures and algorithmic thinking.

## 🛠️ Technical Stack
- **Language:** Java
- **UI Framework:** Android XML (GridLayout, Material Design)
- **Logic:** Two-pass list processing algorithm.
- **Tools:** Android Studio, Git.

## 🏗️ Project Structure
- `MainActivity.java`: Contains the core logic for event handling and the two-pass arithmetic engine.
- `activity_main.xml`: Defines a structured grid layout using a single `GridLayout` container for optimal performance.

## 📥 How to Run
1. Clone this repository.
2. Open the project in **Android Studio**.
3. Build and run on an emulator or physical device (API 24+).

## 🌟 Learning Outcomes
- Implementing mathematical algorithms in Java.
- Efficient UI design using Grid-based layouts.
- Managing shared `View.OnClickListener` for cleaner, more maintainable code.

---
