# TechConnect 2026 – Campus Event Registration App

## 📱 Project Overview

**TechConnect 2026 – Campus Event Registration** is an Android application developed to provide a simple and user-friendly platform for students to register for technical college events.

The application allows students to:

* View information about the TechConnect 2026 technical fest.
* Register for an event.
* Enter student details such as name, USN, and email.
* Select gender.
* Select an event category.
* Agree to event rules.
* Choose whether a participation certificate is required.
* Receive a registration-success notification.
* View a confirmation screen after successful registration.

The project demonstrates important Android development concepts such as **Activities, Intents, XML layouts, View Binding, UI widgets, input validation, Toast messages, Activity lifecycle methods, and Android notifications**.

---

## 🎯 Aim

To develop an Android application for campus event registration that demonstrates the use of basic Android UI components, multiple activities, input validation, intents, and notification services.

---

## ✨ Features

### 1. Home Screen

The home screen displays:

* College/event logo
* Event name – **TechConnect 2026**
* Description of the technical fest
* **Register Now** button

Clicking the **Register Now** button opens the registration screen.

### 2. Student Registration

Students can enter:

* Student Name
* USN
* Email

### 3. Gender Selection

Students can select one of the following:

* Male
* Female
* Other

A `RadioGroup` is used to make sure only one gender option can be selected.

### 4. Event Category

Students can select an event category:

* Coding Contest
* Robotics Workshop
* Paper Presentation

### 5. Event Rules

The student must agree to the event rules using a `CheckBox` before registration can be completed.

### 6. Certificate Option

A `ToggleButton` allows the student to select:

* Need Certificate
* No Certificate

### 7. Input Validation

The application checks whether:

* Name is entered.
* USN is entered.
* Email is entered.
* Gender is selected.
* Event category is selected.
* Event rules are accepted.

If any required information is missing, a `Toast` message is displayed.

### 8. Registration Notification

After successful registration, the application displays an Android notification:

> Registration Successful

The notification also indicates the selected event category.

### 9. Confirmation Screen

After registration, the user is redirected to a confirmation screen showing:

* Registration confirmation
* Student name
* Selected event category
* Certificate information

### 10. Activity Lifecycle Logging

The application demonstrates Android Activity lifecycle methods:

* `onCreate()`
* `onStart()`
* `onResume()`
* `onPause()`
* `onStop()`
* `onRestart()`
* `onDestroy()`

Log messages are generated using Android's `Log.d()` method.

---

## 🛠️ Technologies Used

| Technology            | Purpose                                 |
| --------------------- | --------------------------------------- |
| Kotlin                | Application programming language        |
| Android               | Application development platform        |
| XML                   | User interface design                   |
| Android Studio        | Development environment                 |
| View Binding          | Accessing XML views safely              |
| AndroidX              | Modern Android libraries                |
| Material Components   | UI components                           |
| ConstraintLayout      | Android layout support                  |
| Android Notifications | Registration notification               |
| Gradle                | Project build and dependency management |

---

## 📂 Project Structure

```text
CampusEventRegistration/
│
├── build.gradle
├── gradle.properties
├── settings.gradle
│
├── gradle/
│   └── wrapper/
│       └── gradle-wrapper.properties
│
├── app/
│   │
│   ├── build.gradle
│   ├── proguard-rules.pro
│   │
│   └── src/
│       └── main/
│           │
│           ├── AndroidManifest.xml
│           │
│           ├── java/
│           │   └── com/
│           │       └── techconnect/
│           │           └── campusevent/
│           │               ├── MainActivity.kt
│           │               ├── RegistrationActivity.kt
│           │               └── ConfirmationActivity.kt
│           │
│           └── res/
│               │
│               ├── drawable/
│               │   ├── ic_college_logo.xml
│               │   ├── ic_launcher_background.xml
│               │   └── ic_launcher_foreground.xml
│               │
│               ├── layout/
│               │   ├── activity_main.xml
│               │   ├── activity_registration.xml
│               │   └── activity_confirmation.xml
│               │
│               ├── mipmap-anydpi-v26/
│               │   ├── ic_launcher.xml
│               │   └── ic_launcher_round.xml
│               │
│               └── values/
│                   ├── colors.xml
│                   ├── strings.xml
│                   └── themes.xml
│
└── README.md
```

---

## 📄 Important Files

### `MainActivity.kt`

This is the first Activity launched when the application starts.

Responsibilities:

* Displays the home screen.
* Displays event information.
* Handles the **Register Now** button.
* Opens `RegistrationActivity`.
* Demonstrates Activity lifecycle callbacks.

Flow:

```text
MainActivity
     │
     │ Register Now
     ▼
RegistrationActivity
```

---

### `RegistrationActivity.kt`

This is the main registration screen.

Responsibilities:

