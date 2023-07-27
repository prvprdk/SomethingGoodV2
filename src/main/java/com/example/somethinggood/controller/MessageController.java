package com.example.somethinggood.controller;


import com.example.somethinggood.domain.Message;
import com.example.somethinggood.domain.Views;
import com.example.somethinggood.dto.EventType;
import com.example.somethinggood.dto.ObjectType;
import com.example.somethinggood.repo.MessageRepo;
import com.example.somethinggood.service.CustomUserService;
import com.example.somethinggood.util.WsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.BiConsumer;


@RestController
@RequestMapping("message")
public class MessageController {
    @Autowired
    private final MessageRepo messageRepo;
    private final BiConsumer<EventType, Message> wsSender;
    @Autowired
    private final CustomUserService customUserService;

    public MessageController(MessageRepo messageRepo, WsSender wsSender, CustomUserService customUserService) {
        this.messageRepo = messageRepo;
        this.wsSender = wsSender.getSender(ObjectType.MESSAGE, Views.Id.class);
        this.customUserService = customUserService;

    }

    @PostMapping
    public void createMessage(@RequestBody Message message, @AuthenticationPrincipal OidcUser user) {
        message.setAuthor(customUserService.convertedUser(user));
        Message messageFromDb = messageRepo.save(message);
        wsSender.accept(EventType.CREATE, messageFromDb);
    }

}
