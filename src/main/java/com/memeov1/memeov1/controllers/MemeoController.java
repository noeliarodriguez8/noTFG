package com.memeov1.memeov1.controllers;

import com.memeov1.memeov1.services.PostService;
import com.memeov1.memeov1.services.ConversationService;
import com.memeov1.memeov1.services.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/memeo")
public class MemeoController {

    public final UserService userService;
    public final ConversationService conversationService;
    public final PostService postService;

    public MemeoController(UserService userService, ConversationService conversationService,
            PostService postService) {
        this.userService = userService;
        this.conversationService = conversationService;
        this.postService = postService;
    }

    // login y signin ??????
    @PostMapping("/signin")
    public String signin(@RequestParam String param) {
        return new String();
    }

    @GetMapping("/login")
    public String index(@RequestParam String param) {
        return new String();
    }

    // listar post (inicio de usuario)
    @GetMapping("/feed")
    public String getFeed(Integer userID) {
        return new String();
    }

    // test
    @GetMapping("/saludo")
    public ResponseEntity<String> getSaludo() {
        String saludo = "Hola mundo";
        return ResponseEntity.ok(saludo); // Devuelve 200 OK con la frase "Hola mundo"
    }

}
