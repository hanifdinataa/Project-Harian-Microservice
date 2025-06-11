package com.example.teknologiinformasi.booking_service.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookingRabbitConfig {

    public static final String BOOKING_EXCHANGE = "booking.exchange";
    public static final String BOOKING_QUEUE = "booking.created.queue";
    public static final String BOOKING_ROUTING_KEY = "booking.created";

    @Bean
    public DirectExchange bookingExchange() {
        return new DirectExchange(BOOKING_EXCHANGE);
    }

    @Bean
    public Queue bookingQueue() {
        return new Queue(BOOKING_QUEUE);
    }

    @Bean
    public Binding bookingBinding(Queue bookingQueue, DirectExchange bookingExchange) {
        return BindingBuilder.bind(bookingQueue).to(bookingExchange).with(BOOKING_ROUTING_KEY);
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