* Collects student information.
* Validates user input.
* Handles gender selection.
* Handles event category selection.
* Checks event rules agreement.
* Handles certificate preference.
* Creates notification channel.
* Requests notification permission where required.
* Displays successful registration notification.
* Sends registration data to `ConfirmationActivity`.

---

### `ConfirmationActivity.kt`

This Activity displays the final registration confirmation.

It receives data from `RegistrationActivity` using an Android `Intent`.

Data passed includes:

```text
EXTRA_NAME
EXTRA_USN
EXTRA_EMAIL
EXTRA_GENDER
EXTRA_CATEGORY
EXTRA_CERTIFICATE
```

The confirmation screen then displays the student's registration information.

---

## 🎨 Layout Files

### `activity_main.xml`

Contains the home screen UI:

```text
College Logo
     ↓
TechConnect 2026
     ↓
Event Description
     ↓
Register Now
```

---

### `activity_registration.xml`

Contains the registration form:

```text
Student Name
     ↓
USN
     ↓
Email
     ↓
Gender
     ↓
Event Category
     ↓
Agree to Rules
     ↓
Certificate Preference
     ↓
Submit Registration
```

The layout uses several Android UI widgets including:

* `EditText`
* `TextView`
* `RadioGroup`
* `RadioButton`
* `CheckBox`
* `ToggleButton`
* `Button`
* `ScrollView`
* `LinearLayout`

---

### `activity_confirmation.xml`

Displays:

```text
Registration Confirmed!

Thank you, Student Name!

You have successfully registered for:
Selected Event

Certificate information

Back to Home
```

---

## 🔔 Notification System

The application uses Android's notification framework.

A notification channel is created using:

```text
registration_channel
```

The application requests the following permission on supported Android versions:

```text
POST_NOTIFICATIONS
```

After successful registration, the user receives a notification containing the selected event category.

Example:

```text
Registration Successful

You are successfully registered for Coding Contest
```

---

## 🔄 Application Flow

```text
             ┌─────────────────────┐
             │     App Launch      │
             └──────────┬──────────┘
                        │
                        ▼
             ┌─────────────────────┐
             │    MainActivity     │
             │     Home Screen     │
             └──────────┬──────────┘
                        │
                  Register Now
                        │
                        ▼
             ┌─────────────────────┐
             │ RegistrationActivity│
             │   Registration Form │
             └──────────┬──────────┘
                        │
                  Validate Data
                        │
                        ▼
             ┌─────────────────────┐
             │ Successful          │
             │ Registration        │
             └──────────┬──────────┘
                        │
             ┌──────────┴──────────┐
             │                     │
             ▼                     ▼
      ┌───────────────┐    ┌─────────────────┐
      │ Notification  │    │ Confirmation    │
      │   Generated   │    │    Activity     │
      └───────────────┘    └────────┬────────┘
                                    │
                                    ▼
                           ┌─────────────────┐
                           │   Back to Home  │
                           └─────────────────┘
```

---

## 🔗 Activity Communication

The application uses Android **Explicit Intents** to move between Activities.

### MainActivity → RegistrationActivity

```kotlin
val intent = Intent(this, RegistrationActivity::class.java)
startActivity(intent)
```

### RegistrationActivity → ConfirmationActivity

Registration data is passed using Intent extras:

```kotlin
val intent = Intent(this, ConfirmationActivity::class.java).apply {
    putExtra("EXTRA_NAME", name)
    putExtra("EXTRA_USN", usn)
    putExtra("EXTRA_EMAIL", email)
    putExtra("EXTRA_GENDER", gender)
    putExtra("EXTRA_CATEGORY", category)
    putExtra("EXTRA_CERTIFICATE", wantsCertificate)
}
```

---

## 🧩 Android UI Widgets Used

| Widget         | Usage                         |
| -------------- | ----------------------------- |
| `TextView`     | Display text                  |
| `EditText`     | Accept student input          |
| `Button`       | Perform actions               |
| `ImageView`    | Display college/event logo    |
| `RadioButton`  | Select one option             |
| `RadioGroup`   | Group radio buttons           |
| `CheckBox`     | Accept event rules            |
| `ToggleButton` | Select certificate preference |
| `ScrollView`   | Allow scrolling of content    |
| `LinearLayout` | Arrange UI components         |

---

## 🔍 Input Validation

Before registration is completed, the application performs validation.

### Empty fields

```kotlin
if (name.isEmpty() || usn.isEmpty() || email.isEmpty()) {
    Toast.makeText(
        this,
        "Please fill all fields",
        Toast.LENGTH_SHORT
    ).show()
    return
}
```

### Gender validation

```kotlin
if (genderId == -1) {
    Toast.makeText(
        this,
        "Please select your gender",
        Toast.LENGTH_SHORT
    ).show()
    return
}
```

### Event category validation

```kotlin
if (categoryId == -1) {
    Toast.makeText(
        this,
        "Please select an event category",
        Toast.LENGTH_SHORT
    ).show()
    return
}
```

