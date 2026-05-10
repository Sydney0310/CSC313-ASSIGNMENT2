# Method Master's Book Store
### UFH Textbook Marketplace - Android Application

CSC313: Object-Oriented Programming - Assignment 2
University of Fort Hare | Department of Computer Science | Group 9 | 2026

---

## About the App

Method Master's Book Store is an Android marketplace application that allows University of Fort Hare students to buy and sell textbooks. Sellers can list their textbooks with full details including banking information for payment, and buyers can browse and search for available books in real time.

The app was built using Java in Android Studio and demonstrates core Object-Oriented Programming concepts including interfaces, abstract classes, inheritance, encapsulation, polymorphism, and custom exception handling.

---

## Features

- Browse Textbooks - View all available textbooks in a clean card list
- Sell a Textbook - List a book with title, author, module code, price, copies, and banking details
- Search - Search by book title or seller name in real time
- Duplicate Prevention - Prevents the same book from being listed twice by the same seller
- Book Details - View full listing details including seller contact and banking info
- Input Validation - All fields validated with meaningful error messages

---

## Project Structure

```
com.bookstore/
├── abstracts/
│   ├── AbstractListing.java
│   └── BaseItem.java               Abstract class with getInfo() abstract method
├── activities/
│   ├── MainActivity.java           Home screen
│   ├── BrowseActivity.java         Browse and search textbooks
│   ├── SellActivity.java           List a textbook for sale
│   ├── BookDetailActivity.java     View full book details
│   └── SplashActivity.java         App splash screen
├── adapters/
│   └── TextbookAdapter.java        RecyclerView adapter using ViewHolder pattern
├── exceptions/
│   └── DuplicateBookException.java Custom exception for duplicate listings
├── interfaces/
│   ├── Listable.java               validate() and listItem() contract
│   ├── Searchable.java             searchByTitle() and searchBySeller() contract
│   └── IPayable.java               getBankInfo() contract
├── listings/
│   └── TextbookListing.java        Implements Listable and IPayable
├── models/
│   └── Textbook.java               Extends BaseItem with full encapsulation
└── repository/
    └── TextbookRepository.java     Singleton pattern, implements Searchable
```

---

## OOP Concepts Demonstrated

| Concept | Implementation |
|---|---|
| Interface | Listable, Searchable, IPayable |
| Abstract Class | BaseItem with abstract getInfo() method |
| Inheritance | Textbook extends BaseItem |
| Polymorphism | TextbookRepository accessed via Searchable reference |
| Encapsulation | Private fields with getters and setters in all model classes |
| Custom Exception | DuplicateBookException extends Exception |
| Exception Handling | try/catch blocks in SellActivity and TextbookRepository |
| Singleton Pattern | TextbookRepository.getInstance() |
| Adapter Pattern | TextbookAdapter with ViewHolder for RecyclerView |

---

## Tech Stack

| Technology | Details |
|---|---|
| Language | Java |
| IDE | Android Studio |
| Build System | Gradle (Kotlin DSL) |
| Min SDK | API 24 (Android 7.0 Nougat) |
| Target SDK | API 36 |
| UI Components | RecyclerView, CardView, Material Design |
| Version Control | Git and GitHub |

---

## Dependencies

```
implementation 'androidx.appcompat:appcompat:1.6.1'
implementation 'com.google.android.material:material:1.11.0'
implementation 'androidx.recyclerview:recyclerview:1.3.2'
implementation 'androidx.cardview:cardview:1.0.0'
implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
```

---

## Getting Started

### Prerequisites
- Android Studio (latest stable version)
- Android SDK API 24 or higher
- Git

### Installation

1. Clone the repository

```
git clone https://github.com/Sydney0310/CSC313-ASSIGNMENT2.git
```

2. Open in Android Studio
   - Open Android Studio
   - Click File then Open
   - Navigate to the cloned folder and click OK

3. Sync Gradle
   - Wait for Gradle sync to complete
   - Click Sync Now if prompted

4. Run the app
   - Connect an Android device or start an emulator
   - Click the Run button

---

## Data Flow

```
User fills form in SellActivity
        |
Textbook object is created
        |
TextbookListing wraps Textbook, calls validate() then listItem()
        |
TextbookRepository.addTextbook() is called
        |
isDuplicate() check - throws DuplicateBookException if duplicate found
        |
Book added to in-memory list, success dialog shown to user
        |
BrowseActivity.onResume() calls getAllTextbooks(), RecyclerView updated
        |
User clicks a card, Intent with extras starts BookDetailActivity
```

---

## Group Members - Group 9

| Name | GitHub | Contribution |
|---|---|---|
| Sydney0310 | https://github.com/Sydney0310 | Project setup, Gradle configuration, AndroidManifest, final commit |
| Luke-Mthwazi | https://github.com/Luke-Mthwazi | Interfaces, abstract class, Textbook model |
| Okuhlegenge | https://github.com/Okuhlegenge | TextbookRepository, DuplicateBookException |
| Nkosinathi-Mbewana |  https://github.com/Nkosinathi-Mbewana | SellActivity, BrowseActivity |
| Anithasamkelisiwe-hue |  https://github.com/Anithasamkelisiwe-hue | XML layouts, RecyclerView adapter |
| musa5070 |  https://github.com/musa5070 | BookDetailActivity, SplashActivity |

---

## Assignment Requirements

- Browse all available textbooks for sale - Implemented
- List a textbook with number of copies, selling price, and banking information - Implemented
- Submit and confirm listings with duplicate prevention - Implemented
- Search by seller name and book title - Implemented
- OOP concepts: Interfaces, Abstract classes, Inheritance, Encapsulation - Implemented
- Exception handling with custom DuplicateBookException - Implemented
- Smooth and user-friendly experience - Implemented
- GitHub repository with all group members and lecturer added - Implemented

---

## License

This project was created for academic purposes as part of CSC313: Object-Oriented Programming at the University of Fort Hare. All rights reserved. Group 9, 2026.
