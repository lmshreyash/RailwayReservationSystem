# 🚆 Railway Reservation System

This is a simple console-based **Railway Reservation System** built using Java. It allows users to:

- Add new trains
- View available trains
- Modify or delete train records
- Book tickets
- Cancel bookings
- View booked train details along with user information

All data is stored in local text files (`trains.txt`, `bookings.txt`) using file-based I/O, and the project is structured using Java packages (`model`, `dao`, `util`, `main`).

---

## 📁 Project Structure
RailwayReservationSystem/
│
├── src/
│   ├── main/           # Contains Main.java (application entry point)
│   ├── model/          # Train.java (data model)
│   ├── dao/            # TrainDAO.java (data access logic)
│   └── util/           # FileHelper.java (file handling)
├── trains.txt          # Stores train records
├── bookings.txt        # Stores bookings
└── README.md           # You’re reading it!

---

## ✅ Prerequisites

Make sure you have:

- **Java JDK 8 or above** installed
- A terminal or command prompt
- A text/code editor (e.g., VS Code, IntelliJ) — optional

---

## 🚀 How to Run the Project

Follow these steps:

1. **Clone or download the project** to your local machine.

2. **Open a terminal and navigate to the `src` directory**:

```bash
cd /your-path/to/RailwayReservationSystem/src



##Compile the Java source files:

```bash
javac main/Main.java model/Train.java dao/TrainDAO.java util/FileHelper.java

##Run the application
```bash
java main.Main
