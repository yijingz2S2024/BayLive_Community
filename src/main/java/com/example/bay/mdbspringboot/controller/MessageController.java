package com.example.bay.mdbspringboot.controller;

import com.example.bay.mdbspringboot.model.Community;
import com.example.bay.mdbspringboot.model.Message;
import com.example.bay.mdbspringboot.service.CommunityService;
import com.example.bay.mdbspringboot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/messages")
@CrossOrigin(origins = "http://localhost:3000")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping
    public Message addMessage(@RequestBody Message message) {
        return messageService.addMessage(message);
    }
}
