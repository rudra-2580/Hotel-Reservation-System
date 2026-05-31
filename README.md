# Hotel-Reservation-System

📌 Project Overview

The Hotel Reservation System is a Java-based application designed to simplify hotel room booking and management. The system allows users to search available rooms, make reservations, cancel bookings, view booking details, and simulate payments. Room availability and reservation records are stored using File I/O (or a database), ensuring data persistence between program executions.

This project demonstrates Object-Oriented Programming (OOP), file handling, data management, and real-world system design concepts in Java.

🚀 Features
Room Management
View available hotel rooms.
Categorized room types:
Standard Room
Deluxe Room
Suite Room
Display room number, type, price, and availability.
Reservation Management
Book available rooms.
Generate unique booking IDs.
Store customer information.
Cancel existing reservations.
Update room availability automatically.
Payment Simulation
Simulate hotel payment processing.
Display payment confirmation.
Generate booking receipt.
Booking Details
View reservation details.
Search bookings using Booking ID.
Display customer and room information.
Data Persistence
Store room and booking information using File I/O.
Preserve booking records after program restart.
Easy migration to a database system in future versions.
🛠️ Technologies Used
Java
Object-Oriented Programming (OOP)
File Handling (File I/O)


⚙️ System Workflow
1. Search Rooms

Users can browse available rooms based on room category and availability.

2. Make Reservation

Users enter:

Customer Name
Room Type
Number of Guests
Stay Duration

The system:

Allocates an available room
Generates a Booking ID
Saves booking information
3. Payment Processing

The user completes a simulated payment process.

The system:

Displays payment success message
Confirms reservation
Updates room availability
4. View Booking

Users can:

Search using Booking ID
View booking details and payment status
5. Cancel Reservation

Users can:

Enter Booking ID
Cancel reservation
Restore room availability
🏗️ OOP Design
Room Class

Responsible for:

Room Number
Room Type
Room Price
Availability Status
Reservation Class

Responsible for:

Booking ID
Customer Name
Room Details
Reservation Status
Payment Class

Responsible for:

Payment Amount
Payment Status
Transaction Simulation
BookingManager Class

Responsible for:

Booking Operations
Cancellation Operations
File Handling
Data Storage
💾 Data Storage
Room Data Example
101,Standard,2000,true
102,Standard,2000,true
201,Deluxe,3500,true
301,Suite,5000,true
Booking Data Example
BK1001,Rudra Narayan Sahoo,201,Deluxe,3500,Confirmed
BK1002,Alice,101,Standard,2000,Confirmed

🔮 Future Enhancements
Database Integration (MySQL/PostgreSQL)
Java Swing GUI
JavaFX Interface
Online Payment Gateway Integration
Customer Login System
Admin Dashboard
Room Filtering by Price
Email Confirmation System
Multi-Hotel Support
Booking Analytics Dashboard
Collections Framework (ArrayList)
Exception Handling
Scanner Class
