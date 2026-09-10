📱 Campus Event Registration

Campus Event Registration is an Android application developed using Kotlin and XML that allows students to register for different categories of a technical campus event.

The app provides a simple registration workflow where students enter their details, select their gender and event category, agree to the event rules, optionally request a participation certificate, and receive a registration confirmation notification.

✨ Features

- 🏫 Technical event information screen
- 📝 Student registration form
- 👤 Student name, USN and email input
- ⚧️ Gender selection
- 💻 Event category selection
- ☑️ Event rules agreement
- 📜 Participation certificate option
- 🔔 Registration success notification
- ✅ Registration confirmation screen
- 🔄 Navigation between multiple activities
- 📱 Android lifecycle logging

🎯 Event Categories

Students can register for:

- Coding Contest
- Robotics Workshop
- Paper Presentation

🛠️ Technologies Used

- Kotlin
- Android Studio
- XML
- Android SDK
- Material Components
- AndroidX
- Gradle
- View Binding
- Android Notifications

📂 Project Structure

CampusEventRegistration/
│
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/techconnect/campusevent/
│   │       │       ├── MainActivity.kt
│   │       │       ├── RegistrationActivity.kt
│   │       │       └── ConfirmationActivity.kt
│   │       │
│   │       ├── res/
│   │       │   ├── drawable/
│   │       │   ├── layout/
│   │       │   │   ├── activity_main.xml
│   │       │   │   ├── activity_registration.xml
│   │       │   │   └── activity_confirmation.xml
│   │       │   ├── mipmap-anydpi-v26/
│   │       │   └── values/
│   │       │       ├── colors.xml
│   │       │       ├── strings.xml
│   │       │       └── themes.xml
│   │       │
│   │       └── AndroidManifest.xml
│   │
│   ├── build.gradle
│   └── proguard-rules.pro
│
├── gradle/
├── build.gradle
├── gradle.properties
├── settings.gradle
└── README.md

🔄 Application Flow

Start Application
       ↓
Event Information Screen
       ↓
Click "Register Now"
       ↓
Registration Form
       ↓
Enter Student Details
       ↓
Select Gender
       ↓
Select Event Category
       ↓
Agree to Event Rules
       ↓
Select Certificate Option
       ↓
Submit Registration
       ↓
Registration Success Notification
       ↓
Confirmation Screen

📱 Screens

1. Event Information Screen

The home screen displays:

- College/event logo
- Event name
- Event description
- Register Now button

2. Registration Screen

Students provide:

- Student Name
- USN
- Email
- Gender
- Event Category
- Event Rules Agreement
- Certificate Requirement

The application validates the required fields before allowing registration.

3. Confirmation Screen

After successful registration, the application displays:

- Registration confirmation message
- Student name
- Selected event category
- Certificate requirement status

A notification is also generated to inform the student that the registration was successful.

🔔 Notification

The application uses Android's notification system to display a registration success notification.

Example:

Registration Successful

You are successfully registered for Coding Contest

For Android 13 and above, the application requests the required notification permission.

✅ Validation

The registration form checks that:

- Student name is entered
- USN is entered
- Email is entered
- Gender is selected
- Event category is selected
- Event rules are accepted

If any required information is missing, the application displays an appropriate message using a Toast.

🧩 Activities

MainActivity

Responsible for:

- Displaying the event information
- Navigating the user to the registration screen

RegistrationActivity

Responsible for:

- Collecting student information
- Validating registration details
- Creating the notification channel
- Sending the registration notification
- Passing registration information to the confirmation activity

ConfirmationActivity

Responsible for:

- Displaying successful registration details
- Showing the selected event category
- Displaying certificate preference
- Returning to the home screen

📋 Requirements

To run this project, you need:

- Android Studio
- Android SDK
- JDK compatible with the Android Gradle configuration
- Android device or emulator

🚀 How to Run

1. Clone the repository:

git clone https://github.com/your-username/CampusEventRegistration.git

2. Open the project in Android Studio.

3. Allow Gradle to sync and download the required dependencies.

4. Connect an Android device or start an Android Emulator.

5. Click Run ▶️ in Android Studio.

🔧 Build Configuration

The project uses:

- Gradle 8.6
- AndroidX
- Kotlin
- Material Components

🔮 Future Enhancements

The project can be extended with:

- Firebase database integration
- Online registration storage
- Student login and authentication
- Admin dashboard
- QR code generation for registered students
- Event seat availability
- Email confirmation
- Registration history
- Firebase Cloud Messaging
- Event reminder notifications

👨‍💻 Author

Shubham Kondikire

MCA Student | Android & Software Development

📄 License

This project is developed for educational and academic purposes.