### Rules validation

```kotlin
if (!binding.cbAgree.isChecked) {
    Toast.makeText(
        this,
        "You must agree to the event rules",
        Toast.LENGTH_SHORT
    ).show()
    return
}
```

---

## 📦 Dependencies

The project uses the following Android libraries:

```text
androidx.core:core-ktx:1.13.1
androidx.appcompat:appcompat:1.7.0
com.google.android.material:material:1.12.0
androidx.constraintlayout:constraintlayout:2.1.4
```

View Binding is enabled in the application:

```text
viewBinding true
```

---

## ⚙️ Requirements

To run this project, you need:

* Android Studio
* Android SDK
* JDK compatible with the project's Gradle configuration
* Android emulator or physical Android device
* Gradle build system

---

## 🚀 How to Run the Project

### Step 1 – Download/Extract the Project

Extract the project ZIP file.

```text
CampusEventRegistration
```

### Step 2 – Open in Android Studio

Open Android Studio and select:

```text
Open
```

Then select the:

```text
CampusEventRegistration
```

project folder.

### Step 3 – Gradle Sync

Allow Android Studio to synchronize the Gradle files and download the required dependencies.

### Step 4 – Connect a Device

You can either:

* Connect a physical Android phone with USB debugging enabled, or
* Start an Android Emulator.

### Step 5 – Run

Click the **Run ▶** button in Android Studio.

The application will start with the TechConnect 2026 home screen.

---

## 🧪 Testing

The following scenarios can be tested.

| Test Case                 | Expected Result                             |
| ------------------------- | ------------------------------------------- |
| Open application          | Home screen is displayed                    |
| Click Register Now        | Registration screen opens                   |
| Submit empty form         | Validation message displayed                |
| Do not select gender      | Gender validation message displayed         |
| Do not select event       | Event category validation message displayed |
| Do not accept rules       | Rules validation message displayed          |
| Fill all required details | Registration succeeds                       |
| Select certificate        | Confirmation shows certificate requested    |
| Do not select certificate | Confirmation shows no certificate requested |
| Successful registration   | Notification is generated                   |
| Click Back to Home        | Application returns to home/start state     |

---

## 🔐 Permissions

The application declares the notification permission:

```xml
<uses-permission
    android:name="android.permission.POST_NOTIFICATIONS" />
```

For Android versions that require runtime notification permission, the application requests permission from the user.

---

## 🏗️ Architecture

The current project follows a simple **Activity-based Android architecture**.

```text
Presentation Layer
       │
       ├── MainActivity
       │
       ├── RegistrationActivity
       │
       └── ConfirmationActivity
       │
       ▼
     XML UI
```

The application does not currently use a database or remote backend. Registration information is passed between Activities using `Intent` extras.

---

## 💾 Database

This version of the project **does not use a database**.

The entered registration details are used during the current application flow and passed from the registration screen to the confirmation screen.

For a future version, a database such as **Room/SQLite** or a cloud backend such as Firebase could be added to permanently store registrations.

---

## 🔮 Future Enhancements

The application can be improved by adding:

* Student login and authentication
* Firebase Authentication
* Database storage for registrations
* Admin dashboard
* Event management
* Multiple event dates and timings
* Seat/participant limits
* QR-code based registration confirmation
* Email confirmation
* Digital participation certificate
* Registration history
* Search and filter functionality
* Student profile
* Event reminders
* Firebase Cloud Messaging
* Improved Material Design UI

---

## 📚 Learning Outcomes

After completing this project, the developer can understand:

1. Android Activity lifecycle.
2. Creating Android layouts using XML.
3. Using common Android UI widgets.
4. Handling button click events.
5. Performing form validation.
6. Using `Toast` messages.
7. Passing data using `Intent`.
8. Using View Binding.
9. Creating Android notification channels.
10. Requesting runtime permissions.
11. Using Android logging with `Log.d()`.
12. Navigating between multiple Activities.

---

## 👨‍💻 Project Information

**Project Name:** TechConnect 2026 – Campus Event Registration

**Application Type:** Android Application

**Language:** Kotlin

**UI:** XML

**Platform:** Android

**Build System:** Gradle

**Package Name:**

```text
com.techconnect.campusevent
```

---

## 📌 Conclusion

The **TechConnect 2026 – Campus Event Registration App** provides a simple digital solution for registering students for campus technical events.

The project demonstrates fundamental Android development concepts including multiple Activities, XML-based UI design, UI widgets, input validation, Intent-based data transfer, notifications, runtime permissions, View Binding, and Activity lifecycle management.

It can be further expanded into a complete campus event management system by adding database storage, authentication, administrator functionality, online event management, and digital certificates.

---

## 📄 License

This project is intended for **educational and academic purposes**.

You are free to modify and improve the project for learning and college project requirements.
