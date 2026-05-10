# 📚 Method Master's Book Store: UFH Textbook Marketplace

[![Language: Java](https://img.shields.io/badge/Language-Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/)
[![Platform: Android](https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)](https://developer.android.com/)
[![SDK: API 24+](https://img.shields.io/badge/Min_SDK-API_24+-0078D6?style=for-the-badge&logo=android&logoColor=white)](https://developer.android.com/about/versions/nougat)

### 📖 Project Overview

**Method Master's Book Store** is an Android marketplace application designed for University of Fort Hare students to securely buy and sell textbooks. Built for the **CSC313: Object-Oriented Programming (Assignment 2)** module, this app allows sellers to list textbooks with full details (including banking info) and enables buyers to browse and search the marketplace in real-time.

The application serves as a practical implementation of core Object-Oriented Programming concepts, featuring a clean Material Design UI, robust exception handling, and an efficient in-memory data flow.

---

### 📱 App Preview

<p align="center">
  <img src="screenshots/home_screen.png" alt="Home Screen" width="30%" />
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <img src="screenshots/book_details.png" alt="Book Details Screen" width="30%" />
</p>

---

### ✨ Key Features Built

* **Browse & Discover:** View all available textbooks in a clean, responsive card-based `RecyclerView`.
* **Comprehensive Listings:** Sell a textbook by providing detailed information including title, author, module code, price, copies, and seller banking details.
* **Smart Search:** Real-time search functionality filtering by book title or seller name.
* **Duplicate Prevention:** Custom validation prevents the same book from being listed twice by the same seller.
* **Strict Data Validation:** All input fields are validated with meaningful error messages to ensure data integrity.
* **Detailed Views:** Dedicated detail screens for viewing complete listing information and seller contact details.

---

### 🏗️ OOP Architecture & Implementation

The app was engineered using strict Object-Oriented principles and industry-standard design patterns:

| Concept | Implementation Details |
|---|---|
| **Interfaces** | Implemented `Listable`, `Searchable`, and `IPayable` contracts. |
| **Abstract Classes** | Designed `BaseItem` with an abstract `getInfo()` method. |
| **Inheritance** | `Textbook` extends `BaseItem`; `DuplicateBookException` extends `Exception`. |
| **Polymorphism** | `TextbookRepository` is accessed via a `Searchable` reference. |
| **Encapsulation** | Private fields utilizing standard getters and setters across all model classes. |
| **Design Patterns** | Utilizes **Singleton** (`TextbookRepository.getInstance()`) and **Adapter/ViewHolder** (`TextbookAdapter`). |
| **Exception Handling** | Custom `DuplicateBookException` handled via `try/catch` blocks in `SellActivity` and the Repository. |

---

### 🤝 The Development Team (Group 9)

This system was engineered collaboratively by Group 9:

* **[Sydney0310](https://github.com/Sydney0310)** - Project setup, Gradle configuration, AndroidManifest, and final commits.
* **[Luke-Mthwazi](https://github.com/Luke-Mthwazi)** - Interfaces, abstract class design, and `Textbook` entity modeling.
* **Member 3** - `TextbookRepository` logic and `DuplicateBookException` handling.
* **Member 4** - `SellActivity` and `BrowseActivity` implementation.
* **[Anithasamkelisiwe-hue](https://github.com/Anithasamkelisiwe-hue)** - XML UI layouts and `RecyclerView` adapter integration.
* **[musa5070](https://github.com/musa5070)** - `BookDetailActivity` and `SplashActivity` implementation.

---

### 🚀 Quick Start Guide

**Prerequisites:** Android Studio (latest stable version), Android SDK API 24 or higher, and Git.

**1. Clone the repository:**
```bash
git clone [https://github.com/Sydney0310/CSC313-ASSIGNMENT2.git](https://github.com/Sydney0310/CSC313-ASSIGNMENT2.git)
