package com.example.teknologiinformasi.booking_service.service;

import com.example.teknologiinformasi.booking_service.model.Booking;
import com.example.teknologiinformasi.booking_service.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long id, Booking bookingDetails) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id " + id));

        booking.setCustomerId(bookingDetails.getCustomerId());
        booking.setMovieId(bookingDetails.getMovieId());
        booking.setBookingDate(bookingDetails.getBookingDate());
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id " + id));
        bookingRepository.delete(booking);
    }
}
