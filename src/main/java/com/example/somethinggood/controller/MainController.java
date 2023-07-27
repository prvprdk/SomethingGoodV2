package com.example.somethinggood.controller;


import com.example.somethinggood.domain.Message;
import com.example.somethinggood.repo.MessageRepo;
import com.example.somethinggood.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    CustomUserService customUserService;
    @Autowired
    MessageRepo messageRepo;
    @Value("${spring.profile.active:prod}")
    private String profile;

    @GetMapping
    public String mainPage (Model model, @AuthenticationPrincipal OidcUser user){
        HashMap <Object, Object> data = new HashMap<>();
        if (user != null){
            data.put("profile", customUserService.convertedUser(user));

            List<Message> messageList = messageRepo.findAll().stream().filter(message -> {
                return !Objects.equals(message.getAuthor().getId(), customUserService.convertedUser(user).getId());
            }).toList();



            data.put("messages",messageList);
        }


        model.addAttribute("frontendData", data);
        model.addAttribute("isDevMode", "dev".equals(profile));
        return "index";
    }


    }
