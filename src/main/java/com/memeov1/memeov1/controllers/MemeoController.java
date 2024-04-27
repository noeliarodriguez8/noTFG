package com.memeov1.memeov1.controllers;

import com.memeov1.memeov1.services.CommunityService;
import com.memeov1.memeov1.services.DMService;
import com.memeov1.memeov1.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/memeo")
public class MemeoController {

    public final UserService userService;
    public final DMService dmService;
    public final CommunityService communityService;

    public MemeoController(UserService userService, DMService dmService, CommunityService communityService) {
        this.userService = userService;
        this.dmService = dmService;
        this.communityService = communityService;
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

}
