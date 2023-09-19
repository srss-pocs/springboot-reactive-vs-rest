package com.example.reactive.webflux.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reactive.webflux.dto.Customer;
import com.example.reactive.webflux.service.CustomerService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;


    @GetMapping
    public List<Customer> getAllCustomers() {
        return service.loadAllCustomers();
    }

    @GetMapping(value = "/stream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllCustomersStream() {
        return service.loadAllCustomersStream();
    }
    
    @GetMapping(value = "/json/stream",produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Customer> getAllCustomersJsonStream() {
        return service.loadAllCustomersStream();
    }
}
