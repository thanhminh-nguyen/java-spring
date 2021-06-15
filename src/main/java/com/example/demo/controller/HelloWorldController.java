package com.example.demo.controller;

import com.example.demo.entity.Contact;
import com.example.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

    private ContactService contactService;

    @Autowired
    public HelloWorldController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        Iterable<Contact> allContact = contactService.getAllContact();

        model.addAttribute("allContact", allContact);
        return "hello.html";
    }
}
