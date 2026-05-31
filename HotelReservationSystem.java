package com.codeAlpha;

import java.io.*;
import java.util.*;

public class HotelReservationSystem {

    static ArrayList<Room> rooms = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static final String FILE_NAME = "bookings.txt";

    public static void main(String[] args) {

        initializeRooms();

        while (true) {

            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View Booking Details");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewRooms();
                    break;

                case 2:
                    bookRoom();
                    break;

                case 3:
                    cancelReservation();
                    break;

                case 4:
                    viewBooking();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    private static void initializeRooms() {

        rooms.add(new Room(101, "Standard", 2000, true));
        rooms.add(new Room(102, "Standard", 2000, true));

        rooms.add(new Room(201, "Deluxe", 3500, true));
        rooms.add(new Room(202, "Deluxe", 3500, true));

        rooms.add(new Room(301, "Suite", 5000, true));
        rooms.add(new Room(302, "Suite", 5000, true));
    }

    private static void viewRooms() {

        System.out.println("\nAvailable Rooms:");

        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(room);
            }
        }
    }

    private static void bookRoom() {

        sc.nextLine();

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Room Category (Standard/Deluxe/Suite): ");
        String category = sc.nextLine();

        Room selectedRoom = null;

        for (Room room : rooms) {
            if (room.isAvailable() &&
                    room.getCategory().equalsIgnoreCase(category)) {

                selectedRoom = room;
                break;
            }
        }

        if (selectedRoom == null) {
            System.out.println("No Room Available!");
            return;
        }

        System.out.println("\nRoom Found:");
        System.out.println(selectedRoom);

        System.out.println("\nProcessing Payment...");
        System.out.println("Payment Successful!");

        String bookingId = "BK" + System.currentTimeMillis();

        Reservation reservation =
                new Reservation(bookingId, name, selectedRoom);

        saveBooking(reservation);

        selectedRoom.setAvailable(false);

        System.out.println("\nBooking Confirmed!");
        System.out.println("Booking ID: " + bookingId);
    }

    private static void saveBooking(Reservation reservation) {

        try (BufferedWriter bw =
                     new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            bw.write(reservation.toString());
            bw.newLine();

        } catch (IOException e) {
            System.out.println("Error Saving Booking!");
        }
    }

    private static void viewBooking() {

        sc.nextLine();

        System.out.print("Enter Booking ID: ");
        String bookingId = sc.nextLine();

        try (BufferedReader br =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data[0].equals(bookingId)) {

                    System.out.println("\nBooking Found");
                    System.out.println("Booking ID: " + data[0]);
                    System.out.println("Customer: " + data[1]);
                    System.out.println("Room No: " + data[2]);
                    System.out.println("Category: " + data[3]);
                    System.out.println("Price: ₹" + data[4]);

                    return;
                }
            }

            System.out.println("Booking Not Found!");

        } catch (IOException e) {
            System.out.println("File Error!");
        }
    }

    private static void cancelReservation() {

        sc.nextLine();

        System.out.print("Enter Booking ID: ");
        String bookingId = sc.nextLine();

        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp.txt");

        boolean found = false;

        try (
                BufferedReader br =
                        new BufferedReader(new FileReader(inputFile));

                BufferedWriter bw =
                        new BufferedWriter(new FileWriter(tempFile))
        ) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data[0].equals(bookingId)) {

                    found = true;

                    int roomNumber =
                            Integer.parseInt(data[2]);

                    for (Room room : rooms) {
                        if (room.getRoomNumber() == roomNumber) {
                            room.setAvailable(true);
                        }
                    }

                    continue;
                }

                bw.write(line);
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error!");
        }

        inputFile.delete();
        tempFile.renameTo(inputFile);

        if (found)
            System.out.println("Reservation Cancelled!");
        else
            System.out.println("Booking ID Not Found!");
    }
}
