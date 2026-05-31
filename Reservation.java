package com.codeAlpha;

public class Reservation {

    private String bookingId;
    private String customerName;
    private Room room;

    public Reservation(String bookingId, String customerName, Room room) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.room = room;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Room getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return bookingId + "," +
                customerName + "," +
                room.getRoomNumber() + "," +
                room.getCategory() + "," +
                room.getPrice();
    }
}
