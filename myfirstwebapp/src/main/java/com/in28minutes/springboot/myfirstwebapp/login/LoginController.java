package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.springboot.myfirstwebapp.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@SessionAttributes("name")
public class LoginController {

    private final AuthenticationService authenticationService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String welcome(@RequestParam final String name, @RequestParam final String password, ModelMap model) {

        Boolean isAuthenticate = this.authenticationService.authenticate(name, password);

        if(Boolean.TRUE.equals(isAuthenticate)) {
            model.put("name", name);
            return "welcome";
        }

        model.put("loginError", "Invalid Credentials! Please try again.");
        return "login";
    }

}
