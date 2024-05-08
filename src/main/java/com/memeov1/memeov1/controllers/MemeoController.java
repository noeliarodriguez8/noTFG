package com.memeov1.memeov1.controllers;

import com.memeov1.memeov1.services.PostService;
import com.memeov1.memeov1.entities.User;
import com.memeov1.memeov1.services.ConversationService;
import com.memeov1.memeov1.services.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@CrossOrigin(origins = "", allowedHeaders = "")
@RequestMapping("/memeo/api")
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
        // retornar vista
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

    // ---------------------- USER ----------------------------
    @PostMapping("/createuser")
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }

    // no necesitamos un getusers

    @GetMapping("/getuser/{userID}")
    public User getUser(@PathVariable Integer userID) {
        return userService.read(userID);
    }

    @PutMapping("/updateuser/{userID}")
    public User updateUser(@PathVariable Integer userID, @RequestBody User user) {
        return userService.update(userID, user);
    }

    @DeleteMapping("/deleteuser/{userID}")
    public String deleteUser(@PathVariable Integer userID) {
        return userService.delete(userID);
    }

}
