package com.example.Uniapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
@RestController
public class dateController {
    @GetMapping("/currentDate")
    public Date getCurrnetDate(){
        return new Date();
    }
    @GetMapping("/currentLocalDate")
    public LocalDate getCurrentLocalDate() {
        return LocalDate.now();
    }
}
