package com.example.ticket.service;

import com.example.ticket.model.Booking;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookingService {

    private final Map<String, Booking> store = new ConcurrentHashMap<>();
    private final AtomicLong idGen = new AtomicLong(1);

    public Booking create(Booking booking) {
        String id = String.valueOf(idGen.getAndIncrement());
        booking.setId(id);
        store.put(id, booking);
        return booking;
    }

    public List<Booking> findAll() {
        return new ArrayList<>(store.values());
    }
}
