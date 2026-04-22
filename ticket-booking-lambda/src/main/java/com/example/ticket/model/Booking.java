package com.example.ticket.model;

public class Booking {

    private String id;
    private String eventName;
    private int seats;
    private String customerName;

    public Booking() {
    }

    public Booking(String id, String eventName, int seats, String customerName) {
        this.id = id;
        this.eventName = eventName;
        this.seats = seats;
        this.customerName = customerName;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getEventName() { return eventName; }
    public void setEventName(String eventName) { this.eventName = eventName; }

    public int getSeats() { return seats; }
    public void setSeats(int seats) { this.seats = seats; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
}
