package com.example.tinderappmaven.controller;


import com.example.tinderappmaven.model.Profile;
import com.example.tinderappmaven.model.Reactions;
import com.example.tinderappmaven.respository.ProfileRepository;
import com.example.tinderappmaven.respository.ReactionsRepository;
import com.example.tinderappmaven.respository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
@Slf4j
public class HomeController {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final ReactionsRepository reactionsRepository;

    public HomeController(UserRepository userRepository, ProfileRepository profileRepository, ReactionsRepository reactionsRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
        this.reactionsRepository = reactionsRepository;
    }

    @GetMapping(value = "/main-page")
    public String goToHome(Principal principal, ModelMap modelMap) {
        modelMap.put("name", userRepository.findByEmail(principal.getName()).getUsername());
        modelMap.put("profiles",profileRepository.findAll());
        return "main-page";
    }

    @PostMapping(value = "/like")
    public String likeButton(ModelMap modelMap,Principal principal){
        log.atInfo().log("in like button");
        List<Profile> profiles = (List<Profile>) modelMap.get("profiles");
        assert profiles != null;
        Profile profile = profiles.get(0);
        reactionsRepository.save(new Reactions(reactionsRepository.count(),userRepository.findByEmail(principal.getName()).getId(),profile.getId(),true));
        modelMap.put("profiles",profiles.remove(0));
        return "redirect:/main-page";
    }
}
