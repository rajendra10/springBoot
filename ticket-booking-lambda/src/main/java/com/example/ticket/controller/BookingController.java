package com.example.ticket.controller;

import com.example.ticket.model.Booking;
import com.example.ticket.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping({"/ticket-booking-lambda", "/default/ticket-booking-lambda"})
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping
    public Booking create(@RequestBody Booking booking) {
        return service.create(booking);
    }

    @GetMapping
    public List<Booking> list() {
        return service.findAll();
    }
    @GetMapping
    public String helthCheck() {
        return "TestHealth";
    }
}
